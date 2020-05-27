import React, { useState, useContext } from 'react'
import { Link } from 'react-router-dom'

import { Container, LoginContent, Form } from './style'

import { AppContext } from '../../providers/contextProvider'
import { useApiService } from '../../services'

import Medicine from '../../assets/medicine.png'
import Avatar from '../../assets/avatar.png'

const Register = () => {
  const [error, setError] = useState(false)
  const [errorMessage, setErrorMessage] = useState('')

  const {
    state: {
      register: {
        name,
        birthdayDate,
        sex,
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
        return
      }

      api.post('user', {
        name,
        birthdayDate,
        sex,
        admin,
        email,
        password
      })
    } catch (error) {
      setErrorMessage('Erro ao tentar registrar usuário, Tente novamente mais tarde')
      setError(true)
    }
  }

  const handleChange = e => {
    setRegister(e.target.name, e.target.value)
  }

  return (
    <Container>
      <div>
        <img src={Medicine} alt="Medics" />
      </div>
      <LoginContent>
        <Form onSubmit={handleRegister}>
          <div className="avatar">
            <img src={Avatar} alt="Generic Avatar" />
          </div>
          <h2>BEM VINDO</h2>
          <div className='input-div one'>
            {/* <div className='divName'> */}
            <div>
              {/* {name.length <= 1 && <h5>Nome</h5>} */}
              <input
                id={'name'}
                name={'name'}
                type={'text'}
                placeholder={'Nome'}
                value={name}
                onChange={handleChange}
                className="input"
              />
            </div>
          </div>

          <div className='input-div pass'>
            {/* <div className='divEmail'> */}
            <div>
              {/* {email.length <= 1 && <h5>E-mail</h5>} */}
              <input
                id={'email'}
                name={'email'}
                type={'text'}
                placeholder={'E-mail'}
                value={email}
                onChange={handleChange}
                className="input"
              />
            </div>
          </div>

          <div className='input-div pass'>
            {/* <div className='divSenha'> */}
            <div>
              {/* {password.length <= 1 && <h5>Senha</h5>} */}
              <input
                id={'password'}
                name={'password'}
                type={'password'}
                placeholder={'Senha'}
                value={password}
                onChange={handleChange}
                className="input"
              />
            </div>
          </div>

          <div className='input-div pass'>
            {/* <div className='divConfiSenha'> */}
            <div>
              {/* {passwordConfirm.length <= 1 && <h5>Confirmação de Senha</h5>} */}
              <input
                id={'passwordConfirm'}
                name={'passwordConfirm'}
                type={'password'}
                placeholder={'Confirme a Senha'}
                value={passwordConfirm}
                onChange={handleChange}
                className="input"
              />
            </div>
          </div>

          <div className="link">
            <Link to={'/register'}>Esqueceu a Senha?</Link>
          </div>
          <button type='submit'>Registrar</button>
        </Form>
      </LoginContent>
    </Container>
  )
}

export default Register
