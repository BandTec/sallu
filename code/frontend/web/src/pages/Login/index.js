import React, { useContext } from 'react'
// import { Link } from 'react-router-dom'

/**
 * Contexto da Aplicação
 */
import { AppContext } from '../../providers/contextProvider'
import { useApiService, useTokenService } from '../../services'

// import { Container, Form, LoginContent, Imagem } from './style'
// import { ROUTES } from '../../configs/routes'

import './style.css'

import Medicine from '../../assets/medicine.png'
import Avatar from '../../assets/avatar.png'
// import Fundo from '../../assets/wave.png'

const Login = () => {
  /**
   * Actions e States Globais para Login
   * Sempre usa-se o AppContext com o Hook useContext do React
   */
  const {
    state: { login: { email, password, errorMessage } },
    actions: { login: { setLogin } }
  } = useContext(AppContext)

  const {
    apis: { api },
    handlers: { handleSetAllAuthorization }
  } = useApiService()

  const { setToken } = useTokenService()

  const handleSignIn = async e => {
    e.preventDefault()
    setLogin('errorMessage', null)

    try {
      const { data } = await api.post('auth', { email, password })

      setToken(data.token)
      handleSetAllAuthorization()
    } catch (error) {
      setLogin('errorMessage', 'Erro ao logar-se')
      console.log(errorMessage)
    }
  }

  const handleChange = e => {
    setLogin(e.target.name, e.target.value)
    console.log(email, password)
  }

  return (
    <>
      <div className="container">
        {/* <img className="wave" src={Fundo}/> */}
        <div className="img">
          <img src={Medicine} />
        </div>
        <div className="login-content">
          <form onSubmit={handleSignIn}>
            <img src={Avatar} />
            {errorMessage && <p style={{ background: '#FFF', color: '#F00', borderRadius: '10px' }}>{errorMessage}</p>}
            <h2 className="title">Welcome</h2>
            <div className="input-div one">
              <div className="i">
                <i className="fas fa-user"></i>
              </div>
              <div className="div">
                {email.length < 1 && <h5>Username</h5>}
                <input
                  id={'email'}
                  name={'email'}
                  type={'text'}
                  value={email}
                  onChange={handleChange}
                  className="input" />
              </div>
            </div>
            <div className="input-div pass">
              <div className="i">
                <i className="fas fa-lock"></i>
              </div>
              <div classNames="div">
                {password.length < 1 && <h5>Password</h5>}
                <input
                  id={'password'}
                  name={'password'}
                  type={'password'}
                  value={password}
                  onChange={handleChange}
                  className="input" />
              </div>
            </div>
            <a href="#">Forgot Password?</a>
            <input type="submit" className="btn" value="Login" />
          </form>
        </div>
      </div>
    </>
  )
}

export default Login
