import React from 'react'
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'

import { useTokenService } from '../../services'
import ROUTES from './patch'

import LandingPage from '../../pages/LandingPage'
import Dashboard from '../../pages/Dashboard'
import NotFound from '../../pages/NotFound'
import Login from '../../pages/Login'
import Register from '../../pages/Register'

const { getToken } = useTokenService()

const PrivateRoute = ({ children, ...rest }) => (
  <Route
    {...rest}
    render={({ location }) =>
      getToken() ? (children)
        : (
          <Redirect to={{ pathname: ROUTES.BASE, state: { from: location } }} />
        )
    }
  />
)

const HeaderRoute = ({ children, ...rest }) => (
  <Route {...rest} >
    <LandingPage>
      <BrowserRouter>
        {children ||
          ''
        }
      </BrowserRouter>
    </LandingPage>
  </Route>
)

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path={ROUTES.LOGIN} component={Login} />
      <Route exact path={ROUTES.REGISTER} component={Register} />
      <HeaderRoute exact path={ROUTES.BASE} />
      <PrivateRoute
        exact
        path={ROUTES.DASHBOARD}
      >
        <Dashboard />
      </PrivateRoute>
      <Route exact path="*" component={NotFound} />
    </Switch>
  </BrowserRouter>
)

export default Routes
