import React from 'react'
import { IconBaseProps } from 'react-icons'

import { Container } from './styles'

interface ICardProps {
  title: string
  description?: string
  icon?: React.ComponentType<IconBaseProps>
  route: string
}

const Card: React.FC<ICardProps> = ({
  title,
  description = '',
  icon: Icon,
  route,
}) => {
  return (
    <Container to={route}>
      {Icon && <Icon />}
      <strong>{title}</strong>
      {description && <span>{description}</span>}
    </Container>
  )
}

export default Card
