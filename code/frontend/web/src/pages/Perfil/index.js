import React, { useState, useEffect } from 'react'
import { useApiService, useTokenService } from '../../services'
import Swal from 'sweetalert2'

import { Container, Form } from './styles'
import Header from '../../components/Header'

import logo from '../../assets/logo_salut_normal.svg'

function Profile () {
  const { getToken } = useTokenService()
  const [api] = useApiService()
  //   const [ficha, setFicha] = useState({})

  var admin = 'false'
  const [fetch, setFetch] = useState(false)
  //   const [password, setPassword] = useState(getToken())
  const [name, setName] = useState('')
  const [email, setEmail] = useState(localStorage.getItem('email'))
  const [birthdayDate, setBirthdayDate] = useState()
  const [telephone, setTelephone] = useState('')
  const idUser = localStorage.getItem('id')

  async function handleRegisterPut (e) {
    e.preventDefault()
    const data = {
      admin,
      name,
      email,
      birthdayDate,
      telephone
    }
    try {
      const response = await api.put('user', data)

      Swal.fire(
        'Boa!!!',
        'Alterações realizadas com sucesso.',
        'success'
      )
      localStorage.setItem('nome', name)
      // history.push('/');
    } catch (error) {
      Swal.fire(
        'Ops...',
        'Erro na alteração de dados, tente novamente',
        'error'
      )
    }
  }

  useEffect(() => {
    api.get(`user/${localStorage.getItem('id')}`, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    }).then(response => {
      const user = response.data

      setEmail(user.email)
      setName(user.name)
      setTelephone(user.telephone)
      setBirthdayDate(user.birthdayDate)

      setFetch(true)
    })
  }, [])

  function alterar () {
    document.getElementById('name').disabled = false

    document.getElementById('telephone').disabled = false
    document.getElementById('data').disabled = false
  };

  return (
    <div>
      <Header/>
      <Container>
        <Form>
          <img src={logo} alt=""/>
          <input
            type={'text'}
            id={'name'}
            placeholder={'Nome de Usuário'}
            value={name}
            onChange={e => setName(e.target.value)}
            disabled
          />

          <input
            type={'text'}
            id={'email'}
            placeholder={'Email'}
            value={email}
            onChange={e => setEmail(e.target.value)}
            disabled
          />

          <input
            type={'text'}
            id={'telephone'}
            placeholder={'Telefone'}
            value={telephone}
            onChange={e => setTelephone(e.target.value)}
            disabled
          />

          <input
            type={'Date'}
            id={'data'}
            placeholder={'Data de Nascimento'}
            value={birthdayDate}
            onChange={e => setTelephone(e.target.value)}
            disabled
          />

          <button name="Alterar" type="button" id="contact-submit" onClick={alterar} data-submit="...Sending">
                    Alterar</button>

          <hr/>

          <button name="Salvar Alteração" type="submit" id="contact-submit" data-submit="...Sending">
                    Salvar alteração</button>

        </Form>
      </Container>
    </div>
  )
}
export default Profile
