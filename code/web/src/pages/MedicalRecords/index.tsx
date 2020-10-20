import React, { useCallback, useEffect, useRef } from 'react'
import { Link } from 'react-router-dom'
import { FiArrowLeft, FiDownload } from 'react-icons/fi'

import api from '../../services/api'
import { useAuth, IUser } from '../../hooks/auth'
import { useToast } from '../../hooks/toast'

import { Container, Content } from './styles'

const MedicalRecords: React.FC = () => {
  const downloadLinkRef = useRef<HTMLAnchorElement>(null)

  const { user, updateUser, token } = useAuth()
  const { addToast } = useToast()

  const fetchMedicalRecords = useCallback(async () => {
    const response = await api.get<IUser>(`user/${user.id}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })

    updateUser(response.data)
  }, [updateUser, user.id, token])

  const fetchMedicalRecordsFile = useCallback(async () => {
    try {
      const response = await api.get('geraTxt', {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })

      const file = new Blob([response.data], { type: 'text/plain' })

      if (downloadLinkRef.current) {
        downloadLinkRef.current.href = URL.createObjectURL(file)
        downloadLinkRef.current.download = `medical-records-${Date.now()}.txt`
        downloadLinkRef.current.onclick = null

        downloadLinkRef.current.click()

        addToast({
          title: 'Planilha exportada com sucesso!',
          description: 'Aguarde o download para ter a sua planilha em mãos',
          type: 'success',
        })
      }
    } catch (error) {
      addToast({
        title: 'Erro de exportação',
        description:
          'Houve um erro ao tentar exportar o arquivo, tente novamente mais tarde.',
        type: 'error',
      })
    }
  }, [token, addToast])

  useEffect(() => {
    fetchMedicalRecords()
  }, [fetchMedicalRecords])

  return (
    <Container>
      <header>
        <div>
          <Link to="/dashboard">
            <FiArrowLeft />
          </Link>
          <h1>Suas fichas médicas</h1>
        </div>
      </header>

      <Content>
        <table>
          <caption>
            {/* eslint-disable-next-line */}
            <a onClick={fetchMedicalRecordsFile} ref={downloadLinkRef}>
              <FiDownload /> baixar fichas médicas
            </a>

            <p>
              {user.medicalRecords.length === 1
                ? `Foi encontrado ${user.medicalRecords.length} registro`
                : `Foram encontrados ${user.medicalRecords.length} registros`}
              .
            </p>
          </caption>
          <thead>
            <tr>
              <th>Atendimento</th>
              <th>Classificação</th>
              <th>Peso</th>
              <th>Altura</th>
              <th>Alergia</th>
              <th>Data de registro</th>
            </tr>
          </thead>

          <tbody>
            {user.medicalRecords.map((medicalRecord, index) => (
              <tr key={index}>
                {medicalRecord.hospital && (
                  <td>{medicalRecord.hospital.name}</td>
                )}
                <td>{medicalRecord.referral.color}</td>
                <td>{medicalRecord.weight}</td>
                <td>{medicalRecord.height}</td>
                <td>{medicalRecord.allergy}</td>
                <td>{medicalRecord.createdAt}</td>
              </tr>
            ))}
          </tbody>

          <tfoot>
            <tr>
              <td></td>
            </tr>
          </tfoot>
        </table>
      </Content>
    </Container>
  )
}

export default MedicalRecords
