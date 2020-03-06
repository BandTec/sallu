import React from 'react'

import styled from 'styled-components'

import PageActions from './PageActions'
import UserActions from './UserActions'

const HeaderDiv = styled.header`
  /* overflow: hidden; */
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  height: ${({ theme }) => theme.margin(3)};
  padding: ${({ theme }) => theme.padding(1)};
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
