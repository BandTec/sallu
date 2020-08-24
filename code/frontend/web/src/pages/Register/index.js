import React, { useState, useContext } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { Container, LoginContent, Form } from './style'

import { AppContext } from '../../providers/contextProvider'
import { useApiService } from '../../services'

import doctors from '../../assets/doctors.svg'
import Avatar from '../../assets/avatar.png'
import { FiArrowLeft } from 'react-icons/fi'

// CommonJS
import Swal from 'sweetalert2'

const Register = () => {
  const [error, setError] = useState(false)
  const [errorMessage, setErrorMessage] = useState('')
  // const [isVerified, setVerified] = useState(false)
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

  // const handleSubscribe = () => {
  //   if (isVerified) {
  //     alert('Aperte o botão para ser cadastrado!')
  //   } else {
  //     alert('Por favor verifique se você não é um robô!')
  //   }
  // }

  return (
    <Container>
      <div>
        <img src={doctors} alt="Medics" />
      </div>
      <LoginContent>
        <Form onSubmit={handleRegister}>
          <div className="avatar">
            <img src={Avatar} alt="Generic Avatar" />
          </div>
          <h2>CADASTRE-SE</h2>
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
                required
              />
            </div>
          </div>

          <div className='input-div one'>
            {/* <div className='divName'> */}
            <div>
              {/* {name.length <= 1 && <h5>Nome</h5>} */}
              <input
                id={'telephone'}
                name={'telephone'}
                type={'text'}
                placeholder={'Telefone'}
                value={telephone}
                onChange={handleChange}
                className="input"
                required
              />
            </div>
          </div>

          <div className='input-div one'>
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
                required
              />
            </div>
          </div>

          <div className='input-div one'>
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
                required
              />
            </div>
          </div>

          <div className='input-div one'>
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
                required
              />
            </div>
          </div>

          <div className='input-div one'>
            {/* <div className='divName'> */}
            <div>
              {/* {name.length <= 1 && <h5>Nome</h5>} */}
              <input
                id={'birthdayDate'}
                name={'birthdayDate'}
                type={'Date'}
                placeholder={'dd/mm/aaaa'}
                value={birthdayDate}
                onChange={handleChange}
                className="input"
                required
              />
            </div>
          </div>
          <button type='submit'>Registrar</button>
          <Link className="back-links" to="/login">
            <FiArrowLeft size={16} color="#E02041" />
                  Fazer login
          </Link>
        </Form>
      </LoginContent>
    </Container>
  )
}

export default Register
