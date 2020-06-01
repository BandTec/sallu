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

  .back-link {
    display: flex;
    align-items: center;
    margin-top: 40px;
    color: #41414d;
    font-size: 18px;
    text-decoration: none;
    font-weight: 500;
    transition: opacity 0.2s;
  }
  
  .back-link svg{
    margin-right: 8px;
  }
  
  .back-link:hover{
    opacity: 0.8;
  }
`;

