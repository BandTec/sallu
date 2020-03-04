import React, { useContext } from 'react'

import { InputAdornment, IconButton } from '@material-ui/core'
import { Brightness2Outlined as DarkIcon, WbSunny as LightIcon } from '@material-ui/icons'
import { useTheme } from '@material-ui/core/styles'

import useStyles from './styles'

import { AppContext } from '../../providers/contextProvider'

const ThemeSwitch = () => {
  const classes = useStyles()
  const appTheme = useTheme()

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
        {theme === 'light'
          ? <DarkIcon className={classes.icon} />
          : <LightIcon className={classes.icon} />
        }
      </IconButton>
    </ InputAdornment>
  )
}

export default ThemeSwitch
