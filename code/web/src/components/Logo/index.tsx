import React from 'react'

import { useTheme } from '../../hooks/theme'

import lightLogoImg from '../../assets/images/logo.svg'
import darkLogoImg from '../../assets/images/logo-alt.svg'

import { LogoImage } from './styles'

const Logo: React.FC = () => {
  const { isDarkMode } = useTheme()

  return (
    <LogoImage
      src={isDarkMode ? darkLogoImg : lightLogoImg}
      alt="Sallut Logo"
    />
  )
}

export default Logo
