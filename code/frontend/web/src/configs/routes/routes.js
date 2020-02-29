import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'

import { isAuthenticated } from '../../services/auth'
import ROUTE_PATH from './patch'

import Home from '../../pages/Home'
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

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path={ROUTE_PATH.HOME} component={Home} />
      <Route exact path={ROUTE_PATH.SIGNIN} component={SignIn} />
      <Route path={ROUTE_PATH.SIGNUP} component={SignUp} />
      <PrivateRoute path={ROUTE_PATH.DASHBOARD} component={Dashboard} />
      <Route path="*" component={NotFound} />
      <Redirect to={ROUTE_PATH.SIGNIN} />
    </Switch>
  </BrowserRouter>
)

export default Routes
