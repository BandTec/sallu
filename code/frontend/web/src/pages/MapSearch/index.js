import React, {
  useCallback,
  useState,
  useEffect,
  memo
} from 'react'
import { GoogleMap, Marker } from '@react-google-maps/api'
import { CircularProgress } from '@material-ui/core'
import axios from 'axios'

import { Container, Subtitle, Title } from './styles'

const MapSearch = () => {
  const mapsAPI = axios.create({
    baseURL: 'https://cors-anywhere.herokuapp.com/https://maps.googleapis.com/maps/api/',
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json'
    }
  })
  // const google = window.google ? window.google : {}

  const [isAuthorized, setIsAuthorized] = useState(false)
  const [isFetched, setIsFetched] = useState(false)
  const [currentPosition, setCurrentPosition] = useState({ lat: 0, lng: 0 })
  const [hospitalLocations, setHospitalLocations] = useState([])
  const [map, setMap] = useState(null)

  useEffect(() => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        onAuthorizeGeolocation,
        onUnauthorizeGeolocation,
        { enableHighAccuracy: true }
      )
    }
  }, [])

  const onLoad = useCallback(map => {
    setMap(map)
  }, [])

  const onUmount = useCallback(() => {
    setMap(null)
  }, [])

  const onUnauthorizeGeolocation = useCallback(() => {
    setIsAuthorized(true)
  })

  const onAuthorizeGeolocation = useCallback(async ({ coords }) => {
    const { latitude, longitude } = coords
    console.log(coords)

    try {
      setCurrentPosition({ lat: latitude, lng: longitude })
      const { data } = await mapsAPI.get('place/nearbysearch/json', {
        params: {
          location: `${latitude},${longitude}`,
          radius: 1500,
          types: 'hospital',
          key: process.env.REACT_APP_GOOGLE_API_KEY
        }
      })

      const locations = data.results.map(item => {
        const location = item.geometry.location

        return location
      })

      setIsFetched(true)
      setHospitalLocations([...hospitalLocations, ...locations])
    } catch (error) {
      console.log(error.message)
    }
  })

  return (
    <Container>
      <Title>Hospitais Próximos a sua localidade</Title>
      {isFetched ? (
        <GoogleMap
          mapContainerStyle={{ width: '80%', height: '620px' }}
          center={currentPosition}
          // center={{ lat: 37.774546, lng: -122.433523 }}
          zoom={10}
          onLoad={onLoad}
          onUnmount={onUmount}
        >
          {/* <></> */}
          {hospitalLocations.length > 1 && hospitalLocations.map((loc, i) => (
            <Marker
              key={i}
              position={loc}
            />
          ))}
          <Marker
            position={currentPosition}
            onClick={() => console.log('Voce clicou em mim')}
          />
        </GoogleMap>
      )
        : isAuthorized ? (
          <Subtitle>
            Acesso negado, por favor, recarregue a página.
          </Subtitle>
        ) : (
          <>
            <Subtitle>
              Carregando mapa... Por favor,
              permita acessarmos sua localização.
            </Subtitle>
            <CircularProgress color={'secondary'} />
          </>
        )
      }
    </Container>
  )
}

export default memo(MapSearch)
