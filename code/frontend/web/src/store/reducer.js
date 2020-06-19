import login from './login/login.reducer'
import preferences from './preferences/preferences.reducer'
import register from './register/register.reducer'

const reducer = (state, action) => {
  let newState = state

  newState = login(newState, action)
  newState = preferences(newState, action)
  newState = register(newState, action)

  return newState
}

export default reducer
