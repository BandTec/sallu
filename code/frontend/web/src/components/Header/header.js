import React from 'react';

import { Container } from './styles';
import salutLogo from '../../assets/logo_salut_normal.svg';

function Header() {
  return (
    <Container>
      <img src={salutLogo} alt="Logo equipe Salut"/>
    </Container>
  );
}

export default Header;