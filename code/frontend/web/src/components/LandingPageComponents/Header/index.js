import React from 'react'

import styled from 'styled-components'

import PageActions from './PageActions'
import UserActions from './UserActions'

const HeaderDiv = styled.header`
  display: flex;
  align-content: center;
  justify-content: space-between;
  padding: ${({ theme }) => theme.padding(1)};
  width: 100%;
  height: ${({ theme }) => theme.margin(4)};
  background: ${({ theme }) => theme.main.hv};
`

const Header = () => {
  return (
    <HeaderDiv>
      <PageActions />
      <UserActions />
    </HeaderDiv>
  )
}

export default Header
