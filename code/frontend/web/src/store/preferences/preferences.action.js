const setPreferences = dispatch => (prop, value) => dispatch({
  type: 'SET_PREFERENCES',
  value: { prop, value }
})

const createActions = dispatch => ({
  setPreferences: setPreferences(dispatch)
})

export default createActions
