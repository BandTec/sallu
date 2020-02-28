import { createGlobalStyle } from 'styled-components'
// import { makeStyles } from '@material-ui/core/styles'

// const global = makeStyles(theme => ({

// }))

const GlobalStyles = createGlobalStyle`
  * {
    box-sizing: border-box;
    margin: 0;
    outline: 0;
    padding: 0;
    transition: '0.4s'
  }

  body, html {
    background: '#333333';
    font-family: 'Roboto', Arial, sans-serif;
    text-rendering: optimizeLegibility !important;
    -webkit-font-smoothing: antialised !important;
    width: 100%;
    height: 100%;
  }
`

export default GlobalStyles
