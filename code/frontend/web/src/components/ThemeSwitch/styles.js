import { makeStyles } from '@material-ui/core/styles';

export default makeStyles(theme => ({
  root: {
    width: 48,
    height: 48,
    padding: 0,
    margin: theme.spacing(1)
  },
  button: {
    background: theme.palette.switcher.default(),
    color: theme.typography.switcher(),
    transition: '0.4s',
    '&:hover': {
      background: theme.palette.switcher.hover(),
    },
  },
}));