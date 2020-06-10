import styled from 'styled-components'

export const Container = styled.div`
    width: 100vw;
    height: 100vh;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-gap :7rem;
    padding: 0 2rem;
    overflow:auto;

    div {
      width: 100%;

      display: flex;
      justify-self: center;
     
      img {
        width: 100%;
        object-fit: contain;
      }
    }
`

export const LoginContent = styled.div`
    display: flex;
    justify-content: flex-start;
    align-items: center;
    text-align: center;

    img {
      height: 120px;
      width: 110px;
      right: 20%;
    }

    h2 {
      margin: 15px 0;
      color: #333;
      text-transform: uppercase;
      font-size: 2.9rem;
    }

    .input-div {
      max-width: 360px;
      position: relative;
      display: grid;
      grid-template-columns: 7% 93%;
      margin: 25px 0;
      padding: 5px 0;
      border-bottom: 2px solid #d9d9d9;
      
    }

    .input-div.one {
      margin-top: 0;
    }

    .input-div > div {
      position: relative;
      height: 45px;
    }

    .input-div > h5 > div {
      position: absolute;
      left: 10px;
      top: 50%;
      transform: translateY(-50%);
      color: #999;
      font-size: 18px;
      transition: .3s;
    }

    .input-div:before, .input-div:after {
      content: '';
      position: absolute;
      bottom: -2px;
      width: 0%;
      height: 2px;
      background-color: #38d39f;
      transition: .4s;
    }

    .input-div:before {
      right: 50%;
    }

    .input-div:after {
      left: 50%;
    }

    .input-div.focus:before, .input-div.focus:after {
      width: 50%;
    }

    .input-div.focus > div > h5 {
      top: -5px;
      font-size: 15px;
    }

    .input-div > div > input {
      /* position: absolute; */
      /* left: 0; */
      /* top: 0; */
      width: calc(360px - 1.4rem);
      height: 100%;
      border: none;
      outline: none;
      background: none;
      padding: 0.5rem 0.7rem;
      font-size: 1.2rem;
      color: #555;
    }

    .input-div.pass {
      margin-bottom: 4px;
    }

    a {
      display: block;
      text-align: right;
      text-decoration: none;
      color: #999;
      font-size: 0.9rem;
      transition: .3s;
    }

    a:hover {
      color: #38d39f;
    }

    button {
      display: block;
      width: 100%;
      height: 50px;
      border-radius: 25px;
      outline: none;
      border: none;
      background-image: linear-gradient(to right, #FF5050, #FF5050, #FF5050);
      background-size: 200%;
      font-size: 1.2rem;
      color: #fff;
      text-transform: uppercase;
      margin: 1rem 0;
      cursor: pointer;
      transition: 0.5s;
      max-width: 360px;
    }

    button:hover {
      background-position: right;
    }

`

export const Form = styled.form`
    width: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    .link {
      width: 100%;
      max-width: 360px;
      display: flex;

      a {
        width: 100%;
        align-self: flex-end;
      }
    }

    
.back-links {
  display: flex;
  align-items: center;
  margin-bottom: 40px;
  color: #41414d;
  font-size: 18px;
  text-decoration: none;
  font-weight: 500;
  transition: opacity 0.2s;
}

.back-links svg{
  margin-right: 8px;
}

.back-links:hover{
  opacity: 0.8;
}
`

// export const Button = styled.button`

// `;
