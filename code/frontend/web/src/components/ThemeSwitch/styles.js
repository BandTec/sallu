import { makeStyles } from '@material-ui/core/styles'

export default makeStyles(theme => ({
  root: {
    width: theme.spacing(3),
    height: theme.spacing(3),
    padding: 0,
    margin: theme.spacing(1)
  },
  button: {
    background: theme.palette.switcher.default(),
    color: theme.typography.switcher(),
    transition: theme.transitions.default,
    '&:hover': {
      background: theme.palette.switcher.hover()
    }
  }
}))
