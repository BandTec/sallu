import React, { useContext } from 'react'

import { AppContext } from './contextProvider'

import { createMuiTheme } from '@material-ui/core/styles'
import { ThemeProvider } from '@material-ui/styles'

const defDarkColor = '#212121'
const defDarkColorHover = '#313131'

const defLightColor = '#F1F1F1'
const defLightColorHover = '#D1D1D1'

const defTheme = (theme) => createMuiTheme({
  spacing: 15,
  shape: {
    borderRadius: 10
  },
  transitions: {
    default: '0.4s',
    duration: {
      complex: '0.2s',
      enteringScreen: '0.2s',
      leavingScreen: '0.4s',
      short: '0.4s',
      shorter: '0.2s',
      shortest: '0.1s',
      standard: '0.5s'
    }
  },
  typography: {
    fontFamily: 'Roboto',
    fontColor: () => theme === 'light' ? '#000' : '#FFF',
    switcher: () => theme === 'light' ? '#FFF' : '#000'
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
      default: () => theme === 'light' ? defLightColor : defDarkColor,
      paper: () => theme === 'light' ? '#FFF' : '#222',
      hover: () => theme === 'light' ? defLightColorHover : defDarkColorHover
    },
    switcher: {
      default: () => theme === 'light' ? defDarkColor : defLightColor,
      hover: () => theme === 'light' ? defDarkColorHover : defLightColorHover
    }
    // text: {
    //   disabled: '',
    //   hint: '',
    //   primary: '',
    //   secondary: '',
    // },
    // divider: '',
    // getContrastText: '',
    // type: '',
  }
})

const ThemeProviderApp = ({ children }) => {
  const { state: { preferences: { theme } } } = useContext(AppContext)

  return (
    <ThemeProvider theme={defTheme(theme)}>
      {children}
    </ThemeProvider>
  )
}

export default ThemeProviderApp
