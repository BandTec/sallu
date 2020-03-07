import React, { useContext } from 'react'

import { InputAdornment } from '@material-ui/core'
import { Brightness2Outlined, WbSunny } from '@material-ui/icons'

import styled from 'styled-components'

import IconBtn from '../IconBtn'

import { AppContext } from '../../providers/contextProvider'

const ButtonContainer = styled(InputAdornment)`
  margin: ${({ theme }) => theme.margin(1)};
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
