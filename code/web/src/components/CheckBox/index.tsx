import React, { InputHTMLAttributes, useEffect, useRef } from 'react'
import { useField } from '@unform/core'

import { Container } from './styles'

interface ICheckBoxProps
  extends Omit<InputHTMLAttributes<HTMLInputElement>, 'type' | 'placeholder'> {
  name: string
  label: string
  containerStyle?: React.CSSProperties
}

const CheckBox: React.FC<ICheckBoxProps> = ({
  name,
  label,
  containerStyle = {},
  ...rest
}) => {
  const inputRef = useRef<HTMLInputElement>(null)

  const { fieldName, defaultValue = false, registerField } = useField(name)

  useEffect(() => {
    registerField({
      name: fieldName,
      ref: inputRef.current,
      path: 'checked',
    })
  }, [fieldName, registerField])

  return (
    <Container style={containerStyle}>
      <input
        defaultChecked={defaultValue}
        type="checkbox"
        ref={inputRef}
        {...rest}
      />
      {label}

      <span />
    </Container>
  )
}

export default CheckBox
