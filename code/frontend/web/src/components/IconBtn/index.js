import { IconButton } from '@material-ui/core'
import styled from 'styled-components'

const IconBtn = styled(IconButton)`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 !important;
  width: ${({ theme }) => theme.margin(2.5)};
  height: ${({ theme }) => theme.margin(2.5)};
  color: ${({ theme }) => theme.main.ft};
  &:hover {
    background: ${({ theme }) => theme.main.hv};
  }
`
export default IconBtn
