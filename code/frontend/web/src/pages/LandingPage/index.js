import React from 'react'
import styled from 'styled-components'

import { Header, SectionContainer, ThemeSwitch } from '../../components'

const LandingThemeSwitch = styled(ThemeSwitch)``

const LandingPage = ({ children }) => {
  return (
    <>
      <Header />
      <LandingThemeSwitch />
      <SectionContainer>
        {children}
      </SectionContainer>
    </>
  )
}

export default LandingPage
