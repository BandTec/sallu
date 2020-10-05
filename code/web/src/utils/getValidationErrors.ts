import { ValidationError } from 'yup'

interface IErrors {
  [key: string]: string
}

function getValidationErrors(err: ValidationError): IErrors {
  const validationErrors: IErrors = {}

  err.inner.forEach(error => {
    validationErrors[error.path] = error.message
  })

  return validationErrors
}

export default getValidationErrors
