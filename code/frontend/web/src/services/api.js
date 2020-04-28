import axios from 'axios'

import tokenService from './token'

/**
 * @typedef {import('axios').AxiosInstance} AxiosInstance
 */

const { getToken } = tokenService()

const ApiService = () => ({
  apis: {
    api: axios.create({
      baseURL: 'http://localhost:8080'
    })
  },

  handlers: {

    /**
     * Set Authorization of given API
     * @param {AxiosInstance} api
     * @returns {Void}
     */
    handleSetAuthorization: (api, token) =>
      api.interceptors.request.use(async config => {
        const token = getToken()
        if (token) config.headers.Authorization = `Bearer ${token}`

        return config
      }),

    /**
     * Set Authorization of All APIs
     */
    handleSetAllAuthorization: () => {
      apis.map(api => api.interceptors.request.use(async config => {
        const token = getToken()
        if (token) config.headers.Authorization = `Bearer ${token}`

        return config
      }))
    }
  }
})

/** @type {AxiosInstance[]} */
const apis = ApiService().apis

export default ApiService
