import React from 'react'
import { AccountCircleRounded } from '@material-ui/icons'

import styled from 'styled-components'

import IconBtn from '../../../IconBtn'
import ThemeSwitch from '../../../ThemeSwitch'

const ActContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
`
const UserAvatar = styled(AccountCircleRounded)`
  width: 100%;
  height: 100%;
`

const UserActions = () => {
  return (
    <ActContainer>
      <IconBtn variant="outlined">
        <UserAvatar />
      </IconBtn>
    </ ActContainer>
  )
}

export default UserActions
