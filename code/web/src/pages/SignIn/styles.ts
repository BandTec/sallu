import styled, { keyframes } from 'styled-components'
import { shade, readableColor } from 'polished'

import lightTransparentLogo from '../../assets/images/logo-transparent.svg'
import darkTransparentLogo from '../../assets/images/logo-alt-transparent.svg'

export const Container = styled.div`
  padding: 32px;
  height: 100vh;

  background: ${props => {
    return readableColor(props.theme.font) === '#fff'
      ? `url(${lightTransparentLogo}) no-repeat 70% 15%`
      : `url(${darkTransparentLogo}) no-repeat 70% 15%`
  }};

  display: flex;
  align-items: stretch;
`

export const Content = styled.div`
  width: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`

const appearFromLeft = keyframes`
  from {
    opacity: 0;
    transform: translateX(-50px);
  }

  to {
    opacity: 1;
    transform: translateX(0);
  }
`

export const AnimationContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  animation: ${appearFromLeft} 1s;

  form {
    margin: 40px 0;
    width: 340px;
    text-align: center;

    h3 {
      margin-bottom: 24px;
    }

    a {
      color: ${props => props.theme.font};
      display: block;
      margin-top: 24px;
      text-decoration: none;
      transition: color 0.2s;

      &:hover {
        color: ${props => shade(0.2, props.theme.font)};
      }
    }
  }

  > a {
    color: ${props => props.theme.secondary};
    display: block;
    margin-top: 24px;
    text-decoration: none;
    transition: color 0.2s;

    display: flex;
    align-items: center;

    svg {
      margin-left: 16px;
    }

    &:hover {
      color: ${props => shade(0.2, props.theme.secondary)};
    }
  }
`

export const Background = styled.div`
  width: 100%;

  display: flex;
  align-items: center;
  justify-content: center;

  img {
    width: 100%;
  }

  @media only screen and (max-width: 1200px) {
    display: none;
  }
`
