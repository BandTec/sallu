import { makeStyles } from '@material-ui/core/styles';

export default makeStyles(theme => ({
  root: {
    width: 48,
    height: 48,
    padding: 0,
    margin: theme.spacing(1)
  },
  light: {
    background: '#E5E5E5',
    color: '#000',
    transition: '0.4s',
    '&:hover': {
      background: '#D2D2D2',
    },
  },
  dark: {
    background: '#212121',
    color: '#FFF',
    transition: '0.4s',
    '&:hover': {
      background: '#383838',
    },
  },
}));