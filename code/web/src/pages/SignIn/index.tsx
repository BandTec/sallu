import React, { useCallback, useRef, useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiArrowRight, FiMail, FiLock } from 'react-icons/fi'
import { Form } from '@unform/web'
import { FormHandles } from '@unform/core'
import * as Yup from 'yup'

import { useAuth } from '../../hooks/auth'
import { useToast } from '../../hooks/toast'
import getValidationErrors from '../../utils/getValidationErrors'

import medicineImg from '../../assets/images/medicine.svg'

import Input from '../../components/Input'
import Button from '../../components/Button'
import GoogleRecaptcha from '../../components/GoogleRecaptcha'

import { Container, Content, AnimationContainer, Background } from './styles'

interface ISignInFormData {
  email: string
  password: string
}

interface IHandleVerifyCallback {
  (token: string | null): void
}

interface IHandleSubmitCallback {
  (data: ISignInFormData): void
}

const SignIn: React.FC = () => {
  const formRef = useRef<FormHandles>(null)

  const [isRecaptcha, setIsRecaptcha] = useState(false)

  const { signIn } = useAuth()
  const { addToast } = useToast()
  const history = useHistory()

  const handleVerifyCallback = useCallback<IHandleVerifyCallback>(token => {
    setIsRecaptcha(!!token)
  }, [])

  const handleSubmit = useCallback<IHandleSubmitCallback>(
    async data => {
      formRef.current?.setErrors({})

      try {
        const schema = Yup.object().shape({
          email: Yup.string()
            .required('E-mail obrigatório')
            .email('Digite um e-mail válido'),

          password: Yup.string().required('Senha obrigatória'),
        })

        await schema.validate(data, {
          abortEarly: false,
        })

        await signIn({
          email: data.email,
          password: data.password,
        })

        history.push('/dashboard')
      } catch (err) {
        if (err instanceof Yup.ValidationError) {
          const errors = getValidationErrors(err)

          formRef.current?.setErrors(errors)

          return
        }

        addToast({
          title: 'Erro na autenticação',
          description: 'Ocorreu um erro ao fazer login, cheque as credenciais.',
          type: 'error',
        })
      }
    },
    [signIn, addToast, history],
  )

  return (
    <Container>
      <Content>
        <AnimationContainer>
          <Form ref={formRef} onSubmit={handleSubmit}>
            <h1>Bem-vindo!</h1>
            <h3>Faça seu login</h3>

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

            <GoogleRecaptcha onChange={handleVerifyCallback} />

            <Button disabled={!isRecaptcha} type="submit">
              Entrar
            </Button>

            <Link to="/forgot-password">Esqueci a senha</Link>
          </Form>

          <Link to="/signup">
            Não possui conta? Faça o seu Cadastro!
            <FiArrowRight />
          </Link>
        </AnimationContainer>
      </Content>

      <Background>
        <img src={medicineImg} alt="doctors" />
      </Background>
    </Container>
  )
}

export default SignIn
