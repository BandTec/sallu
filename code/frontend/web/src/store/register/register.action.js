const setRegister = dispatch => (prop, value) =>
  dispatch({
    type: 'SET_REGISTER',
    value: { prop, value }
  })

const createActions = dispatch => ({
  setRegister: setRegister(dispatch)
})

export default createActions
