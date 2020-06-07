import styled from 'styled-components';

export const Container = styled.div`
  height: 80px;
  padding: 0 30px;
  background: #526CC5;
  color: #FFF;

  display: flex;
  align-items: center;

  img {
    max-width: 200px;
    width: 100%;
  }

  
#button{
  height: 60px;
  width: 60px;
  border-radius: 4px;
  border: 1px solid #dcdce6;
  background: transparent;
  margin-left: 16px;
  transition: border-color 0.2s;
}

#button :hover{
  border-color: #999;
}
`;
