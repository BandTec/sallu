import React, { useContext, useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'
// import Recaptcha from 'react-recaptcha'

/**
 * Contexto da Aplicação
 */
import { AppContext } from '../../providers/contextProvider'
import { useApiService, useTokenService } from '../../services'

import { GoogleRecaptcha } from './styles'
// import { ROUTES } from '../../configs/routes'

import './style.css'

import medicine from '../../assets/medicine.png'
import Avatar from '../../assets/avatar.png'
// import Fundo from '../../assets/wave.png'

const Login = () => {
  /**
   * Actions e States Globais para Login
   * Sempre usa-se o AppContext com o Hook useContext do React
   */
  const history = useHistory()
  const {
    state: { login: { email, password, errorMessage } },
    actions: { login: { setLogin } }
  } = useContext(AppContext)

  const [api, handleSetAuthorization] = useApiService('api')

  const { setToken } = useTokenService()

  const handleSignIn = async e => {
    try {
      e.preventDefault()
      setLogin('errorMessage', null)
      // const { data } = await api.post('login', { email, password })
      console.log('Tentativa Login')
      const { data } = await api.post('auth', { email, password })
      localStorage.setItem('nome', data.nome)
      localStorage.setItem('id', data.id)
      localStorage.setItem('email', data.login)
      setToken(data.token)
      handleSetAuthorization()
      history.push('/welcome')
      return
    } catch (error) {
      console.log(error)
      setLogin('errorMessage', 'Erro ao fazer login')
      console.log(errorMessage)
    }
  }

  const handleChange = e => {
    setLogin(e.target.name, e.target.value)
    console.log(email.length <= 1 || password.length <= 1 || isVerified)
  }

  const [isVerified, setVerified] = useState(false)

  // const handleSubscribe = () => {
  //   if (isVerified) {
  //     alert('Aperte o botão para ser cadastrado!')
  //   } else {
  //     alert('Por favor verifique se você não é um robô!')
  //   }
  // }

  // const recapchaLoad = () => {
  //   console.log('Capcha succssfully loaded')
  // }

  const verifyCallback = (response) => {
    if (response) {
      setVerified(!!response)
    }
  }

  return (
    <>
      <div className="container">
        <div className="img">
          <img src={medicine} alt="Medicine" />
        </div>
        <div className="login-content">
          <form onSubmit={handleSignIn}>
            <img src={Avatar} alt="Avatar" />
            {errorMessage && <p style={{ background: '#FFF', color: '#F00', borderRadius: '10px' }}>{errorMessage}</p>}
            <h2 className="title">BEM VINDO</h2>
            <div className="input-div one">
              <div className="i">
                <i className="fas fa-user"></i>
              </div>
              <div className="div">
                {email.length < 1 && <h5>E-mail</h5>}
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
                {password.length < 1 && <h5>Senha</h5>}
                <input
                  id={'password'}
                  name={'password'}
                  type={'password'}
                  value={password}
                  onChange={handleChange}
                  className="input" />
              </div>
            </div>
            <Link>Esqueceu a Senha?</Link>
            {/* <Recaptcha
              sitekey={process.env.REACT_APP_RECAPTCHA_SITEKEY}
              render='explicit'
              onloadCallback={recapchaLoad}
              // data-size={'invisible'}
              // theme={"dark"}
              hl={'PT-BR'}
              verifyCallback={verifyCallback}
            /> */}
            <GoogleRecaptcha
              sitekey={process.env.REACT_APP_RECAPTCHA_SITEKEY}
              onChange={verifyCallback}
              hl={'pt-BR'}
            />

            <button
              type="submit"
              className="btn"
              value="Login"
              redirect="/ficha"
              disabled={(!email || !password || !isVerified)}
            >
              Login
            </button>

            <Link className="back-link" to="/register">
              <FiLogIn size={16} color="#E02041" />
                 Não tenho cadastro
            </Link>
          </form>
        </div>
      </div>
    </>
  )
}

export default Login
