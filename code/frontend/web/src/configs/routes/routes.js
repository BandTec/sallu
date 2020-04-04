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
      <Route exact path={'/singIn'} component={SignIn} />
      <Route exact path={ROUTE_PATH.SIGNUP} component={SignUp} />
      <HeaderRoute exact path={ROUTE_PATH.BASE} />
      <Route exact path={ROUTE_PATH.NOT_FOUND} component={NotFound} />
      <Route exact path="*" component={NotFound} />
    </Switch>
  </BrowserRouter>
)

export default Routes
