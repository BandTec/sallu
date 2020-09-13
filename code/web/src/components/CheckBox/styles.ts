import styled from 'styled-components'

export const Container = styled.label`
  display: flex;
  align-items: center;

  position: relative;

  padding-left: 34px;
  margin-bottom: 10px;
  height: 22px;

  cursor: pointer;
  user-select: none;

  color: ${props => props.theme.font};
  font-size: 16px;

  & + div,
  & + label {
    margin-top: 8px;
  }

  &:hover span,
  input:checked ~ span {
    background: ${props => props.theme.secondary};
  }

  input {
    cursor: pointer;

    position: absolute;
    opacity: 0;
    height: 0;
    width: 0;

    &:checked ~ span:after {
      display: block;
    }
  }

  span {
    position: absolute;
    top: 0;
    left: 0;

    height: 22px;
    width: 22px;

    background: ${props => props.theme.backgroundAuxiliar};

    border: 1px solid ${props => props.theme.primary};
    border-radius: 5px;
    transition: 180ms ease-in-out;

    &:after {
      content: '';

      position: absolute;
      left: 6.8px;
      top: 3px;

      display: none;

      width: 4px;
      height: 8px;

      border: solid white;
      border-width: 0 3px 3px 0;

      transform: rotate(45deg);
    }
  }
`
