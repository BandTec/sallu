import styled from 'styled-components'
import { Link } from 'react-router-dom'

export const PageContainer = styled.div`
  height: 100%;
  padding-top: 10px;

  .btn2{
    position: absolute;
    bottom: 92%;
    left: 93%;

    height: 40px;
    width: 40px;
    border-radius: 50px;
    border: 1px solid #dcdce6;
    background: transparent;
    margin-left: 16px;
    transition: border-color 0.2s;
    background-color: #FC6963;
  }

  .btn3{
    position: absolute;
    bottom: 92%;
    left: 89%;

    height: 40px;
    width: 40px;
    border-radius: 50px;
    border: 1px solid #dcdce6;
    background: transparent;
    margin-left: 16px;
    transition: border-color 0.2s;
    background-color: #c0fdff;
  }

    h1 {
    font-size: 24px;
    position: relative;
    text-align: center;
    color: #526CC5;
    margin: 50px;
  }
`

export const Container = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
`

export const MenuContainer = styled.div`
  overflow: auto;
  width: 100%;
  height: 100%;

  display: grid;
  grid-template-columns: repeat(1, 2fr);
    
  @media screen and (min-width: 600px) {
    grid-template-columns: repeat(2, 2fr);
  }
  
  @media screen and (min-width: 1040px) {
    grid-template-columns: repeat(4, 1fr);
  }
`

export const Card = styled(Link)`
  margin: 15px;
  padding: 15px;

  min-width: 200px;
  height: 220px;

  background: #FFF;
  border-radius: 8px;
  display: flex;
  text-align: center;
  align-items: center;
  flex-direction: column;
`

export const CardIcon = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 120px;
  height: 120px;

  border-radius: 100%;
  background: ${props => props.color};  

  img {
    width: 90px;
    height: 80px; 
    justify-content: center;
    text-align: center;
    align-items: center;
    margin: 0;
  }
`
