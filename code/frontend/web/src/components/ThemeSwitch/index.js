import React, { useContext } from 'react'

import { InputAdornment, IconButton } from '@material-ui/core'
import { Brightness2Outlined, WbSunny } from '@material-ui/icons'

import useStyles from './styles'

import { AppContext } from '../../providers/contextProvider'

const ThemeSwitch = () => {
  const classes = useStyles()

  const { state, actions } = useContext(AppContext)
  const { theme } = state.preferences
  const { setPreferences } = actions.preferences

  const handleChangeTheme = () => theme === 'light'
    ? setPreferences('theme', 'dark')
    : setPreferences('theme', 'light')

  return (
    <InputAdornment className={classes.root}>
      <IconButton
        className={classes.button}
        onClick={handleChangeTheme}
      >
        {theme === 'light' ? <Brightness2Outlined /> : <WbSunny />}
      </IconButton>
    </InputAdornment>
  )
}

export default ThemeSwitch
