import React from 'react';
import { useState } from 'react';
 
import { Container, ContactBox, Left, Right, Button } from './styles';
import pacientImg from '../../assets/pacient.jpg';
import Header from '../../components/Header/index.js';

function FichaMedica() {
  const [peso, setPeso] = useState('');
  const [altura, setAltura] = useState('');
  const [pressaoArt, setPressaoArt] = useState('');
  const [temperaturaCorp, setTemperaturaCorp] = useState('');
  const [sexo, setSexo] = useState(''); 
  const [desc, setDesc] = useState('');  
  const [dataUlt, setDataUlt] = useState('');
  const [gestante, setGestante] = useState('');
  
  return (
    <div>
    <Header/>
    <Container>
      <ContactBox>
        <Left>
          <div>
            <img src={pacientImg} alt="Logo Paciente"/>
            <h2>Triagem Virtual Salut</h2>
            <p>Olá Chris. Bem vindo ao Salut</p>
          </div>
        </Left>
        <Right>
          <h2>Ficha Médica</h2>
          <div className={'form'}>
            
          <div className={'input-group'}>
            <div className={'input-radio'}>
              <input 
                id={'sexo'}
                name={'input-sexo'}
                type={'radio'}
                value={'m'}
                checked={sexo == 'm'}
                onChange={(event) => setSexo(event.target.value)}
              /> <p>Masculino</p>
            </div>

            <div className={'input-radio'}>
              <input 
                id={'sexo'}
                name={'input-sexo'}
                type={'radio'}
                value={'f'}
                checked={sexo == 'f'}
                onChange={(event) => setSexo(event.target.value)}
              /> <p>Feminino</p>
            </div>
          </div>


          <input
            id={'peso'}
            name={'peso'}
            type={'text'} 
            onChange={(event) => setPeso(event.target.value)}
            value={peso}
            placeholder={'Peso'}
            />

            <input 
            id={'altura'}
            name={'altura'}
            type={'text'} 
            onChange={(event) => setAltura(event.target.value)}
            value={altura}
            placeholder={'Altura'}
            />

            <input
              id={'pressaoArt'}
              name={'pressaoArt'}
              type={'text'}
              onChange={(event) => setPressaoArt(event.target.value)}
              placeholder={'Pressão'}
            />

            <input
            id={'temperaturaCorp'}
            name={'temperaturaCorp'}
            type={'text'}
            onChange={(event) => setTemperaturaCorp(event.target.value)}
            value={temperaturaCorp}
            placeholder={'Temperatura'}
            />
            {
              sexo == 'f'
              ? (
                <>
                  <input 
                    id={'dataUlt'}
                    name={'dataUlt'}
                    type={'text'}
                    onChange={(event) => setDataUlt(event.target.value)}
                    value={dataUlt}
                    placeholder={'Data Última Mestruação'}
                  />

                <input 
                    id={'gestante'}
                    name={'gestante'}
                    type={'text'}
                    onChange={(event) => setDataUlt(event.target.value)}
                    value={dataUlt}
                    placeholder={'Gestante'}
                  />
                </>
              ) : null
            }

            <textarea 
            id={'desc'}
            name={'name'}
            onChange={(event) => setDesc(event.target.value)}
            value={desc}
            placeholder={'Descrição de Alergia'}
            />
            <Button>Enviar</Button>
          </div>
        </Right>
      </ContactBox>
    </Container>
    </div>
  );
}

export default FichaMedica;