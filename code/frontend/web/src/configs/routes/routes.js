import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'

import { useTokenService } from '../../services'
import ROUTES from './patch'

import Dashboard from '../../pages/Dashboard'
import Login from '../../pages/Login'
import Register from '../../pages/Register'
import FichaMedica from '../../pages/FichaMedica'
import ListaFichas from '../../pages/ListaFichas'
import Welcome from '../../pages/Inicial'
import Profile from '../../pages/Perfil'

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
      
      <PrivateRoute>
        <Route exact path={ROUTES.DASHBOARD} component={Dashboard} />
        <Route exact path={ROUTES.FICHA} component={FichaMedica} />
        <Route exact path={ROUTES.WELCOME} component={Welcome} />
        <Route exact path={ROUTES.FICHA_LISTA} component={ListaFichas} />
        <Route exact path={ROUTES.PROFILE} component={Profile} />
      </PrivateRoute>

      <Redirect to={ROUTES.LOGIN} />

    </Switch>
  </BrowserRouter>
)

export default Routes
