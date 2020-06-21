import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'

import { useTokenService } from '../../services'
import ROUTES from './patch'

import Dashboard from '../../pages/Dashboard'
import Login from '../../pages/Login'
import Register from '../../pages/Register'
import FichaMedica from '../../pages/FichaMedica'
import ListaFichas from '../../pages/ListaFichas'
import Logout from '../../pages/Logout'
import Welcome from '../../pages/Inicial'
import Profile from '../../pages/Perfil'
import MapSearch from '../../pages/MapSearch'
import Menu from '../../pages/Menu'

const PrivateRoute = ({ children, ...rest }) => {
  const { getToken } = useTokenService()

  return (
    <>
      {getToken()
        ? <Route {...rest} />
        : <Redirect to={ROUTES.LOGIN} />
      }
    </>
  )
}

const CommonRoute = ({ children, ...rest }) => {
  const { getToken } = useTokenService()

  return (
    <>
      {getToken()
        ? <Redirect to={ROUTES.WELCOME} />
        : <Route {...rest} />
      }
    </>
  )
}

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <PrivateRoute exact path={ROUTES.WELCOME} component={Welcome} />
      <PrivateRoute exact path={ROUTES.MENU} component={Menu} />
      <PrivateRoute exact path={ROUTES.PROFILE} component={Profile} />
      <PrivateRoute exact path={ROUTES.FICHA} component={FichaMedica} />
      <PrivateRoute exact path={ROUTES.DASHBOARD} component={Dashboard} />
      <PrivateRoute exact path={ROUTES.MAPSEARCH} component={MapSearch} />
      <PrivateRoute exact path={ROUTES.FICHA_LISTA} component={ListaFichas} />
      <Route exact path={ROUTES.LOGOUT} component={Logout} />
      <CommonRoute exact path={ROUTES.LOGIN} component={Login} />
      <CommonRoute exact path={ROUTES.REGISTER} component={Register} />
      <Redirect path={ROUTES.BASE} to={ROUTES.LOGIN} />
    </Switch>
  </BrowserRouter>
)

export default Routes
