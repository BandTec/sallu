import styled from 'styled-components';

export const Container = styled.div`
  margin: 0;
  padding: 0;
  font-family: "Poppins", sans-serif;
`;

export const Section = styled.section`
    margin: 0 20px;
`;

export const Header = styled.form`
  display: grid;
  grid-template-columns: 1fr 1fr;
  margin-top: 20px;

  .logo {
    position: flex; 
    margin: 0 0; 
  }

`;

export const Main = styled.section`
  margin: 0 90px;
  margin-top: 100px;
  display: grid;
  grid-template-columns: 1fr 1fr;

  .main-text {
    font-size: 45px;
    font-weight: 700;
    line-height: 1.5;
  }

  span {
    border-bottom: 2px solid #3ff1aa;
  }

  .walkDog {
    position: flex;
    margin: 0 160px
  }

  #btns {
    display: flex;
    justify-content: space-evenly;
    
    margin-bottom: 32px;
  }

  button {
  background: none;
  color: #FF5E84;
  border: none;

  font-size: 14px;
  font-weight: bold;
  line-height: 18px;
  letter-spacing: 0.2;

  font-weight: bold;
  cursor: pointer;
  outline: none;
  }

  
button.fat {
  width: 170px;
  height: 40px;

  color: #FFF;
  background: #FF5050;

  border-radius: 6px;
  box-shadow: 0px 8px 16px rgba(255, 0, 92, 0.16);
}

button.fat:hover {
  text-decoration: none;
}
`;
