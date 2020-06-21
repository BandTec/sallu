import React from 'react'
import { LoadScript } from '@react-google-maps/api'

import ThemeProvider from './providers/themeProvider'
import { ContextProvider } from './providers/contextProvider'
import { Routes } from './configs/routes'

import GlobalStyle from './style/GlobalStyle'
import './style/global.css'

const App = () => (
  <LoadScript
    googleMapsApiKey={process.env.REACT_APP_GOOGLE_API_KEY}
    libraries={['visualization', 'places']}
  >
    <ContextProvider>
      <ThemeProvider>
        <GlobalStyle />
        <Routes />
      </ThemeProvider>
    </ContextProvider>
  </LoadScript>
)

export default App
