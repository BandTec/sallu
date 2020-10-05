import React, {
  TextareaHTMLAttributes,
  useEffect,
  useRef,
  useState,
  useCallback,
} from 'react'
import { IconBaseProps } from 'react-icons'
import { FiAlertCircle } from 'react-icons/fi'
import { useField } from '@unform/core'

import { Container, Error } from './styles'

interface IMultilineInputProps
  extends TextareaHTMLAttributes<HTMLTextAreaElement> {
  name: string
  containerStyle?: React.CSSProperties
  icon?: React.ComponentType<IconBaseProps>
  placeholder: string
}

const MultilineInput: React.FC<IMultilineInputProps> = ({
  name,
  icon: Icon,
  containerStyle = {},
  placeholder,
  ...rest
}) => {
  const inputRef = useRef<HTMLTextAreaElement>(null)
  const [isFocused, setIsFocused] = useState(false)
  const [isFilled, setIsFilled] = useState(false)

  const { fieldName, defaultValue, error, registerField } = useField(name)

  const handleMultilineInputFocus = useCallback(() => {
    setIsFocused(true)
  }, [])

  const handleMultilineInputBlur = useCallback(() => {
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
      <textarea
        onFocus={handleMultilineInputFocus}
        onBlur={handleMultilineInputBlur}
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

export default MultilineInput
