const reducer = (state, { type, value: { prop, value } }) => {
  switch (type) {
    case 'SET_LOGIN':
      return {
        ...state,
        login: {
          ...state.login,
          [prop]: value
        }
      }

    default:
      return state;
  }
}

export default reducer;