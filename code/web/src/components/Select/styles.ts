import styled, { css } from 'styled-components'
import { lighten } from 'polished'

import Tooltip from '../ToolTip'

interface IContainerProps {
  isFocused: boolean
  isFilled: boolean
  isErrored: boolean
}

export const Container = styled.div<IContainerProps>`
  padding: 16px;
  width: 100%;
  max-width: 340px;

  background: ${props => props.theme.backgroundAuxiliar};
  border-radius: 10px;
  border: 2px solid ${props => props.theme.backgroundAuxiliar};

  display: flex;
  align-items: center;

  color: ${props => props.theme.font};

  & + div {
    margin-top: 8px;
  }

  ${props =>
    props.isFocused &&
    css`
      color: ${props => props.theme.colors.green};
      border-color: ${props => props.theme.colors.green};
    `}

  ${props =>
    props.isFilled &&
    css`
      color: ${props => props.theme.colors.green};
    `}
  
  ${props =>
    props.isErrored &&
    css`
      border-color: ${props => props.theme.colors.red};
    `}

  select {
    flex: 1;
    background: transparent;
    border: none;
    font: inherit;

    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;

    color: ${props => props.theme.font};

    &::placeholder {
      color: ${props => lighten(0.15, props.theme.font)};
    }

    option {
      color: ${props => props.theme.colors.black};
    }
  }

  svg {
    margin-right: 16px;
  }
`

export const Error = styled(Tooltip)`
  height: 20px;
  margin-left: 16px;

  svg {
    margin: 0;
  }

  span {
    background: ${props => props.theme.colors.red};
    color: ${props => props.theme.font};

    &::before {
      border-color: ${props => props.theme.colors.red} transparent;
    }
  }
`
