import { makeStyles } from '@material-ui/core/styles'

export default makeStyles(theme => ({
  root: {
    overflow: 'hidden',
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    background: theme.palette.background.paper,
    transition: theme.transitions.default,
    height: theme.spacing(3),
    padding: `0px ${theme.spacing(2)}px`
  }
}))
