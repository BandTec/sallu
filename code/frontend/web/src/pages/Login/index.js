import React, { useContext } from 'react'
import { Link } from 'react-router-dom'

/**
 * Contexto da Aplicação
 */
import { AppContext } from '../../providers/contextProvider'

import { Container, Form } from './components'
import { ROUTES } from '../../configs/routes'

// import Medicine from '../../assets/medicine.png';
import Sallut from '../../assets/sallut.svg'

const Login = () => {
  /**
   * Actions e States Globais para Login
   * Sempre usa-se o AppContext com o Hook useContext do React
   */
  const {
    state: { login: { email, password, errorMessage } },
    actions: { login: { setLogin } }
  } = useContext(AppContext)

  const handleSignIn = e => {
    e.preventDefault()
    alert('Você está na Aplicação')
  }

  const handleChange = e => {
    setLogin(e.target.name, e.target.value)
    console.log(email, password)
  }

  return (
    <Container>
      <Form onSubmit={handleSignIn}>
        <img src={Sallut} />
        {errorMessage && <p>{errorMessage}</p>}
        <input
          id={'email'}
          name={'email'}
          type={'text'}
          placeholder={'Email'}
          value={email}
          onChange={handleChange}
        />

        <input
          id={'senha'}
          name={'password'}
          type={'password'}
          placeholder={'Senha'}
          value={password}
          onChange={handleChange}
        />

        <button type='submit'>Entrar</button>
        <hr />

        <Link to={ROUTES.REGISTER}>Cadastrar</Link>
      </Form>
    </Container>
  )
}

export default Login
