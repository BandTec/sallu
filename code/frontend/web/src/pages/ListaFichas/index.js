import React, { useState, useEffect } from 'react'
import { useApiService, useTokenService } from '../../services'
import { FiDownload } from 'react-icons/fi'
import Swal from 'sweetalert2'

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
  const { getToken } = useTokenService()
  const [api] = useApiService()
  const [ficha, setFicha] = useState([])

  useEffect(() => {
    api.get(`user/${localStorage.getItem('id')}`, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    }).then(response => {
      setFicha(response.data.medicalRecords)
    })
  }, [])

  function gerarTxt () {
    api.get('geraTxt', {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    }).then(response => {
      console.log(response.data)
      Swal.fire(
        'Boa!!!',
        'Exportação de dados realizada com sucesso.',
        'success'
      )
    })
  }

  return (
    <>
      <Header />
      <Container>
        <Title>Histórico de fichas médicas</Title>
        <button onClick={gerarTxt} ><FiDownload size={16} color="#526CC5" /> Exportar Dados </button>
        <TableContainer>
          <Table stickyHeader>
            <TableHead>
              <TableRow>
                <TableCell>DATA FICHA</TableCell>
                <TableCell>ALERGIA</TableCell>
                <TableCell>PESO</TableCell>
                <TableCell>ALTURA</TableCell>
                <TableCell>CLASSIFICAÇÃO</TableCell>
                <TableCell>ATENDIMENTO</TableCell>
              </TableRow>
            </TableHead>

            <TableBody>
              {ficha.map((ficha) => (
                <TableRow hover role="checkbox" tabIndex={-1} key={ficha.idFichaMedica}>
                  <TableCell>{ficha.dataFicha}</TableCell>
                  <TableCell>{ficha.alergia}</TableCell>
                  <TableCell>{ficha.peso}</TableCell>
                  <TableCell>{ficha.altura}</TableCell>
                  <TableCell>{ficha.classificacao.corClassificada}</TableCell>
                  <TableCell>{ficha.hospital.nomeHospital}</TableCell>
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
