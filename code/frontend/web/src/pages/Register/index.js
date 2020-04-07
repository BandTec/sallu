import React, { useContext } from 'react'
import { Link } from 'react-router-dom'


import { Container, LoginContent, Form } from './style'

import { AppContext } from '../../providers/contextProvider'


import Medicine from '../../assets/medicine.png'
import Avatar from '../../assets/avatar.png'


const Register = () => {

  const {
    state: { login: { email, password, name } },
    actions: { login: { setLogin } }
  } = useContext(AppContext)

  const handleRegister = e => {
    e.preventDefault()
    alert('Você foi registrado')
  }

  const handleChange = e => {
    setLogin(e.target.name, e.target.value)
    console.log(email, password,name)
  }

  return (
    <Container>
        <img src={Medicine}/>
        <LoginContent>
            <Form onSubmit={handleRegister}>
              <img src={Avatar}/>
              <h2>BEM VINDO</h2>
              <div className='input-div one'>
                  <div className='divName'>
                    <h5>NOME</h5>
                    <input
                      id={'nome'}
                      name={'name'}
                      type={'text'}
                      value={name}
                      onChange={handleChange}
                    />
                  </div>
              </div>
            
              <div className='input-div pass'>
              <div className='divEmail'>
                    <h5>EMAIL</h5>
                    <input
                      id={'email'}
                      name={'email'}
                      type={'email'}
                      value={email}
                      onChange={handleChange}
                    />
              </div>
              </div>

              <div className='input-div pass'>
              <div className='divSenha'>
                    <h5>EMAIL</h5>
                    <input
                      id={'email'}
                      name={'email'}
                      type={'email'}
                      value={password}
                      onChange={handleChange}
                    />
              </div>
              </div>

              <div className='input-div pass'>
              <div className='divConfiSenha'>
                    <h5>EMAIL</h5>
                    <input
                      id={'email'}
                      name={'email'}
                      type={'email'}
                      value={password}
                      onChange={handleChange}
                    />
              </div>
              </div>

              <Link>Esqueceu a Senha?</Link>
              <button type='submit'>Registrar</button>
            </Form>
        </LoginContent>
    </Container>
  )
}

export default Register
