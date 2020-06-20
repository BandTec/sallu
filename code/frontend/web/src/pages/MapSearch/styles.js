import styled from 'styled-components'

import { GoogleMap } from '@react-google-maps/api'

export const AddressContainers = styled.div`
  width: 50%;
  max-height: 80vh;

  display: flex;
  flex-direction: column;
  justify-content: center;

  overflow: auto;
`

export const GoogleMaps = styled(GoogleMap)`
  width: 100%;
  height: 80vh;
`

export const ActionContainer = styled.div`
  width: 100%;

  display: flex;
  justify-content: center;
`

export const Container = styled.div`
  width: 100%;
  height: 100%;

  display: flex;
  flex-direction: column;
  
  align-items: center;
  justify-content: center;
`

export const Loading = styled.div`
  display: flex;
  flex-direction: column;
  
  align-items: center;
  justify-content: center;
`

export const MapContainer = styled.div`
  margin: 15px;
  width: 100%;

  display: flex;
  align-items: center;
  justify-content: space-around;
`

export const Title = styled.h1``

export const Subtitle = styled.h2``

export const LocationContainer = styled.div`
  display: flex;

  align-items: center;

  border-radius: 12px;

  margin-left: 15px;
  padding: 10px;
  box-shadow: 4px 4px 4px 1px rgba(0, 0, 0, 0.2);
`

export const LocationIcon = styled.img`
  margin-right: 20px;
`

export const LocationData = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
`

export const LocationName = styled.div`
  font-size: 18px;
`

export const LocationLink = styled.a`
  font-size: 16px;
  font-weight: bold;
`
