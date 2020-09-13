import React from 'react'
import { LoadScript } from '@react-google-maps/api'

import { AuthProvider } from './auth'
import { ThemeProvider } from './theme'
import { ToastProvider } from './toast'

const AppProvider: React.FC = ({ children }) => (
  <LoadScript
    googleMapsApiKey={process.env.REACT_APP_GOOGLE_API_KEY}
    libraries={['visualization', 'places']}
  >
    <ThemeProvider>
      <AuthProvider>
        <ToastProvider>{children}</ToastProvider>
      </AuthProvider>
    </ThemeProvider>
  </LoadScript>
)

export default AppProvider
