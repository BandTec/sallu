import React from 'react'
import { IconButton } from '@material-ui/core'
import { AccountCircleRounded } from '@material-ui/icons'

import ThemeSwitch from '../../ThemeSwitch'

import useStyles from './styles'

const UserActions = () => {
  const classes = useStyles()

  return (
    <div className={classes.root}>
      <ThemeSwitch />
      <IconButton variant="outlined" className={classes.user}>
        <AccountCircleRounded className={classes.userAvatar} />
      </ IconButton>
    </ div>
  )
}

export default UserActions
