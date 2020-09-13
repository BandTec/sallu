import React from 'react'
import ReCAPTCHA, { ReCAPTCHAProps } from 'react-google-recaptcha'

import { Container } from './styles'

type GoogleRecaptchaProps = Omit<ReCAPTCHAProps, 'sitekey' | 'hl'>

const GoogleRecaptcha: React.FC<GoogleRecaptchaProps> = ({ ...rest }) => {
  return (
    <Container>
      <ReCAPTCHA
        hl={'pt-BR'}
        sitekey={process.env.REACT_APP_RECAPTCHA_SITEKEY as string}
        {...rest}
      />
    </Container>
  )
}

export default GoogleRecaptcha
