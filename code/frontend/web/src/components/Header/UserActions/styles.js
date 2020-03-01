import { makeStyles } from '@material-ui/core/styles'

export default makeStyles(theme => ({
  root: {
    border: 0,
    background: theme.palette.primary.main,
    fontColor: theme.typography.fontColor,
    color: theme.typography.fontColor,
    padding: 0,
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center',
    width: 120,
    height: theme.spacing(2.5),
    transition: theme.transitions.default,
    '&:hover': {
      color: theme.typography.default
    }
  },
  userAvatar: {
    fontSize: 40,
    width: 40,
    height: 40
  },
  userName: {
    fontFamily: theme.typography.fontFamily
  }
}))
