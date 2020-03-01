import { makeStyles } from '@material-ui/core/styles'

export default makeStyles(theme => ({
  root: {
    width: '50%',
    height: 42,
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'space-around'
  },
  item: {
    margin: `0px ${theme.spacing(0.5)}px`,
    borderRadius: theme.shape.borderRadius,
    width: '100%',
    height: '100%',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    transition: theme.transitions.default,
    color: theme.typography.fontColor,
    '&:hover': {
      background: theme.palette.primary.main
    }
  }
}))
