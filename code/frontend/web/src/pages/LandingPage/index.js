import React from 'react'

import {
  Header,
  PageContainer,
  ThemeSwitch,
  SectionContainer
} from '../../components'

const LandingPage = ({ children }) => {
  return (
    <PageContainer>
      <Header />
      <SectionContainer>
        <ThemeSwitch />
        {children}
      </SectionContainer>
      <SectionContainer>
        A
      </SectionContainer>
    </PageContainer>
  )
}

export default LandingPage
