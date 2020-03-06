import React from 'react'

import useStyles from './styles'

const PageContainer = ({ children }) => {
  const classes = useStyles()

  return (
    <div className={classes.root}>
      {children}
    </div>
  )
}

export default PageContainer
