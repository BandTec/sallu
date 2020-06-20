import React, { useState, useEffect } from 'react'
import { useApiService, useTokenService } from '../../services'
import HeaderInicial from '../../components/Header/index.js'
import { Link } from 'react-router-dom'
import Triagem from '../../assets/triagem.png'
import Historico from '../../assets/historico.png'
import Config from '../../assets/config.png'
// import './styles.css';

import walkDog from '../../assets/walk-dog.svg'
import logoSalut from '../../assets/logo_salut_normal.svg'
// import wave from '../../assets/wave.svg';

import { Container, Section, Header, Main } from './style'

function Welcome () {
  const { getToken } = useTokenService()
  const [api] = useApiService()
  const [ficha, setFicha] = useState([])

  return (
    <div>
      <Container>
        <Section>
          <Header>
            {/* <div className={'wave'}>
                        <img src={wave} alt="Wave image"/>
                    </div> */}
            <div className={'logo'}>
              <img src={logoSalut} alt="Imagem ilustrativa" width={'100'}/>
            </div>
          </Header>
        </Section>

        <Main>
          <div className={'main-text'}>
            <span>Olá, {localStorage.getItem('nome')}</span> <br/>
                    Seja bem-vindo ao aplicativo Salut.
          </div>

          <div className={'walkDog'}>
            <img src={walkDog} alt="Imagem logo Salut" width={'520'}/>
          </div>
          <div id={'btns'}>
            <Link to={'/menu'}>
              <button id={'myButton'} className={'fat'}>Avançar</button>
            </Link>
          </div>
        </Main>
      </Container>
    </div>
  )
}

export default Welcome
