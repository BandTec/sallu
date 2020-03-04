import React from 'react'

import useStyles from './styles'

import PageActions from './PageActions'
import UserActions from './UserActions'

const Header = () => {
  const classes = useStyles()

  return (
    <header className={classes.root}>
      <PageActions />
      <UserActions />
    </header>
  )
}

export default Header
