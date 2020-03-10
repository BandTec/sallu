import React from 'react'

import styled from 'styled-components'

import PageActions from './PageActions'
import Navbar from './Navbar'

const HeaderContainer = styled.header`
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: space-between;
  padding: ${({ theme }) => theme.padding(1)};
  width: 100%;
  height: ${({ theme }) => theme.margin(4)};
  background: ${({ theme }) => theme.main.hv};
`

const Header = () => {
  return (
    <HeaderContainer>
      <Navbar>
        <PageActions />
      </Navbar>
    </HeaderContainer>
  )
}

export default Header
