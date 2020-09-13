import styled from 'styled-components'
import { shade } from 'polished'

export const Container = styled.div`
  position: fixed;
  right: 0;
  bottom: 0;
  padding: 12px;
  overflow: hidden;
  margin: 16px;

  border-radius: 50%;
  background: ${props => props.theme.alternativeBackground};
  transition: background-color 0.4s;

  &:hover {
    background: ${props => shade(0.2, props.theme.alternativeBackground)};
  }

  button {
    border: 0;
    background: transparent;

    display: flex;
    align-items: center;
    justify-content: center;

    svg {
      color: ${props => props.theme.fontAuxiliar};
      width: 34px;
      height: 34px;
    }
  }
`
