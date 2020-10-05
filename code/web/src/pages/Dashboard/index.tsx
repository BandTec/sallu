import React from 'react'
import {
  FiPower,
  FiUser,
  FiMapPin,
  FiClipboard,
  FiPlusCircle,
} from 'react-icons/fi'
import { Link } from 'react-router-dom'

import { useAuth } from '../../hooks/auth'

import Logo from '../../components/Logo'

import { Container, Header, HeaderContent, Profile, Content } from './styles'
import Card from '../../components/Card'

const Dashboard: React.FC = () => {
  const { signOut, user } = useAuth()

  return (
    <Container>
      <Header>
        <HeaderContent>
          <Logo />

          <Profile>
            {user.avatarUrl ? (
              <img src={user.avatarUrl} alt={user.name} />
            ) : (
              <FiUser />
            )}

            <div>
              <span>Bem-vindo,</span>
              <Link to="/profile">
                <strong>{user.name}</strong>
              </Link>
            </div>
          </Profile>

          <button type="button" onClick={signOut}>
            <FiPower size={20} />
          </button>
        </HeaderContent>
      </Header>

      <Content>
        <ul>
          <li>
            <Card
              title="Hospitais Próximos"
              description="Veja hospitais próximos a você!"
              icon={FiMapPin}
              route="/hospitals-nearby"
            />
          </li>
          <li>
            <Card
              title="Suas fichas médicas"
              description="Acompanhe as suas passagens pelos hospitais parceiros!"
              icon={FiClipboard}
              route="/medical-records"
            />
          </li>
          <li>
            <Card
              title="Registrar nova ficha"
              description="Faça um novo encaminhamento para um hospital!"
              icon={FiPlusCircle}
              route="/new-medical-record"
            />
          </li>
        </ul>
      </Content>
    </Container>
  )
}

export default Dashboard
