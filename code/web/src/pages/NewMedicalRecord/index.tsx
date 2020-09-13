import React, { useEffect, useCallback, useState, useRef } from 'react'
import { Link } from 'react-router-dom'
import { Form } from '@unform/web'
import { FormHandles } from '@unform/core'
import * as Yup from 'yup'
import crypto from 'crypto'

import { FiArrowLeft } from 'react-icons/fi'
import {
  FaWeight,
  FaTemperatureHigh,
  FaAllergies,
  FaHospitalAlt,
} from 'react-icons/fa'
import { GiBodyHeight, GiWaterDrop, GiCycle } from 'react-icons/gi'

import api from '../../services/api'
import { useToast } from '../../hooks/toast'
import { useAuth } from '../../hooks/auth'
import getValidationErrors from '../../utils/getValidationErrors'

import Input from '../../components/Input'
import CheckBox from '../../components/CheckBox'
import Select from '../../components/Select'
import MultilineInput from '../../components/MultilineInput'

import { Container, Content } from './styles'
import Button from '../../components/Button'

interface IHospitals {
  id: number
  name: string
}

interface IMedicalRecordFormData {
  weight: string
  height: string
  bloodPressure: number
  bodyTemperature: number
  allergy: string
  lastCycle?: string
  isPregnant?: boolean
  hospitalId: string
  referral: {
    color: string
    call: string
  }
}

interface IHandleSubmitMedicalRecordCallBack {
  (data: Omit<IMedicalRecordFormData, 'referral'>): void
}

interface IHandleFormValuesCallBack {
  (data: Omit<IMedicalRecordFormData, 'referral'>): IMedicalRecordFormData
}

const NewMedicalRecord: React.FC = () => {
  const formRef = useRef<FormHandles>(null)

  const [hospitals, setHospitals] = useState<IHospitals[]>([])

  const { user } = useAuth()
  const { addToast } = useToast()

  const handleHospitals = useCallback(async () => {
    const { data } = await api.get<IHospitals[]>('hospital')

    setHospitals(oldValue => [...oldValue, ...data])
  }, [])

  const handleFormValues = useCallback<IHandleFormValuesCallBack>(data => {
    const { bodyTemperature } = data

    const color =
      bodyTemperature <= 36.9
        ? 'verde'
        : bodyTemperature <= 37.9
        ? 'amarelo'
        : 'vermelho'

    return {
      ...data,
      referral: {
        color,
        call: crypto.randomBytes(8).toString(),
      },
    }
  }, [])

  const handleSubmit = useCallback<IHandleSubmitMedicalRecordCallBack>(
    async data => {
      formRef.current?.setErrors({})

      const formData = handleFormValues(data)

      try {
        const schema = Yup.object().shape({
          weight: Yup.string()
            .matches(
              /^[\d.?!]+$/,
              'Somente números válidos e/ou com o uso do pontos',
            )
            .required('Peso obrigatório'),

          height: Yup.string()
            .matches(
              /^[\d.?!]+$/,
              'Somente números válidos e/ou com o uso do pontos',
            )
            .required('Altura obrigatório'),

          bloodPressure: Yup.string()
            .matches(
              /^[\d.?!]+$/,
              'Somente números válidos e/ou com o uso do pontos',
            )
            .required('Pressão sanguínea obrigatória'),

          bodyTemperature: Yup.string()
            .matches(
              /^[\d.?!]+$/,
              'Somente números válidos e/ou com o uso do pontos',
            )
            .required('Temperatura obrigatória'),

          allergy: Yup.string(),

          lastCycle: Yup.string().required(),

          isPregnant: Yup.boolean(),

          hospitalId: Yup.string().required(),

          referral: Yup.object().shape({
            color: Yup.string(),
            call: Yup.string(),
          }),
        })

        console.log(formData)

        await schema.validate(formData, {
          abortEarly: false,
        })

        await api.post('medical_records', formData)

        addToast({
          title: 'Ficha cadastrada com sucesso',
          description:
            'A sua ficha foi cadastrada no nosso sistema com sucesso!',
          type: 'success',
        })
      } catch (err) {
        if (err instanceof Yup.ValidationError) {
          const errors = getValidationErrors(err)

          formRef.current?.setErrors(errors)

          return
        }

        addToast({
          title: 'Erro ao cadastrar a sua ficha',
          description:
            'Ocorreu um erro ao cadastrar a sua ficha médica, tente novamente mais tarde.',
          type: 'error',
        })
      }
    },
    [addToast, handleFormValues],
  )

  useEffect(() => {
    handleHospitals()
  }, [handleHospitals])

  return (
    <Container>
      <header>
        <div>
          <Link to="/dashboard">
            <FiArrowLeft />
          </Link>
          <h1>Registrar nova ficha médica</h1>
        </div>
      </header>

      <Content>
        <Form ref={formRef} onSubmit={handleSubmit}>
          <h1>Nova ficha médica</h1>
          <h3>Registre a sua ficha médica</h3>

          <Input name="weight" icon={FaWeight} placeholder="Peso" />

          <Input name="height" icon={GiBodyHeight} placeholder="Altura" />

          <Input
            name="bloodPressure"
            icon={GiWaterDrop}
            placeholder="Pressão sanguínea"
          />

          <Input
            name="bodyTemperature"
            icon={FaTemperatureHigh}
            placeholder="Temperatura corporal"
          />

          <MultilineInput
            name="allergy"
            icon={FaAllergies}
            placeholder="Alergia"
          />

          {user.sex === 'F' && (
            <>
              <Input
                name="lastCycle"
                icon={GiCycle}
                placeholder="Último cíclo menstrual"
                type="date"
              />

              <CheckBox name="isPregnant" label="Estou grávida" />
            </>
          )}

          <Select
            name="hospitalId"
            icon={FaHospitalAlt}
            placeholder="Hospitais"
            options={hospitals.map(hospital => ({
              label: hospital.name,
              value: hospital.id,
            }))}
          />

          <Button type="submit">Enviar</Button>
        </Form>
      </Content>
    </Container>
  )
}

export default NewMedicalRecord
