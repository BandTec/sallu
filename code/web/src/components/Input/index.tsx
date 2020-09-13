import React, {
  InputHTMLAttributes,
  useEffect,
  useRef,
  useState,
  useCallback,
} from 'react'
import { IconBaseProps } from 'react-icons'
import { FiAlertCircle } from 'react-icons/fi'
import { useField } from '@unform/core'

import { Container, Error } from './styles'

interface IInputProps extends InputHTMLAttributes<HTMLInputElement> {
  name: string
  containerStyle?: React.CSSProperties
  icon?: React.ComponentType<IconBaseProps>
  placeholder: string
}

const Input: React.FC<IInputProps> = ({
  name,
  icon: Icon,
  containerStyle = {},
  placeholder,
  ...rest
}) => {
  const inputRef = useRef<HTMLInputElement>(null)
  const [isFocused, setIsFocused] = useState(false)
  const [isFilled, setIsFilled] = useState(false)

  const { fieldName, defaultValue, error, registerField } = useField(name)

  const handleInputFocus = useCallback(() => {
    setIsFocused(true)
  }, [])

  const handleInputBlur = useCallback(() => {
    setIsFocused(false)

    setIsFilled(!!inputRef.current?.value)
  }, [])

  useEffect(() => {
    registerField({
      name: fieldName,
      ref: inputRef.current,
      path: 'value',
    })
  }, [fieldName, registerField])

  return (
    <Container
      style={containerStyle}
      isErrored={!!error}
      isFilled={isFilled}
      isFocused={isFocused}
    >
      {Icon && <Icon size={20} title={placeholder} />}
      <input
        onFocus={handleInputFocus}
        onBlur={handleInputBlur}
        defaultValue={defaultValue}
        placeholder={placeholder}
        ref={inputRef}
        {...rest}
      />

      {error && (
        <Error title={error}>
          <FiAlertCircle color="#ff5050" title={error} size={20} />
        </Error>
      )}
    </Container>
  )
}

export default Input
