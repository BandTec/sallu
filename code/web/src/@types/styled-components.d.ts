import 'styled-components'
import { ITheme } from '../hooks/theme'

declare module 'styled-components' {
  export interface DefaultTheme extends ITheme {
    [key: string]: any
  }
}
