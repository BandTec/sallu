import React, { useContext } from 'react';

import {
  InputAdornment,
  IconButton
} from '@material-ui/core';

import {
  Brightness2Outlined,
  Brightness5Outlined
} from '@material-ui/icons';

import { AppContext } from '../../providers/contextProvider';
import useStyles from './styles';

const ThemeSwitch = () => {
  const classes = useStyles();

  const { state, actions } = useContext(AppContext);
  const { theme } = state.preferences;
  const { setPreferences } = actions.preferences;

  const handleChangeTheme = () => theme === 'light'
    ? setPreferences('theme', 'dark')
    : setPreferences('theme', 'light');

  return (
    <InputAdornment className={classes.root}>
      <IconButton
        className={classes.button}
        onClick={handleChangeTheme}
      >
        {theme === 'light' ? <Brightness2Outlined /> : <Brightness5Outlined />}
      </IconButton>
    </InputAdornment>
  );
}

export default ThemeSwitch;