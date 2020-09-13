import styled from 'styled-components'
import { shade } from 'polished'
import { Link } from 'react-router-dom'

export const Container = styled(Link)`
  text-decoration: none;

  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: space-between;

  color: ${props => props.theme.font};
  background: ${props => props.theme.primary};
  transition: background-color 0.2s;

  padding: 28px 14px;
  border-radius: 16px;

  &:disabled {
    opacity: 0.7;
    cursor: not-allowed;

    &:hover {
      background: ${props => props.theme.secondary};
    }
  }

  &:hover {
    background: ${props => shade(0.2, props.theme.primary)};
  }

  max-width: 360px;
  flex: 1;

  svg {
    color: ${props => props.theme.colors.green};
    width: 48px;
    height: 48px;
  }

  strong {
    margin-top: 14px;

    align-self: right;
    font-size: 20px;
  }

  span {
    margin-top: 14px;

    text-align: left;
    font-size: 15px;
  }
`
