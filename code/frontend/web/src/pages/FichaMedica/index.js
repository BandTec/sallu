import React, { useState } from 'react'

import Swal from 'sweetalert2'

import { Container, ContactBox, Left, Right, Button } from './styles'
import { useApiService, useTokenService } from '../../services'

import pacientImg from '../../assets/pacient.jpg'
import Header from '../../components/Header'
import Fila from './Fila'

const FichaMedica = () => {
  let verde = 1
  let amarelo = 1
  let vermelho = 1
  const filaVerde = new Fila(100)
  const filaAmarela = new Fila(100)
  const filaVermelha = new Fila(100)

  let classificacao
  let corClassificada = ''
  let numeroAtendimento = 0

  const [peso, setPeso] = useState('')
  const [altura, setAltura] = useState('')
  const [pressao, setPressao] = useState('')
  const [temperaturaCorporal, setTemperaturaCorporal] = useState('')
  const [sexo, setSexo] = useState('')
  const [alergia, setAlergia] = useState('')
  const [dataUltCiclo, setDataUltCiclo] = useState('')
  const [gestante, setGestante] = useState('')
  const [nomeHospital, setNomeHospital] = useState('')
  const [encaminhamento, setEncaminhamento] = useState('')

  const { getToken } = useTokenService()
  const [api] = useApiService()

  async function handleNewFicha (event) {
    event.preventDefault()

    if (temperaturaCorporal <= 36.9) {
      filaVerde.enqueue(verde)

      numeroAtendimento = verde++

      corClassificada = 'Verde'

      classificacao = 'Sua classificação é verde'
    } else if (temperaturaCorporal > 36.9 && temperaturaCorporal <= 37.9) {
      filaAmarela.enqueue(amarelo)

      numeroAtendimento = amarelo++

      corClassificada = 'Amarelo'

      classificacao = 'Sua classificação é amarelo'
    } else if (temperaturaCorporal >= 38.0 || gestante == true) {
      filaVermelha.enqueue(vermelho)

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
              <p>Olá Chris</p>
            </div>

          </Left>

          <Right>
            <h2>Ficha Médica</h2>

            <form onSubmit={handleNewFicha}>

              <div className={'form'} >

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
