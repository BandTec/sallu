import React from 'react'
import styled from 'styled-components'
import { useTheme } from '@material-ui/core/styles'

// =============================================================================
// Button
// =============================================================================

const StyledButton = styled.button`
  text-decoration: none;
  height: 48;
`

export const Button = ({ children }) => {
  const theme = useTheme()

  return <StyledButton theme={theme}>{children}</StyledButton>
}

// =============================================================================
// Form (Default)
// =============================================================================

const StyledForm = styled.form`
  width: 400;
  background: ${({ theme }) => theme.palette.primary.main};
`

export const Form = ({ children }) => {
  const theme = useTheme()

  return <StyledForm theme={theme}>{children}</StyledForm>
}
