import preferences from './preferences/preferences.action'
import signIn from './signIn/signIn.action'

const actionsCreator = dispatch => ({
  preferences: preferences(dispatch),
  signIn: signIn(dispatch)
})

export default actionsCreator
