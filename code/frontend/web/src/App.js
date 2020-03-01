import React from 'react'

import ThemeProvider from './providers/themeProvider'
import { ContextProvider } from './providers/contextProvider'
import { Routes } from './configs/routes'

import './global.css'

const App = () => (
  <ContextProvider>
    <ThemeProvider>
      <Routes />
    </ThemeProvider>
  </ContextProvider>
)

export default App
