const reducer = (state, { type, value: { prop, value } }) => {
  switch (type) {
    case 'SET_REGISTER':
      return {
        ...state,
        register: {
          ...state.register,
          [prop]: value
        }
      }

    default:
      return state
  }
}

export default reducer
