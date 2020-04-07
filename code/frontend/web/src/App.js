import React from 'react'

import ThemeProvider from './providers/themeProvider'
import { ContextProvider } from './providers/contextProvider'
import { Routes } from './configs/routes'

import GlobalStyle from './style/GlobalStyle'

const App = () => (
  <ContextProvider>
    <ThemeProvider>
      <GlobalStyle />
      <Routes />
    </ThemeProvider>
  </ContextProvider>
)

export default App
