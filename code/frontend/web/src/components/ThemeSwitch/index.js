import React, { useContext } from 'react'
import styled from 'styled-components'

import { InputAdornment } from '@material-ui/core'
import { Brightness2Outlined, WbSunny } from '@material-ui/icons'

import IconBtn from '../IconBtn'

import { AppContext } from '../../providers/contextProvider'

const ButtonContainer = styled(InputAdornment)`
  position: absolute;
  width: ${({ theme }) => theme.margin(2.5)} !important;
  height: ${({ theme }) => theme.margin(2.5)} !important;
  margin: ${({ theme }) => theme.margin(0.5)};
`

const DarkIcon = styled(Brightness2Outlined)`
  width: 100%;
  height: 100%;
  &:hover {
    color: ${({ theme }) => theme.primary.light};
  }
`

const LightIcon = styled(WbSunny)`
  width: 100%;
  height: 100%;
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
      <IconBtn
        onClick={handleChangeTheme}

      >
        {theme === 'light'
          ? <DarkIcon />
          : <LightIcon />
        }
      </IconBtn>
    </ ButtonContainer>
  )
}

export default ThemeSwitch
