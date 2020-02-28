import preferencesReducer from './preferences/preferences.reducer'
import signInReducer from './signIn/signIn.reducer'

const reducer = (state, action) => {
  let newState = state

  newState = preferencesReducer(newState, action)
  newState = signInReducer(newState, action)

  return newState
}

export default reducer
