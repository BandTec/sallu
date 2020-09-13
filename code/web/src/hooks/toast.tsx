import React, { createContext, useContext, useCallback, useState } from 'react'
import { v4 as uuid } from 'uuid'

import ToastContainer from '../components/ToastContainer'

export interface IToastMessage {
  id: string
  type?: 'success' | 'error' | 'info'
  title: string
  description?: string
}

interface IAddToastCallback {
  (toast: Omit<IToastMessage, 'id'>): void
}

interface IRemoveToastCallback {
  (id: string): void
}

interface IToastContextData {
  addToast: IAddToastCallback
  removeToast: IRemoveToastCallback
}

const ToastContext = createContext<IToastContextData>({} as IToastContextData)

export const ToastProvider: React.FC = ({ children }) => {
  const [messages, setMessages] = useState<IToastMessage[]>([])

  const addToast = useCallback<IAddToastCallback>(
    ({ title, description, type }) => {
      const id = uuid()

      const toast = {
        id,
        type,
        title,
        description,
      }

      setMessages(state => [...state, toast])
    },
    [],
  )

  const removeToast = useCallback<IRemoveToastCallback>(id => {
    setMessages(state => state.filter(message => message.id !== id))
  }, [])

  return (
    <ToastContext.Provider value={{ addToast, removeToast }}>
      {children}
      <ToastContainer messages={messages} />
    </ToastContext.Provider>
  )
}

export function useToast(): IToastContextData {
  const context = useContext(ToastContext)

  if (!context) {
    throw new Error('useAuth must be used within an ToastProvider')
  }

  return context
}
