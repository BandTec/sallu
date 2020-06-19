import React from 'react'

import styled from 'styled-components'

const NavContainer = styled.nav`
  height: 100%;
  display: flex;
  flex-direction: row;
`

const Navbar = ({ children }) => {
  return (
    <NavContainer>
      {children}
    </NavContainer>
  )
}

export default Navbar
