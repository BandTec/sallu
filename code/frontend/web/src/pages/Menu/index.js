import React from 'react'

import {
  Container,
  Card,
  MenuContainer,
  CardIcon,
  PageContainer
} from './styles'

import logo from '../../assets/logo_salut_normal.svg'

function Menu () {
  return (
    <PageContainer>
      <div className={'logo'}>
        <img src={logo} alt="" width={'100'}/>
      </div>
      <Container>
        <MenuContainer>
          <Card to="/profile">
            <CardIcon color={'#FF5050'} >
              <img src="https://image.flaticon.com/icons/svg/2922/2922506.svg" alt=""/>
            </CardIcon>
            <div>
              <h2>Perfil</h2>
              <h3>Acesse e atualize o seu perfil</h3>
            </div>
          </Card>

          <Card to="/ficha">
            <CardIcon color={'#ffef9f'} >
              <img src="https://image.flaticon.com/icons/svg/3056/3056833.svg" alt=""/>
            </CardIcon>
            <h2>Ficha médica</h2>
          </Card>

          <Card to="/pacientes">
            <CardIcon color={'#06d6a0'} >
              <img src="https://image.flaticon.com/icons/svg/2865/2865164.svg" alt=""/>
            </CardIcon>
            <h2>Histórico do Cliente</h2>
          </Card>

          <Card to="/maps">
            <CardIcon color={'#118ab2'} >
              {/* <img src="https://image.flaticon.com/icons/svg/594/594732.svg" alt=""/> */}
              <img src={'https://image.flaticon.com/icons/svg/3069/3069318.svg'} />
            </CardIcon>
            <h2>Hospitais próximos a sua localidade</h2>
          </Card>
        </MenuContainer>
      </Container>
    </PageContainer>
  )
}

export default Menu