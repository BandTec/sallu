import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
`;

export const Form = styled.form`
  width: 400px;
  background: #FFF;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;

  img {
    width: 100px;
    margin: 10px 0 40px;
  }

  input {
    /* flex:1; */
    height:46px;
    margin-bottom: 15px;
    padding: 0 20px;
    color: #777;
    font-size: 15px;
    width: 100%;
    border: 1px solid #DDD;
    &::placeholder {
      color:#999;
    }
  }

  button {
    color: #FFF;
    font-size: 16px;
    background: #FC6963;
    height: 36px;
    border: 0;
    border-radius: 5px;
    width: 100%;
  }

  hr {
    margin: 20px 0;
    border: none;
    border-bottom: 1px solid #CDCDCD;
    width: 100%;
  }
`;