const TOKEN_KEY = '';
const isAuthenticated = () => localStorage.getItem(TOKEN_KEY) !== null;

const getToken = () => localStorage.getItem(TOKEN_KEY);
const setToken = token => localStorage.setItem(TOKEN_KEY, token);
const resetToken = () => localStorage.removeItem(TOKEN_KEY);

export {
  isAuthenticated,
  getToken,
  setToken,
  resetToken
};