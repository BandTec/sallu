import React from 'react'
import salutLogo from '../../assets/logo_salut_normal.svg'
import { useHistory } from 'react-router-dom'
import { FiArrowLeftCircle, FiPower } from 'react-icons/fi'
import { useTokenService } from '../../services'

import { Actions, Button, Container, Logo } from './styles'

const HeaderInicial = ({ redirectBack = false }) => (
  <Container>
    <Logo src={salutLogo} alt="Logo equipe Salut" />

    <Actions>
      <Button
        to={redirectBack ? '/menu' : '/welcome'}
        color={'#c0fdff'}
      >
        <FiArrowLeftCircle size={20} />
      </Button>

      <Button
        to={'/logout'}
        color={'#FC6963'}
      >
        <FiPower size={20} />
      </Button>

    </Actions>

  </Container>
)

export default HeaderInicial
