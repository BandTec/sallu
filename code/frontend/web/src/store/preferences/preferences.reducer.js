const reducer = (state, { type, value: { prop, value } }) => {
  switch (type) {
    case 'SET_PREFERENCES':
      localStorage.setItem('preferences', JSON.stringify({
        ...state.preferences,
        [prop]: value
      }))
      return {
        ...state,
        preferences: {
          ...state.preferences,
          [prop]: value
        }
      }

    default:
      return state
  }
}

export default reducer
