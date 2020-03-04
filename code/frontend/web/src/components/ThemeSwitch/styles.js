import { makeStyles } from '@material-ui/core/styles'

export default makeStyles(theme => ({
  root: {
    margin: `0px ${theme.spacing(1)}px`
  },
  button: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    padding: 0,
    width: theme.spacing(2.5),
    height: theme.spacing(2.5),
    color: theme.typography.switcher,
    background: theme.palette.switcher.default,
    transition: theme.transitions.default,
    '&:hover': {
      background: theme.palette.primary.main
    }
  },
  icon: {
    width: theme.spacing(1.5),
    height: theme.spacing(1.5)
  }
}))
