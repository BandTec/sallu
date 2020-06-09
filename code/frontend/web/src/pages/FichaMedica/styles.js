import styled from 'styled-components';

export const Container = styled.div`
  position: relative;
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
  padding: 20px 100px;
`;

export const ContactBox = styled.div`
  max-width: 850px;
  height: 100%;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  justify-content: center;
  align-items: center;
  text-align: center;
  background-color: #FFF;
  box-shadow: 0px 0px 19px 5px rgba(0, 0, 0, 0, 0.19);
`;

export const Left = styled.div`
  height: 100%;

img {
  max-width: 200px;
  width: 100%;
  height: auto;
  justify-content: center;
}

h2 {
  margin-top: 16px;
}

p {
  font-size: 20px ;
}

div {
  height: 70%;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
`;

export const Right = styled.div`
  width: 100%;
  max-height: 100%;
  padding: 25px 40px;
  max-width: 425px;
  
  .form {
    overflow: auto;
    max-height: 70vh;
  }

  .input-radio {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 12px;
    height: 20px;
    margin-bottom: 5px;

    input {
      width: auto;
      margin-right: 5px;
      margin-bottom: 0;
    }
  }

  .input-group {
    display: flex;
    justify-content: space-around;
  }

  .gestant-radio {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 12px;
    height: 20px;
    margin-bottom: 5px;

    input {
      width: auto;
      margin-right: 5px;
      margin-bottom: 0;
    }
  }

  h2 {
    position: relative;
    padding-bottom: 10px;
    margin-bottom: 10px;
  }

  h2::after {
    content: '';
    position: absolute;
    left: 50%;
    bottom: 0; 
    transform: translateX(-50%);
    height: 4px;
    width: 50px;
    border-radius: 20px;
    background-color: #fa183d;
  }
  input {
    width: 100%;
    padding: 0.5rem 1rem;
    outline: none; 
    border: 2px solid rgba(0, 0, 0, 0);
    background-color: rgba(230, 230, 230, 0.6);
    margin-bottom: 22px;
    transition: .3s;
  }

  input:hover {
    background-color: rgba(0, 0, 0, 0, 0.1);
  }

  input:focus {
    background-color: #FFF;
    border: 2px solid rgba(30, 85, 250, 0.47);
  }

  textarea {
    width: 100%;
    max-width: 345px;
    padding: 0.5rem 1rem;
    outline: none; 
    border: 2px solid rgba(0, 0, 0, 0);
    background-color: rgba(230, 230, 230, 0.6);
    margin-bottom: 22px;
    transition: .3s;
  }

  textarea:hover {
    background-color: rgba(0, 0, 0, 0, 0.1);
  }

  textarea:focus {
    background-color: #FFF;
    border: 2px solid rgba(30, 85, 250, 0.47);
  }
  
  textarea {
    min-height: 150px;
  }

  p {
    font-size: 12px;
  }

  .gestant-group {
    display: flexbox;
    align-items: center;
    justify-content: center;
    font-size: 12px;
    height: 20px;
    margin-bottom: 5px;
    justify-content: space-around;
  }

  .combox {

    p {
      text-align: left;
    }

    select {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 20px;
    margin-bottom: 1px;
    }
  }
`;

export const Button = styled.button`
  & {
    width: 100%;
    padding: 0.5rem 1rem;
    font-size: 1.1rem;
    background-color: #0065e1;
    cursor: pointer;
    outline: none;
    border: none;
    color: #FFF;
    transition: .3s;
    margin-bottom: 20px;
  }

  &:hover {
    background-color: #fa183d;
  }
`;