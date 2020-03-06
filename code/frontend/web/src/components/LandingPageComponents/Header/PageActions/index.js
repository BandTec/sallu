import React from 'react'
import styled from 'styled-components'

const ActContainer = styled.div`
  width: 50%;
  display: flex;
  align-items: center;
  justify-content: space-around;
`

const ActBtn = styled.a`
  margin: ${({ theme }) => `0px ${theme.margin(0.5)}`};
  border: ${({ theme }) => theme.borderRadius(5)};
  border-radius: ${({ theme }) => theme.borderRadius(1)};
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  background: ${({ theme }) => theme.primary.main};
  &:hover {
    background: ${({ theme }) => theme.primary.hover};
  }
`

const PageActions = () => {
  return (
    <ActContainer>
      <ActBtn>Home</ActBtn>
      <ActBtn>Sobre Nós</ActBtn>
      <ActBtn>Serviço</ActBtn>
      <ActBtn>Contato</ActBtn>
    </ActContainer>
  )
}

export default PageActions
