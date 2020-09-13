import React, {
  useRef,
  useEffect,
  useState,
  useCallback,
  SelectHTMLAttributes,
} from 'react'
import { useField } from '@unform/core'
import { IconBaseProps } from 'react-icons'
import { FiAlertCircle } from 'react-icons/fi'

import { Container, Error } from './styles'

interface ISelectProps extends SelectHTMLAttributes<HTMLSelectElement> {
  name: string
  icon?: React.ComponentType<IconBaseProps>
  options: { label: string; value: string | number }[]
  placeholder: string
}

const Select: React.FC<ISelectProps> = ({
  name,
  icon: Icon,
  options,
  placeholder,
  ...rest
}) => {
  const selectRef = useRef<HTMLSelectElement>(null)
  const [isFocused, setIsFocused] = useState(false)
  const [isFilled, setIsFilled] = useState(false)

  const { fieldName, defaultValue, registerField, error } = useField(name)

  const handleInputFocus = useCallback(() => {
    setIsFocused(true)
  }, [])

  const handleInputBlur = useCallback(() => {
    setIsFocused(false)

    setIsFilled(!!selectRef.current?.value)
  }, [])

  useEffect(() => {
    registerField({
      name: fieldName,
      ref: selectRef.current,
      path: 'value',
    })
  }, [fieldName, registerField])

  return (
    <Container isErrored={!!error} isFilled={isFilled} isFocused={isFocused}>
      {Icon && <Icon size={20} title={placeholder} />}
      <select
        onFocus={handleInputFocus}
        onBlur={handleInputBlur}
        defaultValue={defaultValue ?? ''}
        ref={selectRef}
        {...rest}
      >
        <option disabled value={''}>
          {placeholder}
        </option>
        {options.map((option, index) => {
          return (
            <option key={index} value={option.value}>
              {option.label}
            </option>
          )
        })}
      </select>

      {error && (
        <Error title={error}>
          <FiAlertCircle color="#ff5050" title={error} size={20} />
        </Error>
      )}
    </Container>
  )
}
export default Select
