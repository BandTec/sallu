import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'

import { isAuthenticated } from '../../services/auth'
import ROUTE_PATH from './patch'

import LandingPage from '../../pages/LandingPage'
import Dashboard from '../../pages/Dashboard'
import NotFound from '../../pages/NotFound'
import SignIn from '../../pages/SignIn'
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

const Private = () => (
  <LandingPage>
    <BrowserRouter>
      <Switch>
        <PrivateRoute exact path={ROUTE_PATH.DASHBOARD} component={Dashboard} />
        <Redirect to={ROUTE_PATH.NOT_FOUND} />
      </Switch>
    </BrowserRouter>
  </LandingPage>
)

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path={ROUTE_PATH.SIGNIN} component={SignIn} />
      <Route exact path={ROUTE_PATH.SIGNUP} component={SignUp} />
      <Route path={ROUTE_PATH.BASE} component={Private} />
      <Route exact path={ROUTE_PATH.NOT_FOUND} component={NotFound} />
      <Route exact path="*" component={NotFound} />
    </Switch>
  </BrowserRouter>
)

export default Routes
