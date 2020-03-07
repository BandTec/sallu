import React, { useContext } from 'react'

import { AppContext } from './contextProvider'

import { createGlobalStyle, ThemeProvider as Theme } from 'styled-components'

// import { createMuiTheme } from '@material-ui/core/styles'
// import { ThemeProvider } from '@material-ui/styles'

const dark = '#212121'
const darkHover = '#303030'
const light = '#F1F1F1'
const lightHover = '#E0E0E0'

const primary = {
  main: '#2251BF',
  hover: '#2A63E6',
  light: '#2E6DFF',
  dark: '#173680'
}
const secondary = {
  main: '#BF241F',
  hover: '#E62C24',
  light: '#FF3029',
  dark: '#801814'
}

const palette = { primary, secondary }

const lightTheme = {
  main: {
    bg: light,
    hv: lightHover,
    ft: dark
  }
}

const darkTheme = {
  main: {
    bg: dark,
    hv: darkHover,
    ft: light
  }
}

const themeDefaults = {
  margin: (x = 1, format = 'px') => `${16 * x}${format}`,
  padding: (x = 1, format = 'px') => `${10 * x}${format}`,
  borderRadius: (x = 1, format = 'px') => `${4 * x}${format}`
}

const GlobalStyles = createGlobalStyle`

  @import url('https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap');

  * {
    box-sizing: border-box;
    margin: 0;
    outline: 0;
    padding: 0;
    color: ${({ theme }) => theme.main.ft};
    transition: 0.4s
  }

  body, html, #root {
    height: 100%;
    background: ${({ theme }) => theme.main.bg}
  }

  body {
    -webkit-font-smoothing: antialised !important;
    text-rendering: optimizeLegibility !important;
  }

  body, input, button {
    font-family: Roboto, Arial, sans-serif;
  }
`
GlobalStyles.defaultProps = {
  theme: {
    ...lightTheme,
    ...themeDefaults,
    ...palette
  }
}

const ThemeProvider = ({ children }) => {
  const { state } = useContext(AppContext)
  const { theme } = state.preferences

  return (
    <>
      <GlobalStyles theme={theme === 'light' ? lightTheme : darkTheme} />
      <Theme theme={
        () => theme === 'light'
          ? { ...lightTheme, ...themeDefaults, ...palette }
          : { ...darkTheme, ...themeDefaults, ...palette }
      }>
        {children}
      </Theme>
    </>
  )
}

export default ThemeProvider
