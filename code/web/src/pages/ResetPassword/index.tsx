import React, { useCallback, useRef } from 'react'
import { useHistory, useLocation } from 'react-router-dom'
import { FiLock } from 'react-icons/fi'
import { Form } from '@unform/web'
import { FormHandles } from '@unform/core'
import * as Yup from 'yup'

import { useToast } from '../../hooks/toast'
import getValidationErrors from '../../utils/getValidationErrors'

import medicineImg from '../../assets/images/medicine.svg'

import Input from '../../components/Input'
import Button from '../../components/Button'

import { Container, Content, AnimationContainer, Background } from './styles'
import api from '../../services/api'

interface IResetPasswordFormData {
  password: string
  passwordConfirmation: string
}

const ResetPassword: React.FC = () => {
  const formRef = useRef<FormHandles>(null)

  const { addToast } = useToast()
  const history = useHistory()
  const location = useLocation()

  const handleSubmit = useCallback(
    async (data: IResetPasswordFormData) => {
      formRef.current?.setErrors({})

      try {
        const schema = Yup.object().shape({
          password: Yup.string().required('Senha obrigatória'),

          passwordConfirmation: Yup.string()
            .oneOf([Yup.ref('password'), undefined], 'Senhas não coincidem')
            .required('Confirmação de Senha Obrigatória'),
        })

        await schema.validate(data, {
          abortEarly: false,
        })

        const { password, passwordConfirmation } = data
        const token = location.search.replace('?token=', '')

        if (!token) {
          throw new Error()
        }

        await api.post('/password/reset', {
          password,
          passwordConfirmation,
          token,
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
          title: 'Erro ao resetar senha',
          description: 'Ocorreu um erro ao resetar sua senha, tente novamente.',
        })
      }
    },
    [addToast, history, location.search],
  )

  return (
    <Container>
      <Content>
        <AnimationContainer>
          <Form ref={formRef} onSubmit={handleSubmit}>
            <h1>Resetar senha</h1>

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

            <Button type="submit">Entrar</Button>
          </Form>
        </AnimationContainer>
      </Content>

      <Background>
        <img src={medicineImg} alt="doctors" />
      </Background>
    </Container>
  )
}

export default ResetPassword
