import axios from 'axios'

import tokenService from './token'

/**
 * @typedef {import('axios').AxiosInstance} AxiosInstance
 */

const { getToken } = tokenService()

const ApiService = (apiName = 'api') => {
  const apis = {
    api: axios.create({
      baseURL: 'http://localhost:8080'
    })
  }

  if (!apis[apiName]) {
    throw new TypeError('Please, chosse a valid API Name')
  }

  /**
   * Set Authorization of given API
   * @returns {Void}
   */
  const handleSetAuthorization = () =>
    apis[apiName].interceptors.request.use(async config => {
      const token = getToken()
      if (token) config.headers.Authorization = `Bearer ${token}`

      return config
    })

  return [
    /** @type {AxiosInstance} */
    apis[apiName],
    /** @type {() => void} */
    handleSetAuthorization
  ]
}

export default ApiService
