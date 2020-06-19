import React from 'react'
import styled from 'styled-components'

const ActContainer = styled.div`
  width: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
`

const ActBtn = styled.a`
  margin: ${({ theme }) => `0px ${theme.margin(0.5)}`};
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  &:hover {
    color: ${({ theme }) => theme.primary.light};
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
