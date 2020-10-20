import React, { createContext, useCallback, useState, useContext } from 'react'

import api from '../services/api'

interface MedicalRecordAddress {
  id: number
  cep: string
  address: string
  district: string
  number: string
  city: string
  state: string
}

interface MedicalRecord {
  hospital?: {
    id: number
    name: string
    cnpj: string
    telehpone: string
    email: string
    address: MedicalRecordAddress
  }
  referral: {
    id: string
    color: string
    call: string
  }
  weight: number
  height: number
  bloodPressure: number
  bodyTemperature: number
  allergy: string
  lastCycle: string
  isPregnant: boolean
  createdAt: string
}

export interface IUser {
  id: number
  medicalRecords: MedicalRecord[]
  name: string
  cellphone: string
  birthday: string
  sex: string
  email: string
  /** @deprecated */
  avatarUrl?: string
}

interface IAuthState {
  token: string
  user: IUser
}

interface IAuthStateResponse extends IAuthState {
  user: IUser & { password: string }
}

interface ISignInCredentials {
  email: string
  password: string
}

interface IAuthContextData {
  user: IUser
  token: string
  signIn(credentials: ISignInCredentials): Promise<void>
  signOut(): void
  updateUser(user: IUser): void
}

const AuthContext = createContext<IAuthContextData>({} as IAuthContextData)

export const AuthProvider: React.FC = ({ children }) => {
  const [data, setData] = useState<IAuthState>(() => {
    const token = localStorage.getItem('@SallutApp:token')
    const user = localStorage.getItem('@SallutApp:user')

    if (token && user) {
      return { token, user: JSON.parse(user) }
    }

    return {} as IAuthState
  })

  const signIn = useCallback(async ({ email, password }) => {
    const response = await api.post<IAuthStateResponse>('auth', {
      email,
      password,
    })

    const { token, user } = response.data

    delete user.password

    localStorage.setItem('@SallutApp:token', token)
    localStorage.setItem('@SallutApp:user', JSON.stringify(user))

    setData({ token, user })
  }, [])

  const signOut = useCallback(() => {
    localStorage.removeItem('@SallutApp:token')
    localStorage.removeItem('@SallutApp:user')

    setData({} as IAuthState)
  }, [])

  const updateUser = useCallback(
    (user: IUser) => {
      localStorage.setItem('@SallutApp:user', JSON.stringify(user))

      setData({
        token: data.token,
        user,
      })
    },
    [setData, data.token],
  )

  return (
    <AuthContext.Provider
      value={{
        user: data.user,
        token: data.token,
        signIn,
        signOut,
        updateUser,
      }}
    >
      {children}
    </AuthContext.Provider>
  )
}

export function useAuth(): IAuthContextData {
  const context = useContext(AuthContext)

  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider')
  }

  return context
}
