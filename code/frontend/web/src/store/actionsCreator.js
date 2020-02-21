import signIn from './signIn/signIn.action';

const actionsCreator = dispatch => ({
  signIn: signIn(dispatch)
});

export default actionsCreator;