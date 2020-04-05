import preferencesReducer from './preferences/preferences.reducer'
import loginReducer from './login/login.reducer'

const reducer = (state, action) => {
  let newState = state

  newState = preferencesReducer(newState, action)
  newState = loginReducer(newState, action)

  return newState
}

export default reducer
