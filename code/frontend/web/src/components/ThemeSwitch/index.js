import React, { useContext } from 'react'

import { InputAdornment, IconButton } from '@material-ui/core'
import { Brightness2Outlined, WbSunny } from '@material-ui/icons'

import styled from 'styled-components'

import { AppContext } from '../../providers/contextProvider'

const ButtonContainer = styled(InputAdornment)`
  margin: ${({ theme }) => theme.margin(1)};
`
const Button = styled(IconButton)`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0;
  width: ${({ theme }) => theme.margin(2.5)};
  height: ${({ theme }) => theme.margin(2.5)};
  color: ${({ theme }) => theme.main.ft};
  background: ${({ theme }) => theme.main.bg};
  transition: 0.4s;
  &:hover {
    background: ${({ theme }) => theme.primary.main};
  }
`

const DarkIcon = styled(Brightness2Outlined)`
  width: ${({ theme }) => theme.margin(1.5)};
  height: ${({ theme }) => theme.margin(1.5)};
`

const LightIcon = styled(WbSunny)`
  width: ${({ theme }) => theme.margin(1.5)};
  height: ${({ theme }) => theme.margin(1.5)};
`

const ThemeSwitch = () => {
  const { state, actions } = useContext(AppContext)
  const { theme } = state.preferences
  const { setPreferences } = actions.preferences

  const handleChangeTheme = () => theme === 'light'
    ? setPreferences('theme', 'dark')
    : setPreferences('theme', 'light')

  return (
    <ButtonContainer>
      <Button
        onClick={handleChangeTheme}
      >
        {theme === 'light'
          ? <DarkIcon />
          : <LightIcon />
        }
      </Button>
    </ ButtonContainer>
  )
}

export default ThemeSwitch
