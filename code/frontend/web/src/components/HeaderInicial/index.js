import React from 'react';
import { Container } from './styles';
import salutLogo from '../../assets/logo_salut_normal.svg';
import { useHistory } from 'react-router-dom';
import { FiPower } from 'react-icons/fi';
import { useTokenService } from '../../services';

function Header() {
  const { resetToken } = useTokenService();
  const history = useHistory();

  function handleLogout() {
    resetToken()
    history.push('/login');
  }

  return (
    <Container>
      <img src={salutLogo} alt="Logo equipe Salut" />
      <span/>

      <button  onClick={handleLogout} type="button">
        <FiPower size={18} color="#526CC55" />
      </button>
    </Container>
  );
}

export default Header;