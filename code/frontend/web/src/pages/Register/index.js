import React, { useState, useContext } from 'react'
import { useHistory } from 'react-router-dom'

import { AppContext } from '../../providers/contextProvider'
import { useApiService } from '../../services'

import {
  AvatarImage,
  Button,
  DoctorImage,
  Container,
  Form,
  Input,
  InputContainer,
  LinkButton,
  LoginContent,
  RegisterTitle
} from './style'

import doctors from '../../assets/doctors.svg'
import Avatar from '../../assets/avatar.png'
import { FiArrowLeft } from 'react-icons/fi'

import Swal from 'sweetalert2'

const Register = () => {
  const [, setError] = useState(false)
  const [, setErrorMessage] = useState('')
  const history = useHistory()

  const {
    state: {
      register: {
        name,
        telephone,
        sex,
        birthdayDate,
        admin,
        email,
        password,
        passwordConfirm
      }
    },
    actions: { register: { setRegister } }
  } = useContext(AppContext)

  const [api] = useApiService()
  const handleRegister = e => {
    try {
      e.preventDefault()
      setError(false)

      if (password !== passwordConfirm) {
        setErrorMessage('Senhas não coecidem')
        setError(true)
        Swal.fire(
          'Ops...',
          'Senhas não coincidem, verifique.',
          'error'
        )
        return
      }

      api.post('user', {
        name,
        telephone,
        sex,
        birthdayDate,
        admin,
        email,
        password
      })
      Swal.fire(
        'Boa!!!',
        'Cadastro feito com sucesso.',
        'success'
      )
      history.push('/login')
    } catch (error) {
      setErrorMessage('Erro ao tentar registrar usuário, Tente novamente mais tarde')
      setError(true)
      Swal.fire(
        'Ops...',
        'Erro ao tentar registrar usuário, tente novamente mais tarde.',
        'error'
      )
    }
  }

  const handleChange = e => {
    setRegister(e.target.name, e.target.value)
  }

  return (
    <Container>
      <DoctorImage src={doctors} alt="Medics" />
      <LoginContent>
        <Form onSubmit={handleRegister}>
          <AvatarImage src={Avatar} alt="Generic Avatar" />

          <RegisterTitle>Cadastre-se!</RegisterTitle>

          <InputContainer>
            <Input
              id={'name'}
              name={'name'}
              type={'text'}
              placeholder={'Nome'}
              value={name}
              onChange={handleChange}
              className="input"
              required
            />
          </InputContainer>

          <InputContainer>
            <Input
              id={'birthdayDate'}
              name={'birthdayDate'}
              type={'Date'}
              placeholder={'dd/mm/aaaa'}
              value={birthdayDate}
              onChange={handleChange}
              className="input"
              required
            />
          </InputContainer>

          <InputContainer>
            <Input
              id={'telephone'}
              name={'telephone'}
              type={'text'}
              placeholder={'Telefone'}
              value={telephone}
              onChange={handleChange}
              className="input"
              required
            />
          </InputContainer>

          <InputContainer>
            <Input
              id={'email'}
              name={'email'}
              type={'text'}
              placeholder={'E-mail'}
              value={email}
              onChange={handleChange}
              className="input"
              required
            />
          </InputContainer>

          <InputContainer>
            <Input
              id={'password'}
              name={'password'}
              type={'password'}
              placeholder={'Senha'}
              value={password}
              onChange={handleChange}
              className="input"
              required
            />
          </InputContainer>

          <InputContainer>
            <Input
              id={'passwordConfirm'}
              name={'passwordConfirm'}
              type={'password'}
              placeholder={'Confirme a Senha'}
              value={passwordConfirm}
              onChange={handleChange}
              className="input"
              required
            />
          </InputContainer>

          <Button type='submit'>Registrar</Button>
          <LinkButton to="/login">
            <FiArrowLeft size={16} />
                  Fazer login
          </LinkButton>
        </Form>
      </LoginContent>
    </Container>
  )
}

export default Register
