import React, { useCallback, useRef } from 'react'
import { Link, useHistory } from 'react-router-dom'
import {
  FiArrowLeft,
  FiUser,
  FiCalendar,
  FiPhone,
  FiMail,
  FiLock,
} from 'react-icons/fi'
import { Form } from '@unform/web'
import { FormHandles } from '@unform/core'
import * as Yup from 'yup'

import api from '../../services/api'

import { useToast } from '../../hooks/toast'
import getValidationErrors from '../../utils/getValidationErrors'

import doctorsImg from '../../assets/images/doctors.svg'

import Input from '../../components/Input'
import Select from '../../components/Select'
import Button from '../../components/Button'

import { Container, Content, AnimationContainer, Background } from './styles'

interface ISignUpFormData {
  name: string
  birthday: string
  sex: string
  cellphone: string
  email: string
  password: string
  passwordConfirmation: string
}

interface IHandleSubmitCallback {
  (data: ISignUpFormData): void
}

const SignUp: React.FC = () => {
  const formRef = useRef<FormHandles>(null)

  const { addToast } = useToast()
  const history = useHistory()

  const handleSubmit = useCallback<IHandleSubmitCallback>(
    async data => {
      formRef.current?.setErrors({})

      try {
        const schema = Yup.object().shape({
          name: Yup.string().required('Nome obrigatório'),

          birthday: Yup.string().min(8, 'Data de Nascimento obrigatória'),

          sex: Yup.string()
            .required('Sexo obrigatório')
            .oneOf(['M', 'F'], 'Sexo Inválido'),

          cellphone: Yup.string().required('Telefone obrigatório'),

          email: Yup.string()
            .required('E-mail obrigatório')
            .email('Digite um E-mail válido'),

          password: Yup.string().required('Senha obrigatória'),

          passwordConfirmation: Yup.string()
            .oneOf([Yup.ref('password'), undefined], 'Senhas não coincidem')
            .required('Confirmação de Senha Obrigatória'),
        })

        await schema.validate(data, {
          abortEarly: false,
        })

        data.cellphone = data.cellphone.replace(/\D+/g, '')
        delete data.passwordConfirmation

        await api.post('user', {
          ...data,
        })

        addToast({
          type: 'success',
          title: 'Cadastro realizado!',
          description: 'Você já pode fazer o seu logon no Sallut!',
        })

        history.push('/')
      } catch (err) {
        if (err instanceof Yup.ValidationError) {
          const errors = getValidationErrors(err)

          formRef.current?.setErrors(errors)
          return
        }

        addToast({
          type: 'error',
          title: 'Erro no cadastro',
          description: 'Ocorreu um erro ao fazer cadastro, tente novamente.',
        })
      }
    },
    [addToast, history],
  )

  return (
    <Container>
      <Background>
        <img src={doctorsImg} alt="medicine" />
      </Background>

      <Content>
        <AnimationContainer>
          <Form ref={formRef} onSubmit={handleSubmit}>
            <h1>Bem-vindo!</h1>
            <h3>Faça o seu cadastro</h3>

            <Input
              name="name"
              icon={FiUser}
              placeholder="Nome Completo"
              type="text"
            />

            <Input
              name="birthday"
              icon={FiCalendar}
              placeholder="Data de Nascimento"
              type="date"
            />

            <Select
              name="sex"
              icon={FiUser}
              placeholder="Sexo"
              options={[
                { label: 'Masculino', value: 'M' },
                { label: 'Feminino', value: 'F' },
              ]}
            />

            <Input
              name="cellphone"
              icon={FiPhone}
              placeholder="Celular"
              type="tel"
            />

            <Input
              name="email"
              icon={FiMail}
              placeholder="E-mail"
              type="email"
            />

            <Input
              name="password"
              icon={FiLock}
              placeholder="Senha"
              type="password"
            />

            <Input
              name="passwordConfirmation"
              icon={FiLock}
              placeholder="Confirmação da Senha"
              type="password"
            />

            <Button type="submit">Cadastrar</Button>
          </Form>

          <Link to="/">
            <FiArrowLeft />
            Já possui conta? Faça Login!
          </Link>
        </AnimationContainer>
      </Content>
    </Container>
  )
}

export default SignUp
