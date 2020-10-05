import axios from 'axios'

const apiMaps = axios.create({
  baseURL:
    'https://cors-anywhere.herokuapp.com/https://maps.googleapis.com/maps/api/',
  headers: {
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json',
  },
})

export default apiMaps
