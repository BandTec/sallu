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
`

export const Header = styled.header`
  padding: 32px 0px;
  background: ${props => props.theme.primary};
`

export const HeaderContent = styled.div`
  max-width: 1120px;
  margin: 0 auto;

  display: flex;
  align-items: center;

  > img {
    height: 80px;
  }

  button {
    margin-left: auto;
    background: transparent;
    border: 0;

    & svg {
      color: ${props => props.theme.font};

      width: 20px;
      height: 20px;
    }
  }
`

export const Profile = styled.div`
  display: flex;
  align-items: center;
  margin-left: 80px;

  img {
    width: 56px;
    height: 56px;
    border-radius: 50%;
  }

  svg {
    background: ${props => props.theme.background};
    padding: 10px;
    width: 56px;
    height: 56px;
    border-radius: 50%;
  }

  div {
    display: flex;
    flex-direction: column;
    margin-left: 16px;
    line-height: 24px;

    span {
      color: ${props => props.theme.font};
    }

    a {
      text-decoration: none;
      color: ${props => props.theme.secondary};
      transition: color 0.2s;

      &:hover {
        color: ${props => shade(0.2, props.theme.secondary)};
      }

      strong {
        font-size: 18px;
      }
    }
  }
`

export const Content = styled.main`
  max-width: 1120px;
  margin: 64px auto;

  ul {
    flex: 1;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    list-style: none;

    li {
      display: flex;
      justify-content: center;

      padding: 24px;
      position: relative;
    }
  }
`
