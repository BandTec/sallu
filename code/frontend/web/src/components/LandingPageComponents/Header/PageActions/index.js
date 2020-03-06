import React from 'react'

import useStyles from './styles'

const PageActions = () => {
  const classes = useStyles()

  return (
    <div className={classes.root}>
      <div className={classes.item}>Home</div>
      <div className={classes.item}>Sobre Nós</div>
      <div className={classes.item}>Serviço</div>
      <div className={classes.item}>Contato</div>
    </div>
  )
}

export default PageActions
