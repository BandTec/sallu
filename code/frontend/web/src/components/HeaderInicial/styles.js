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

  button{
    height: 60px;
    width: 60px;
    border-radius: 4px;
    border: 1px solid #526CC5;
    background: #526CC5;
    color: #526CC5;
    margin-left: px;
    transition: border-color 0.2s;
    position: absolute;
    top: 50%;
    
    display: flex;
    text-align:end;
    

}

button :hover{
    border-color: #999;
}
`;
