import styled from 'styled-components'
import { shade } from 'polished'

export const Container = styled.button`
  margin-top: 16px;
  padding: 0 16px;
  width: 100%;
  height: 56px;

  background: ${props => props.theme.secondary};
  border-radius: 10px;
  border: 0;

  color: #333;

  font-weight: 500;
  transition: background-color 0.2s;

  &:disabled {
    opacity: 0.7;
    cursor: not-allowed;

    &:hover {
      background: ${props => props.theme.secondary};
    }
  }

  &:hover {
    background: ${props => shade(0.2, props.theme.secondary)};
  }
`
