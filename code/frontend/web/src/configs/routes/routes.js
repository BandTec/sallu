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
    <Route {...rest}
      render={() =>
        getToken()
          ? (children)
          : <Redirect to={ROUTES.LOGIN} />
      }/>
  )
}

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path={ROUTES.LOGIN} component={Login} />
      <Route exact path={ROUTES.REGISTER} component={Register} />
      <Route exact path={ROUTES.MAPSEARCH} component={MapSearch} />
      <Route exact path={ROUTES.LOGOUT} component={Logout} />
      <PrivateRoute>
        <Route exact path={ROUTES.DASHBOARD} component={Dashboard} />
        <Route exact path={ROUTES.FICHA} component={FichaMedica} />
        <Route exact path={ROUTES.WELCOME} component={Welcome} />
        <Route exact path={ROUTES.FICHA_LISTA} component={ListaFichas} />
        <Route exact path={ROUTES.PROFILE} component={Profile} />
        <Route exact path={ROUTES.MENU} component={Menu} />
      </PrivateRoute>
    </Switch>
  </BrowserRouter>
)

export default Routes
