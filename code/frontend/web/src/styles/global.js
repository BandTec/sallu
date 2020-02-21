import { createGlobalStyle } from 'styled-components';

const GlobalStyles = createGlobalStyle`
  * {
    box-sizing: border-box;
    margin: 0;
    outline: 0;
    padding: 0;
  }

  body, html {
    background: '#FAFAFA';
    font-family: 'Roboto', Arial, sans-serif;
    text-rendering: optimizeLegibility !important;
    -webkit-font-smoothing: antialised !important;
    width: 100%;
    height: 100%;
  }
`;

export default GlobalStyles;