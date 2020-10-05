import React, { createContext, useCallback, useState, useContext } from 'react'
import { ThemeProvider as StyledThemeProvider } from 'styled-components'

import ThemeSwitchButton from '../components/ThemeSwitchButton'

import GlobalStyle from '../styles/global'

import darkTheme from '../styles/themes/dark'
import lightTheme from '../styles/themes/light'

export interface ITheme {
  primary: string
  secondary: string
  background: string
  backgroundAuxiliar: string
  font: string
  fontAuxiliar: string
  alternativeBackground: string
  colors: {
    white: string
    darkGray: string
    black: string
    red: string
    yellow: string
    green: string
    blue: string
    purple: string
  }
}

interface IThemeContextData {
  isDarkMode: boolean
  changeTheme(): void
}

const ThemeContext = createContext<IThemeContextData>({} as IThemeContextData)

export const ThemeProvider: React.FC = ({ children }) => {
  const [isDarkMode, setIsDarkMode] = useState<boolean>(() => {
    const darkMode = localStorage.getItem('@SallutApp:darkMode')

    if (darkMode) {
      return JSON.parse(darkMode)
    }

    return false
  })

  const changeTheme = useCallback(() => {
    localStorage.setItem('@SallutApp:darkMode', JSON.stringify(!isDarkMode))

    setIsDarkMode(!isDarkMode)
  }, [isDarkMode])

  return (
    <ThemeContext.Provider value={{ isDarkMode, changeTheme }}>
      <StyledThemeProvider theme={isDarkMode ? darkTheme : lightTheme}>
        {children}
        <GlobalStyle />
        <ThemeSwitchButton />
      </StyledThemeProvider>
    </ThemeContext.Provider>
  )
}

export function useTheme(): IThemeContextData {
  const context = useContext(ThemeContext)

  if (!context) {
    throw new Error('useTheme must be used within an ThemeProvider')
  }

  return context
}
