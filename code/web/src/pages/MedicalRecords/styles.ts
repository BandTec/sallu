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
  align-items: center;
  justify-content: center;

  table {
    background: ${props => props.theme.primary};
    border-radius: 8px;

    width: 100%;
    height: 500px;

    display: flex;
    flex-direction: column;

    caption {
      display: flex;
      align-items: center;
      justify-content: space-between;

      background: ${props => props.theme.primary};

      text-align: right;
      font-size: 14px;

      a {
        display: flex;
        align-items: center;

        color: ${props => props.theme.secondary};
        transition: color 0.2s;

        &:hover {
          cursor: pointer;

          color: ${props => shade(0.2, props.theme.secondary)};
        }

        text-decoration: none;
        svg {
          margin-right: 8px;
        }
      }

      border-radius: 8px 8px 0px 0px;
      padding: 8px 16px;
    }

    thead,
    tbody,
    tfoot {
      tr {
        width: 100%;
        height: 100%;

        display: flex;
        justify-content: space-around;

        th,
        td {
          flex: 1;

          text-align: center;
        }
      }
    }

    thead {
      width: 100%;
      height: 56px;

      background: ${props => shade(0.2, props.theme.primary)};

      tr {
        align-items: center;
      }
    }

    tbody {
      width: 100%;
      height: 100%;
      overflow: auto;

      tr {
        height: 32px;
        align-items: center;

        td {
          height: 100%;
        }

        &:nth-child(odd) {
          background: ${props => shade(0.05, props.theme.primary)};
        }

        &:nth-child(even) {
          background: ${props => shade(0.15, props.theme.primary)};
        }
      }
    }

    tfoot {
      width: 100%;
      height: 48px;

      background: ${props => shade(0.2, props.theme.primary)};
      border-radius: 0px 0px 8px 8px;

      tr {
        height: 48px;
        align-items: center;
      }
    }
  }
`
