/* eslint-disable camelcase */

import React, { useState, useEffect, useCallback } from 'react'
import { FiArrowLeft, FiActivity } from 'react-icons/fi'
import { Link } from 'react-router-dom'
import { GoogleMap, Marker } from '@react-google-maps/api'

import { useToast } from '../../hooks/toast'
import apiMaps from '../../services/apiMaps'

import { Container, Content, AddressContainer } from './styles'

interface GeolocationGeometryLocation {
  lat: number
  lng: number
}

interface GeolocationResults {
  business_status: string
  geometry: {
    location: GeolocationGeometryLocation
    viewport: {
      northeast: {
        lat: number
        lng: number
      }
      southwest: {
        lat: number
        lng: number
      }
    }
  }
  name: string
  icon: string
  opening_hours?: {
    open_now: boolean
  }
  place_id: string
  plus_code: {
    compound_code: string
    global_code: string
  }
  rating?: number
  reference: string
  scope: string
  types: string[]
  user_ratings_total: number
  vicinity: string
}

interface GoogleGeolocationAPIResponse {
  results: GeolocationResults[]
  status: string
}

const HospitalsNearby: React.FC = () => {
  const { addToast } = useToast()

  const [isBrowserAuthorized, setIsBrowserAuthorized] = useState(false)
  const [currentPosition, setCurrentPosition] = useState({ lat: 0, lng: 0 })
  const [isLoading, setIsLoading] = useState(true)
  const [, setMap] = useState(null)

  const [geolocationResults, setGeolocationResults] = useState<
    GeolocationResults[]
  >([] as GeolocationResults[])

  const [hospitalLocations, setHospitalLocations] = useState<
    GeolocationGeometryLocation[]
  >([])

  const authorizedGeolocation = useCallback<PositionCallback>(
    async ({ coords }) => {
      try {
        const { latitude, longitude } = coords

        setCurrentPosition({ lat: latitude, lng: longitude })

        const { data } = await apiMaps.get<GoogleGeolocationAPIResponse>(
          'place/nearbysearch/json',
          {
            params: {
              location: `${latitude},${longitude}`,
              radius: 1500,
              types: 'hospital',
              key: process.env.REACT_APP_GOOGLE_API_KEY,
            },
          },
        )

        const { results } = data
        console.log(results)

        const locations = results.map(result => {
          return result.geometry.location
        })

        setGeolocationResults([...geolocationResults, ...results])

        setHospitalLocations([...hospitalLocations, ...locations])
      } catch (error) {
        console.error(error.message)
      } finally {
        setIsBrowserAuthorized(true)
        setIsLoading(false)
      }
    },
    [geolocationResults, hospitalLocations],
  )

  const unAuthorizedGeolocation = useCallback<PositionErrorCallback>(() => {
    setIsBrowserAuthorized(false)
    setIsLoading(false)

    addToast({
      title: 'Erro ao carregar mapa',
      description: 'O seu navegador recusou o pedido de autorização',
      type: 'error',
    })
  }, [addToast])

  useEffect(() => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        authorizedGeolocation,
        unAuthorizedGeolocation,
        { enableHighAccuracy: true },
      )
    }

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [])

  const onLoad = useCallback(googleMap => {
    setMap(googleMap)
  }, [])

  const onUmount = useCallback(() => {
    setMap(null)
  }, [])

  return (
    <Container>
      <header>
        <div>
          <Link to="/dashboard">
            <FiArrowLeft />
          </Link>
          <h1>Hospitais Próximos</h1>
        </div>
      </header>

      <Content>
        <div>
          {isLoading ? (
            <></>
          ) : (
            <>
              {isBrowserAuthorized ? (
                <GoogleMap
                  mapContainerStyle={{ width: '100%', height: '100%' }}
                  center={currentPosition}
                  zoom={10}
                  onLoad={onLoad}
                  onUnmount={onUmount}
                >
                  {hospitalLocations.length > 1 &&
                    hospitalLocations.map((location, index) => (
                      <Marker key={index} position={location} />
                    ))}

                  <Marker position={currentPosition} />
                </GoogleMap>
              ) : (
                <h2>O acesso a localização foi negado.</h2>
              )}
            </>
          )}
        </div>
        <aside>
          <h2>Lista de hospitais próximos</h2>
          {geolocationResults.map(({ name, geometry: { location } }, index) => (
            <AddressContainer key={index}>
              <FiActivity />
              <div>
                <strong>{name}</strong>
                <a
                  rel="noopener noreferrer"
                  target="_blank"
                  href={`https://google.com/maps/?q=${location.lat},${location.lng}`}
                >
                  Acessar no Google Maps
                </a>
              </div>
            </AddressContainer>
          ))}
        </aside>
      </Content>
    </Container>
  )
}

export default HospitalsNearby
