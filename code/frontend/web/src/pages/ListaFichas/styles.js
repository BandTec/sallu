import styled from 'styled-components'
import { darken } from 'polished'

import {
  Table as MUITable,
  TableBody as MUITableBody,
  TableCell as MUITableCell,
  TableContainer as MUITableContainer,
  TableHead as MUITableHead,
  TableFooter as MUITableFooter,
  TableRow as MUITableRow
} from '@material-ui/core'

const tableColor = '#EDEDED'

export const Container = styled.div`
  height: 100%;
  display: flex;
  flex-direction: column;

  align-items: center;
  margin-top: 25px;
`

export const Title = styled.h1`
  display: flex;
`

/**
 * Estilizações relacionadas as tabelas
 */

export const Table = styled(MUITable)``

export const TableBody = styled(MUITableBody)`
  max-height: 530px;
  display: flex;
`

export const TableCell = styled(MUITableCell)``

export const TableContainer = styled(MUITableContainer)`
  display: flex;
  max-width: 80%;
  max-height: 597px;

  margin-top: 10px;

  box-shadow: 4px 4px 4px 4px rgba(0, 0, 0, 0.2);
  border-radius: 4px;

  background: ${tableColor};

`

export const TableHead = styled(MUITableHead)`
  th {
    background: ${darken(0.1, tableColor)};
    font-weight: 700;
  }
`

export const TableFooter = styled(MUITableFooter)``

export const TableRow = styled(MUITableRow)`
  display: flex;
  height: 54px;
  transition: 0.2s;

  &:nth-child(odd) {
    background: ${darken(0.05, tableColor)};
  }

  &.MuiTableRow-root.MuiTableRow-hover:hover {
    background: ${darken(0.15, tableColor)}
  }
`
