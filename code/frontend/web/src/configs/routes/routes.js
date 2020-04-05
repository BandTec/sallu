import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'

import { isAuthenticated } from '../../services/auth'
import ROUTES from './patch'

import LandingPage from '../../pages/LandingPage'
import Dashboard from '../../pages/Dashboard'
import NotFound from '../../pages/NotFound'
import Login from '../../pages/Login'
import SignUp from '../../pages/SignUp'

const PrivateRoute = ({ children, ...rest }) => (
  <Route
    {...rest}
    render={({ location }) =>
      isAuthenticated() ? (children)
        : (
          <Redirect to={{ pathname: '/', state: { from: location } }} />
        )
    }
  />
)

const HeaderRoute = ({ children, ...rest }) => (
  <Route {...rest} >
    <LandingPage>
      {children || <Dashboard />}
    </LandingPage>
  </Route>
)

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path={ROUTES.LOGIN} component={Login} />
      <Route exact path={ROUTES.REGISTER} component={SignUp} />
      <HeaderRoute exact path={ROUTES.BASE} />
      <Route exact path={ROUTES.NOT_FOUND} component={NotFound} />
      <Route exact path="*" component={NotFound} />
    </Switch>
  </BrowserRouter>
)

export default Routes
