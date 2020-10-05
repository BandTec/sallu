import styled from 'styled-components'
import { readableColor, shade } from 'polished'

import lightTransparentLogo from '../../assets/images/logo-transparent.svg'
import darkTransparentLogo from '../../assets/images/logo-alt-transparent.svg'

export const Container = styled.div`
  height: 100vh;

  background: ${props => {
    return readableColor(props.theme.font) === '#fff'
      ? `url(${lightTransparentLogo}) no-repeat 90% 85%`
      : `url(${darkTransparentLogo}) no-repeat 90% 85%`
  }};

  > header {
    height: 144px;
    background: ${props => props.theme.primary};

    display: flex;
    align-items: center;

    div {
      width: 100%;
      max-width: 1120px;
      margin: 0 auto;

      svg {
        color: ${props => props.theme.font};
        width: 24px;
        height: 24px;
      }
    }
  }
`

export const Content = styled.div`
  width: 100%;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  margin: -140px auto 0;

  form {
    margin: 40px 0;
    width: 340px;
    text-align: center;

    display: flex;
    flex-direction: column;

    h1 {
      margin-bottom: 24px;
      font-size: 20px;
      text-align: left;
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
`

export const AvatarInput = styled.div`
  margin-bottom: 32px;
  position: relative;

  align-self: center;

  img {
    width: 186px;
    height: 186px;
    border-radius: 50%;
  }

  > svg {
    background: ${props => props.theme.background};
    padding: 20px;
    border: 2px solid ${props => props.theme.font};

    width: 186px;
    height: 186px;
    border-radius: 50%;
  }

  label {
    position: absolute;
    width: 48px;
    height: 48px;
    background: ${props => props.theme.colors.green};
    border-radius: 50%;

    right: 0;
    bottom: 0;

    cursor: pointer;
    border: 0;
    transition: background-color 0.2s;

    display: flex;
    align-items: center;
    justify-content: center;

    input {
      display: none;
    }

    svg {
      width: 20px;
      height: 20px;
      color: ${props => props.theme.darkGray};
    }

    &:hover {
      background: ${props => shade(0.2, props.theme.colors.green)};
    }
  }
`
