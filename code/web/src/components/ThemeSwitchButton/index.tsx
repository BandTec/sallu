import React from 'react'
import { FiSun, FiMoon } from 'react-icons/fi'

import { useTheme } from '../../hooks/theme'

import { Container } from './styles'

const ThemeSwitchButton: React.FC = () => {
  const { changeTheme, isDarkMode } = useTheme()

  return (
    <Container>
      <button onClick={changeTheme}>
        {isDarkMode ? <FiSun /> : <FiMoon />}
      </button>
    </Container>
  )
}

export default ThemeSwitchButton
