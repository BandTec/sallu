const setLogin = dispatch => (prop, value) => dispatch({
  type: 'SET_LOGIN',
  value: { prop, value }
})

const createActions = dispatch => ({
  setLogin: setLogin(dispatch)
})

export default createActions
