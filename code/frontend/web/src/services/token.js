import jwtDecode from 'jwt-decode'

const TokenService = () => ({
  /**
 * @param {String} token
 */
  decodeToken: token => jwtDecode(token),

  /**
   * Get Authentication Token
   * @returns {String}
   */
  getToken: () => localStorage.getItem('access_token') , 
  

  /**
   * Set Authentication Token
   * @param {String} token
   * @returns {Void}
   */
  setToken: token => localStorage.setItem('access_token', token),

  /**
   * Clear Authentication Token
   * @returns {Void}
   */
  resetToken: () => localStorage.removeItem('access_token')
})

export default TokenService
