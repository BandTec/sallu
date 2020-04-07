import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
  * {
      padding:0;
      margin: 0; 
      box-sizing: border-box;
  }

  body, html {
    font-family: 'Poppins', sans-serif;
    overflow: hidden;
  }
`;

