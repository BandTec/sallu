import React from 'react';
import { useState } from 'react';
 
import { Container, ContactBox, Left, Right, Button } from './styles';
import pacientImg from '../../assets/pacient.jpg';
// import Header from '../../components/Header';

function FichaMedica() {
  const [peso, setPeso] = useState('');
  const [altura, setAltura] = useState('');
  const [pressaoArt, setPressaoArt] = useState('');
  const [temperaturaCorp, setTemperaturaCorp] = useState('');
  const [sexo, setSexo] = useState('');
  const [desc, setDesc] = useState('');  
  
  return (
    <div>
      {/* <Header/> */}
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
          <input 
          type="ra"
          />
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

            <textarea 
            id={'desc'}
            name={'name'}
            onChange={(event) => setDesc(event.target.value)}
            value={desc}
            placeholder={'Descrição de Alergia'}
            />
            <Button>Enviar</Button>
        </Right>
      </ContactBox>
    </Container>
    </div>
  );
}

export default FichaMedica;