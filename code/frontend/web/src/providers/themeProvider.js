import React, { useContext, useEffect } from 'react'

import { AppContext } from './contextProvider'

import { createGlobalStyle, ThemeProvider as Theme } from 'styled-components'

// import { createMuiTheme } from '@material-ui/core/styles'
// import { ThemeProvider } from '@material-ui/styles'

const dark = '#212121'
const darkHover = '#313131'
const light = '#F1F1F1'
const lightHover = '#D1D1D1'

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
  primary: { main: '#00AAFF' },
  margin: (x = 1) => 16 * x,
  padding: (x = 1) => 10 * x
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
    ...themeDefaults
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
          ? { ...lightTheme, ...themeDefaults }
          : { ...darkTheme, ...themeDefaults }
      }>
        {children}
      </Theme>
    </>
  )
}

export default ThemeProvider
