import React, {
  useCallback,
  useState,
  useEffect,
  memo
} from 'react'
import { Marker } from '@react-google-maps/api'
import { CircularProgress } from '@material-ui/core'
import axios from 'axios'

import HeaderInicial from '../../components/Header/index.js'

import {
  AddressContainers,
  ActionContainer,
  Container,
  Subtitle,
  GoogleMaps,
  Title,
  Loading,
  MapContainer,
  LocationContainer,
  LocationIcon,
  LocationLink,
  LocationName,
  LocationData
} from './styles'

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
  const [locationInfo, setLocationInfo] = useState([])
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
  }, [])

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

      const { results } = data

      console.log(results)

      const locations = results.map(item => {
        const location = item.geometry.location

        return location
      })
      setLocationInfo([...locationInfo, ...results])
      setHospitalLocations([...hospitalLocations, ...locations])
      setIsFetched(true)
    } catch (error) {
      console.log(error.message)
    }
  }, [])

  return (
    <>
      <HeaderInicial/>
      <Container>
        {/* <Title>Hospitais Próximos a sua localidade</Title> */}
        <ActionContainer>
          {isFetched ? (
            <MapContainer>
              <GoogleMaps
                mapContainerStyle={{ width: '80%', height: '90%' }}
                center={currentPosition}
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
                />
              </GoogleMaps>
              <AddressContainers>
                {locationInfo.map(({ icon, name, geometry: { location } }, key) => (
                  <LocationContainer key={key}>
                    <LocationIcon src={icon} alt={'Location Icon'} />
                    <LocationData>
                      <LocationName>{name}</LocationName>
                      <LocationLink
                        href={`https://google.com/maps/?q=${location.lat},${location.lng}`}
                      >Acessar no maps</LocationLink>
                    </LocationData>
                  </LocationContainer>
                ))}
              </AddressContainers>
            </MapContainer>
          )
            : isAuthorized ? (
              <Subtitle>
            Acesso negado, por favor, recarregue a página.
              </Subtitle>
            ) : (
              <Loading>
                <Subtitle>
              Carregando mapa... Por favor,
              permita acessarmos sua localização.
                </Subtitle>
                <CircularProgress color={'secondary'} />
              </Loading>
            )
          }
        </ActionContainer>
      </Container>
    </>
  )
}

export default memo(MapSearch)
