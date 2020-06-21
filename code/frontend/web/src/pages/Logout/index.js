import React, { useEffect } from 'react'
import { useHistory } from 'react-router-dom'

import { useTokenService } from '../../services'

const Logout = () => {
  const { resetToken } = useTokenService()
  const history = useHistory()

  useEffect(() => {
    resetToken()
    history.push('/login')
  }, [])

  return <></>
}

export default Logout
