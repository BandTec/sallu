import styled from 'styled-components'
import { readableColor } from 'polished'

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

  margin: 64px auto;
  padding: 0px 32px;

  display: flex;
  align-items: center;
  justify-content: center;

  form {
    width: 340px;
    text-align: center;

    h3 {
      margin-bottom: 24px;
    }
  }
`
