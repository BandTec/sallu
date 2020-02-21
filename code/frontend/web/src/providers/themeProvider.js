import React from 'react';

import { createMuiTheme } from '@material-ui/core/styles';
import { ThemeProvider } from '@material-ui/styles';

const theme = createMuiTheme({
  spacing: 15,
  shape: {
    borderRadius: 10,
  },
  transitions: {
    duration: {
      complex: '0.2s',
      enteringScreen: '0.2s',
      leavingScreen: '0.4s',
      short: '0.4s',
      shorter: '0.2s',
      shortest: '0.1s',
      standard: '0.5s',
    },
  },
  typography: {
    fontFamily: 'Roboto',
  },
  palette: {
    // primary: {
    //   main: '',
    //   contrastText: '',
    //   dark: '',
    //   light: '',
    // },
    // secondary: {
    //   main: '',
    //   contrastText: '',
    //   dark: '',
    //   light: '',
    // },
    // action: {
    //   active: '',
    //   disabled: '',
    //   hover: '',
    //   selected: '',
    //   focus: ''
    // },
    background: {
        default: '#F5F5F5',
        paper: '#FFF',
    },
    // text: {
    //   disabled: '',
    //   hint: '',
    //   primary: '',
    //   secondary: '',
    // },
    // divider: '',
    // getContrastText: '',
    // type: '',
  },
});

const ThemeProviderApp = ({ children }) => {


  return (
    <ThemeProvider theme={theme}>
      {children}
    </ThemeProvider>
  );
}

export default ThemeProviderApp;