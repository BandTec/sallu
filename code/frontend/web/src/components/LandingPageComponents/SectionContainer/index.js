import React from 'react'
import styled from 'styled-components'

const Section = styled.section`
  width: 100%;
  height: 100%;
  &:first-of-type {
    height: ${({ theme }) => `calc(100vh - ${theme.margin(3)})`};
  }
`

const SectionContainer = ({ children }) => {
  return (
    <Section>
      {children}
    </Section>
  )
}

export default SectionContainer
