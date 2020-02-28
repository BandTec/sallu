import styled from 'styled-components'
import { useTheme } from '@material-ui/core/styles'

const theme = useTheme()

const Button = styled.button``

const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
`

const Form = styled.form`
  width: 400;
  background: ${theme.palette.background.default}
`
