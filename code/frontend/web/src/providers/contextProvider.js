import React, { createContext, useReducer } from 'react'

import {
  actionsCreator, // Actions
  initialState, // States
  reducer // Reducers
} from '../store'

// =============================================================================
// Contexto
// =============================================================================

const AppContext = createContext()

// =============================================================================
// Component
// =============================================================================

const ContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState)
  const actions = actionsCreator(dispatch)

  const { Provider } = AppContext

  return (
    <Provider value={{ state, dispatch, actions }}>
      {children}
    </Provider>
  )
}

export { AppContext, ContextProvider }