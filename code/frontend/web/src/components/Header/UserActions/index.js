import React from 'react'
import { Button, Typography } from '@material-ui/core'
import { AccountCircleRounded } from '@material-ui/icons'

import useStyles from './styles'

const UserActions = () => {
  const classes = useStyles()

  return (
    <Button variant="outlined" className={classes.root}>
      <AccountCircleRounded className={classes.userAvatar} />
      {/* <Typography className={classes.userName}>
        Login
      </Typography> */}
    </Button>
  )
}

export default UserActions
