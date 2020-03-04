import React from 'react'

import {
  Header,
  PageContainer,
  SectionContainer
} from '../../components'

const LandingPage = ({ children }) => {
  return (
    <PageContainer>
      <Header />
      <SectionContainer>
        {children}
      </SectionContainer>
    </PageContainer>
  )
}

export default LandingPage
