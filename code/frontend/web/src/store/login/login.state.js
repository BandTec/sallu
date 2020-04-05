// =============================================================================
// Initial State
// =============================================================================
const loginState = {
  // Data
  email: '',
  password: '',
  // Params
  rememberMe: false,
  showPassword: false,
  // Returns
  invalidCredentials: false,
  connectionError: false,
  // Messages
  errorMessage: null
}

export default loginState
