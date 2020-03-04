import { makeStyles } from '@material-ui/core/styles'

export default makeStyles(theme => ({
  root: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center'
  },
  user: {
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center',
    padding: 0,
    width: theme.spacing(2.5),
    height: theme.spacing(2.5),
    color: theme.typography.fontColor,
    transition: theme.transitions.default,
    '&:hover': {
      color: theme.typography.switcher,
      background: theme.palette.primary.main
    }
  },
  userAvatar: {
    width: '100%',
    height: '100%'
  },
  userName: {
    fontFamily: theme.typography.fontFamily
  }
}))
