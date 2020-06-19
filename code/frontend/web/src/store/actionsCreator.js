import login from './login/login.action'
import preferences from './preferences/preferences.action'
import register from './register/register.action'

const actionsCreator = dispatch => ({
  login: login(dispatch),
  preferences: preferences(dispatch),
  register: register(dispatch)
})

export default actionsCreator
