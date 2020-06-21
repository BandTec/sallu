import styled from 'styled-components'
import { Link } from 'react-router-dom'

export const Container = styled.div`
  width: 100%;
  height: 100%;

  display: flex;
  align-items: center;

  padding: 20px 20px;
`

export const LinkButton = styled(Link)`
  display: flex;
  align-items: center;

  transition: 0.2s;
  color: #41414d;

  font-size: 18px;

  svg {
    margin-right: 8px;
  }

  &:hover{
    opacity: 0.8;
    color: #32be8f;
  }
`

export const DoctorImage = styled.img`
  width: 50%;
`

export const LoginContent = styled.div`
  width: 100%;
  height: 100%;

  display: flex;
  align-items: center;
  text-align: center;
`

export const AvatarImage = styled.img`
  height: 128px;
`

export const RegisterTitle = styled.h2`
  margin: 15px 0;
  color: #333;
  /* text-transform: uppercase; */
  font-size: 2.9rem;
`

export const InputContainer = styled.div`
  width: 360px;
  margin: 0 0 25px 0;
  padding: 5px 0;
  border-bottom: 2px solid #d9d9d9;

`

export const Input = styled.input`
  width: 100%;

  color: #555;
  opacity: 75%;
  font-weight: 600;
  font-size: 18px;

  border: none;
  background: none;
  padding: 0.5rem 0.7rem;

`

export const Form = styled.form`
  width: 100%;
  height: 100%;

  @media screen and (min-height: 1024px) {
    height: 80%;

  }

  overflow: auto;
  display: flex;
  flex-direction: column;
  align-items: center;
`

export const Button = styled.button`
  width: 360px;
  min-height: 50px;

  margin: 15px auto;
    
  border-radius: 25px;
  border: none;

  font-size: 18px;
  text-transform: uppercase;

  cursor: pointer;
  color: #fff;
  background-image:linear-gradient(to right, #32be8f, #38d39f, #32be8f);
  transition: 0.2s;
`
