import signInReducer from './signIn/signIn.reducer';

const reducer = (state, action) => {
  let newState = state;

  newState = signInReducer(newState, action);

  return newState;
}

export default reducer;