import React from 'react'
import { IconButton } from '@material-ui/core'
import { AccountCircleRounded } from '@material-ui/icons'

import styled from 'styled-components'

import ThemeSwitch from '../../../ThemeSwitch'

const ActContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`

const UserProfile = styled(IconButton)`
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 0;
  width: ${({ theme }) => theme.margin(2.5)};
  height: ${({ theme }) => theme.margin(2.5)};
  color: ${({ theme }) => theme.main.ft};
  &:hover {
    color: ${({ theme }) => theme.main.ft || '#000'};
    background: ${({ theme }) => theme.primary.main};
  }
`
const UserAvatar = styled(AccountCircleRounded)`
  width: 100%;
  height: 100%;
`

const UserActions = () => {
  return (
    <ActContainer>
      <ThemeSwitch />
      <UserProfile variant="outlined">
        <UserAvatar />
      </UserProfile>
    </ ActContainer>
  )
}

export default UserActions
