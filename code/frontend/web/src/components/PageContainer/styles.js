import { makeStyles } from '@material-ui/core/styles'

export default makeStyles(theme => ({
  root: {
    background: theme.palette.background.default(),
    transition: theme.transitions.default,
    display: 'flex',
    height: '100%'
  }
}))
