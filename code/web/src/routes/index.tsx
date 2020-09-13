import React from 'react'
import { Switch } from 'react-router-dom'

import Route from './Route'

import SignIn from '../pages/SignIn'
import SignUp from '../pages/SignUp'
import ForgotPassword from '../pages/ForgotPassword'
import ResetPassword from '../pages/ResetPassword'
import Dashboard from '../pages/Dashboard'
import Profile from '../pages/Profile'
import HospitalsNearby from '../pages/HospitalsNearby'
import MedicalRecords from '../pages/MedicalRecords'
import NewMedicalRecord from '../pages/NewMedicalRecord'

const Routes: React.FC = () => (
  <Switch>
    <Route path="/" exact component={SignIn} />
    <Route path="/signup" component={SignUp} />
    <Route path="/forgot-password" component={ForgotPassword} />
    <Route path="/reset-password" component={ResetPassword} />
    <Route path="/dashboard" component={Dashboard} isPrivate />
    <Route path="/profile" component={Profile} isPrivate />
    <Route path="/hospitals-nearby" component={HospitalsNearby} isPrivate />
    <Route path="/medical-records" component={MedicalRecords} isPrivate />
    <Route path="/new-medical-record" component={NewMedicalRecord} isPrivate />
  </Switch>
)

export default Routes
