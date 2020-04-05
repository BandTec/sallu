import preferences from './preferences/preferences.action'
import login from './login/login.action'

const actionsCreator = dispatch => ({
  preferences: preferences(dispatch),
  login: login(dispatch)
})

export default actionsCreator
