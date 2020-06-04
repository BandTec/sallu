import React from 'react';
import { useState } from 'react';
import { Container, ContactBox, Left, Right, Button } from './styles';
import pacientImg from '../../assets/pacient.jpg';
import Header from '../../components/Header/index.js';
import { useApiService, useTokenService } from '../../services';
import Swal from 'sweetalert2';

function FichaMedica() {
  var classificacao;
  const [peso, setPeso] = useState('');
  const [altura, setAltura] = useState('');
  const [pressao, setPressao] = useState('');
  const [temperaturaCorporal, setTemperaturaCorporal] = useState('');
  const [sexo, setSexo] = useState('');
  const [alergia, setAlergia] = useState('');
  const [dataUltCiclo, setDataUltCiclo] = useState('');
  const [gestante, setGestante] = useState('');
  const [nomeHospital, setNomeHospital] = useState('');
  const [encaminhamento, setEncaminhamento] = useState('');
  const [corClassificada, setCorClassificada] = useState('');
  const [numeroAtendimento, setNumeroAtendimento] = useState('');

  

  const { getToken } = useTokenService();
  const [api] = useApiService()
  async function handleNewFicha(event) {
    event.preventDefault();

    if (temperaturaCorporal <= 36.9) {
      setCorClassificada('Verde')
      classificacao = 'Sua classificação é verde';
    } else if (temperaturaCorporal > 36.9 && temperaturaCorporal <= 37.9) {
      setCorClassificada('Amarelo')
      classificacao = 'Sua classificação é amarelo';
    } else if (temperaturaCorporal >= 38.1 || gestante == true) {
      setCorClassificada('Vermelho')
      classificacao = 'Sua classificação é vermelho';
    }
    console.log(corClassificada);
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
    };
    

    try {
      await api.post('medical_records', data, {
        headers: {
          'Authorization': `Bearer ${getToken()}`
        }
      });
      Swal.fire(
        'Triagem virtual realizada com sucesso!',
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
                      checked={sexo == 'm'}
                      onChange={event => setSexo(event.target.value)}
                    /> <p>Masculino</p>
                  </div>

                  <div className={'input-radio'}>
                    <input
                      id={'sexo'}
                      name={'input-sexo'}
                      type={'radio'}
                      value={'f'}
                      checked={sexo == 'f'}
                      onChange={event => setSexo(event.target.value)}
                    /> <p>Feminino</p>
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
                  sexo == 'f'
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
                              checked={gestante == 'true'}
                              onChange={event => setGestante(event.target.value)}
                            /> <p>Sim</p>
                          </div>

                          <div className={'gestant-radio'}>
                            <input
                              id={'gestante'}
                              name={'gestante-input'}
                              type={'radio'}
                              value={'false'}
                              checked={gestante == 'false'}
                              onChange={event => setGestante(event.target.value)}
                            /> <p>Não</p>
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
  );
}

export default FichaMedica;