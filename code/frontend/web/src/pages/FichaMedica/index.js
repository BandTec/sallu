import React, { useState, useEffect } from 'react'

import Swal from 'sweetalert2'

import { Container, ContactBox, Left, Right, Button } from './styles'
import { useApiService, useTokenService } from '../../services'

import pacientImg from '../../assets/pacient.jpg'
import Header from '../../components/Header'

import FilaVerde from './FilaVerde'
import FilaAmarelo from './FilaAmarelo'
import FilaVermelho from './FilaAmarelo'

var verde = 1
var amarelo = 1
var vermelho = 1

function FichaMedica () {
  const v = new FilaVerde(100)
  const a = new FilaAmarelo(100)
  const ver = new FilaVermelho(100)

  const [peso, setPeso] = useState('')
  const [altura, setAltura] = useState('')
  const [pressao, setPressao] = useState('')
  const [temperaturaCorporal, setTemperaturaCorporal] = useState('')
  const [sexo, setSexo] = useState('')
  const [alergia, setAlergia] = useState('')
  const [dataUltCiclo, setDataUltCiclo] = useState('')
  const [gestante, setGestante] = useState('')
  // const [encaminhamento, setEncaminhamento] = useState('')
  const [nomeHospital, setNomeHospital] = useState('')
  const [dadosHospital, setDadosHospital] = useState([])

  var corClassificada = ''
  var numeroAtendimento = 0
  var classificacao
  const { getToken } = useTokenService()
  const [api] = useApiService()
  const nome = localStorage.getItem('nome')

  useEffect(() => {
    api.get('hospital').then(response => {
      setDadosHospital(response.data)
    })
  }, [])

  async function handleNewFicha (event) {
    event.preventDefault()

    if (temperaturaCorporal <= 36.9) {
      v.enqueue(verde)
      numeroAtendimento = verde++
      console.log(numeroAtendimento)
      corClassificada = 'Verde'
      classificacao = 'Sua classificação é verde'
    } else if (temperaturaCorporal > 36.9 && temperaturaCorporal <= 37.9) {
      a.enqueue(amarelo)
      numeroAtendimento = amarelo++
      corClassificada = 'Amarelo'
      classificacao = 'Sua classificação é amarelo'
    } else if (temperaturaCorporal >= 38.0 || gestante === true) {
      ver.enqueue(vermelho)
      numeroAtendimento = vermelho++
      corClassificada = 'Vermelho'
      classificacao = 'Sua classificação é vermelho'
    }

    const data = {
      peso,
      altura,
      pressao,
      temperaturaCorporal,
      sexo,
      alergia,
      dataUltCiclo,
      gestante,
      nomeHospital,
      encaminhamento: {
        corClassificada,
        numeroAtendimento
      }
    }

    try {
      await api.post('medical_records', data, {
        headers: {
          Authorization: `Bearer ${getToken()}`
        }
      })
      Swal.fire(
        'Triagem realizada com sucesso!',
        `${classificacao}`,
        'success'
      )
    } catch (error) {
      Swal.fire(
        'Erro',
        'Ficha médica não foi cadastrada... Tente novamente',
        'error'
      )
    }
  }

  return (
    <div>
      <Header />
      <Container>
        <ContactBox>
          <Left>

            <div>
              <img src={pacientImg} alt="Logo Paciente" />
              <h2>Triagem Virtual Salut</h2>
              <p>Olá {nome}</p>
            </div>

          </Left>

          <Right>
            <h2>Ficha Médica</h2>

            <form onSubmit={handleNewFicha}>

              <div className={'form'} >

                <div className={'combox'}>
                  <p> Selecione um Hospital:</p>
                  <select value={nomeHospital} onChange={event => setNomeHospital(event.target.value)}>
                    {dadosHospital.map((item) => <option key={item.id} value={item.nome}> {item.nome} </option>)}
                  </select>
                </div>

                <div className={'input-group'}>

                  <div className={'input-radio'}>

                    <input
                      id={'sexo'}
                      name={'input-sexo'}
                      type={'radio'}
                      value={'m'}
                      checked={sexo === 'm'}
                      onChange={event => setSexo(event.target.value)}
                    />

                    <p>Masculino</p>

                  </div>

                  <div className={'input-radio'}>

                    <input
                      id={'sexo'}
                      name={'input-sexo'}
                      type={'radio'}
                      value={'f'}
                      checked={sexo === 'f'}
                      onChange={event => setSexo(event.target.value)}
                    />

                    <p>Feminino</p>

                  </div>

                </div>

                <input
                  id={'peso'}
                  name={'peso'}
                  type={'text'}
                  onChange={event => setPeso(event.target.value)}
                  value={peso}
                  placeholder={'Peso'}
                />

                <input
                  id={'altura'}
                  name={'altura'}
                  type={'text'}
                  onChange={event => setAltura(event.target.value)}
                  value={altura}
                  placeholder={'Altura'}
                />

                <input
                  id={'pressao'}
                  name={'pressao'}
                  type={'text'}
                  onChange={event => setPressao(event.target.value)}
                  value={pressao}
                  placeholder={'Pressão'}
                />

                <input
                  id={'temperaturaCorporal'}
                  name={'temperaturaCorporal'}
                  type={'text'}
                  onChange={event => setTemperaturaCorporal(event.target.value)}
                  value={temperaturaCorporal}
                  placeholder={'Temperatura'}
                />

                {
                  sexo === 'f'
                    ? (
                      <>
                        <input
                          id={'dataUltCiclo'}
                          name={'dataUltCiclo'}
                          type={'Date'}
                          onChange={event => setDataUltCiclo(event.target.value)}
                          value={dataUltCiclo}
                          placeholder={'dd/mm/aaaa'}
                          required
                        />

                        <p>É gestante?</p>

                        <div className={'input-group'}>

                          <div className={'gestant-radio'}>

                            <input
                              id={'gestante'}
                              name={'gestante-input'}
                              type={'radio'}
                              value={'true'}
                              checked={gestante === 'true'}
                              onChange={event => setGestante(event.target.value)}
                            />

                            <p>Sim</p>

                          </div>

                          <div className={'gestant-radio'}>

                            <input
                              id={'gestante'}
                              name={'gestante-input'}
                              type={'radio'}
                              value={'false'}
                              checked={gestante === 'false'}
                              onChange={event => setGestante(event.target.value)}
                            />

                            <p>Não</p>

                          </div>

                        </div>

                      </>
                    ) : null
                }
                <textarea
                  id={'alergia'}
                  name={'alergia'}
                  onChange={event => setAlergia(event.target.value)}
                  value={alergia}
                  placeholder={'Descrição de Alergia'}
                />

                <Button type='submit'>Enviar</Button>

              </div>

            </form>

          </Right>

        </ContactBox>

      </Container>

    </div>
  )
}

export default FichaMedica
