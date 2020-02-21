import React from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';

import { isAuthenticated } from '../../services/auth';

const PrivateRoute = ({ children, ...rest }) => (
  <Route
    {...rest}
    render={({ location }) =>
      isAuthenticated() ? (
        children
      ) : (
        <Redirect to={{
            pathname: '/',
            state: { from: location }
          }}
        />
      )
    }
  />
);

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route exact path="" component={} />
      <Route path="" component={} />
      <PrivateRoute path="" component={} />
      <Route path="*" component={} />
    </Switch>
  </BrowserRouter>
);

export default Routes;