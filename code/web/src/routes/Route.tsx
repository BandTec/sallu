import React from 'react'
import {
  Route as ReactDOMRoute,
  RouteProps as ReactDOMRouteProps,
  Redirect,
} from 'react-router-dom'

import { useAuth } from '../hooks/auth'

interface ReactProps extends ReactDOMRouteProps {
  isPrivate?: boolean
  component: React.ComponentType
}

// isPrivate + isAuthenticated
// true + true = OK
// true + false = Redirecionar para login
// false + true = Redirecionar para dashboard
// false + false = OK

const Route: React.FC<ReactProps> = ({
  isPrivate = false,
  component: Component,
  ...rest
}) => {
  const { user } = useAuth()

  return (
    <ReactDOMRoute
      {...rest}
      render={() => {
        return isPrivate === !!user ? (
          <Component />
        ) : (
          <Redirect to={{ pathname: isPrivate ? '/' : '/dashboard' }} />
        )
      }}
    />
  )
}

export default Route
