import React, { useCallback, useRef, ChangeEvent } from 'react'
import { useHistory, Link } from 'react-router-dom'
import {
  FiUser,
  FiPhone,
  FiMail,
  FiLock,
  FiCamera,
  FiArrowLeft,
} from 'react-icons/fi'
import { Form } from '@unform/web'
import { FormHandles } from '@unform/core'
import * as Yup from 'yup'

import api from '../../services/api'

import { useToast } from '../../hooks/toast'
import getValidationErrors from '../../utils/getValidationErrors'

import Input from '../../components/Input'
import Button from '../../components/Button'

import { Container, Content, AvatarInput } from './styles'
import { useAuth } from '../../hooks/auth'

interface IProfileFormData {
  name: string
//  birthdayDate: string
//  sex: string
  email: string
  password: string
  newPassword: string
  passwordConfirmation: string
}

interface IHandleSubmit {
  (data: IProfileFormData): void
}

interface IHandleAvatarChange {
  (event: ChangeEvent<HTMLInputElement>): void
}

const Profile: React.FC = () => {
  const formRef = useRef<FormHandles>(null)

  const { addToast } = useToast()
  const { user, updateUser } = useAuth()
  const history = useHistory()

  const handleSubmit = useCallback<IHandleSubmit>(
    async data => {
      formRef.current?.setErrors({})

      console.log(data)

      try {
        const schema = Yup.object().shape({
          name: Yup.string().required('Nome obrigatório'),

         // birthdayDate: Yup.string().min(8, 'Data de nascimento obrigatória'),

          telephone: Yup.string().required('Telefone obrigatório'),

          email: Yup.string()
            .required('E-mail obrigatório')
            .email('Digite um e-mail válido'),

          password: Yup.string().when('password', {
            is: val => !!val.length,
            then: Yup.string().required('Senha obrigatória'),
            otherwise: Yup.string(),
          }),

          newPassword: Yup.string().required('Nova senha obrigatória'),

          passwordConfirmation: Yup.string()
            .when('newPassword', {
              is: val => !!val.length,
              then: Yup.string().required('Senha obrigatória'),
              otherwise: Yup.string(),
            })
            .oneOf([Yup.ref('newPassword'), undefined], 'Senhas não coincidem')
            .required('Confirmação de nova senha obrigatória'),
        })

        await schema.validate(data, {
          abortEarly: false,
        })

        const formData = {
          name: data.name,
          email: data.email,
          ...(data.password
            ? {
                password: data.password,
                newPassword: data.newPassword,
                passwordConfirmation: data.passwordConfirmation,
              }
            : {}),
        }

        await api.put('user', formData)

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

  const handleAvatarChange = useCallback<IHandleAvatarChange>(
    async event => {
      if (event.target.files) {
        const data = new FormData()

        data.append('avatar', event.target.files[0])

        const response = await api.patch('/avatar')

        addToast({
          type: 'success',
          title: 'Avatar atualizado!',
        })

        updateUser(response.data)
      }
    },
    [addToast, updateUser],
  )

  return (
    <Container>
      <header>
        <div>
          <Link to="/dashboard">
            <FiArrowLeft />
          </Link>
        </div>
      </header>

      <Content>
        <Form
          ref={formRef}
          initialData={{
            ...user,
          }}
          onSubmit={handleSubmit}
        >
          <AvatarInput>
            {user.avatarUrl ? (
              <img src={user.avatarUrl} alt={user.name} />
            ) : (
              <FiUser />
            )}
            <label htmlFor="avatar">
              <FiCamera />

              <input type="file" id="avatar" onChange={handleAvatarChange} />
            </label>
          </AvatarInput>

          <h1>Meu Perfil</h1>

          <Input
            name="name"
            icon={FiUser}
            placeholder="Nome Completo"
            type="text"
          />

          <Input
            name="cellphone"
            icon={FiPhone}
            placeholder="Celular"
            type="tel"
          />

          <Input name="email" icon={FiMail} placeholder="E-mail" type="email" />

          <Input
            containerStyle={{ marginTop: 24 }}
            name="password"
            icon={FiLock}
            placeholder="Senha Atual"
            type="password"
          />

          <Input
            name="newPassword"
            icon={FiLock}
            placeholder="Nova Senha"
            type="password"
          />

          <Input
            name="passwordConfirmation"
            icon={FiLock}
            placeholder="Confirmar Senha"
            type="password"
          />

          <Button type="submit">Confirmar Mudanças</Button>
        </Form>
      </Content>
    </Container>
  )
}

export default Profile
