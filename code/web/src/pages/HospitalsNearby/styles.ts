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

      display: flex;
      flex-direction: row;
      justify-content: space-between;

      svg {
        color: ${props => props.theme.font};
        width: 24px;
        height: 24px;
      }

      h1 {
        font-size: 32px;
      }
    }
  }
`

export const Content = styled.main`
  max-width: 1120px;
  max-height: 450px;

  margin: 64px auto;
  padding: 0px 32px;

  display: flex;

  > div {
    flex: 2;
    width: 100%;

    background: ${props => props.theme.primary};
  }

  aside {
    margin-left: 24px;

    flex: 1;
    width: 100%;
    height: 450px;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    background: ${props => props.theme.primary};

    padding: 15px;
    overflow: auto;
  }

  div,
  aside {
    border-radius: 8px;
  }
`

export const AddressContainer = styled.span`
  width: 100%;
  height: 56px;

  padding: 8px;
  border-radius: 8px;
  background: ${props => props.theme.background};

  display: flex;

  margin-top: 12px;

  svg {
    width: 40px;
    height: 40px;
  }

  div {
    margin-left: 12px;
    background: ${props => props.theme.background};

    display: flex;
    flex-direction: column;

    strong {
      font-size: 20px;
    }

    a {
      text-decoration: none;
      font-size: 16px;
      color: ${props => props.theme.secondary};
      transition: color 0.2s;

      &:hover {
        color: ${props => shade(0.2, props.theme.secondary)};
      }
    }
  }
`
