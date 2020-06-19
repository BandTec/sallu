import styled from 'styled-components';

export const Container = styled.div`
  height: 80px;
  padding: 0 30px;
  background: #247ba0;
  color: #FFF;

  display: flex;
  align-items: center;

  img {
    max-width: 200px;
    width: 100%;
  }

  #button {
  position: absolute;
  bottom: 90%;
  left: 90%;
}
  
#button{
  height: 60px;
  width: 60px;
  border-radius: 50px;
  border: 1px solid #dcdce6;
  background: transparent;
  margin-left: 16px;
  transition: border-color 0.2s;
  background-color: #FC6963;
  border: none;
 
}

#button :hover{
  border-color: #999;
}

  #btn2 {
  position: absolute;
  bottom: 90%;
  left: 85%;
}

#btn2{
  height: 60px;
  width: 60px;
  border-radius: 50px;
  border: 1px solid #dcdce6;
  background: transparent;
  margin-left: 16px;
  transition: border-color 0.2s;
  border: none;
  background-color: #c0fdff;
}

#btn2 :hover{
  border-color: #999;
}
`;
