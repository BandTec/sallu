import React from 'react';

import { Container } from './styles';
import salutLogo from '../../assets/logo_salut_normal.svg';
import { useHistory } from 'react-router-dom';
import { FiPower, FiArrowLeftCircle } from 'react-icons/fi';
import { useTokenService } from '../../services';

function Header() {
  const { resetToken } = useTokenService();
  const history = useHistory();

  function handleLogout() {
    resetToken();
    localStorage.clear();
    history.push('/login');
  }

  function handleMenu() {
    history.push('/menu');
  }

  return (
    <Container>
      <img src={salutLogo} alt="Logo equipe Salut" />

      <button onClick={handleMenu} id={'btn2'} type="button">
        <FiArrowLeftCircle size={20} color="#e02041"/>
      </button>

      <button onClick={handleLogout} id={'button'} type="button">
        <FiPower size={20} color="#e02041"/>
      </button>

    </Container>
  );
}

export default Header;