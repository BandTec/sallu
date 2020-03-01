import React from 'react'

import useStyles from './styles'

const SectionContainer = ({ children }) => {
  const classes = useStyles()

  return (
    <section className={classes.root}>
      {children}
    </section>
  )
}

export default SectionContainer
