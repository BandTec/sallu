import React from 'react'

import {
  Container,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  // TableFooter,
  TableHead,
  TableRow,
  Title
} from './styles'

import Header from '../../components/Header'

const ListaFichas = () => {
  const createPaciente = (nome, sexo, classificacao, atendimento) => {
    return { nome, sexo, classificacao, atendimento }
  }

  const pacientes = [
    createPaciente('Emanuel Raul Aragão', 'masculino', 'Verde', '0001'),
    createPaciente('Juan Ian Renan Baptista', 'masculino', 'Vermelho', '0002'),
    createPaciente('Noah João da Rocha', 'masculino', 'Verde', '0003'),
    createPaciente('Fernanda Esther Aparecida Bernardes', 'feminino', 'Amarelo', '0004'),
    createPaciente('Emanuel Raul Aragão', 'masculino', 'Verde', '0005'),
    createPaciente('Juan Ian Renan Baptista', 'masculino', 'Vermelho', '0006'),
    createPaciente('Noah João da Rocha', 'masculino', 'Verde', '0007'),
    createPaciente('Fernanda Esther Aparecida Bernardes', 'feminino', 'Amarelo', '0008'),
    createPaciente('Emanuel Raul Aragão', 'masculino', 'Verde', '0009'),
    createPaciente('Juan Ian Renan Baptista', 'masculino', 'Vermelho', '0010')
  ]

  return (
    <>
      <Header />
      <Container>

        <Title>Lista de Pacientes</Title>
        <TableContainer>
          <Table stickyHeader>

            <TableHead>
              <TableRow>

                <TableCell>Paciente</TableCell>
                <TableCell>Sexo</TableCell>
                <TableCell>Classificação</TableCell>
                <TableCell>Nº do atendimento</TableCell>

              </TableRow>
            </TableHead>

            <TableBody>
              {pacientes.map((paciente) => (
                <TableRow hover role="checkbox" tabIndex={-1} key={paciente.atendimento}>

                  <TableCell component={'th'} scope={'row'}>
                    {paciente.nome}
                  </TableCell>

                  <TableCell>{paciente.sexo}</TableCell>
                  <TableCell>{paciente.classificacao}</TableCell>
                  <TableCell>{paciente.atendimento}</TableCell>

                </TableRow>
              ))}
            </TableBody>

          </Table>
        </TableContainer>

      </Container>
    </>
  )
}

export default ListaFichas
