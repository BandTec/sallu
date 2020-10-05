import { createGlobalStyle } from 'styled-components'

const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    outline: 0;
    box-sizing: border-box;
  }

  body {
    background: ${({ theme }) => theme.background};
    color: ${({ theme }) => theme.font};
    -webkit-font-smoothing: antialiased;
  }

  body, input, button, textarea {
    font-family: Roboto, sans-serif;
    font-size: 16px;
  }

  h1, h2, h3, h4, h5, h6, strong {
    font-weight: 500;
  }

  table, thead, tbody, tfoot, tr, th, td {
    display: block;
    width: auto;
    height: auto;
    margin: 0;
    padding: 0;
    border: none;
    border-collapse: inherit;
    border-spacing: 0;
    border-color: inherit;
    vertical-align: inherit;
    text-align: left;
    font-weight: inherit;
    -webkit-border-horizontal-spacing: 0;
    -webkit-border-vertcial-spacing: 0;
  }

  th, td {
    display: inline;
  }

  button {
    cursor: pointer;
  }
  
  #root {
    margin: 0 auto;
    /* padding: 40px 20px; */
  }
`

export default GlobalStyle
