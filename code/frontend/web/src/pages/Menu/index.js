import React from 'react';
import { Link } from 'react-router-dom'; 

import { Container, Form } from './styles';
import GlobalStyle from './global';

import logo from '../../assets/logo_salut_normal.svg';


function Menu() {
  return(
    <div>
      <GlobalStyle/>
        <div className={'logo'}>
            <img src={logo} alt="" width={'100'}/>
        </div>
      <Container>
        <Form>
        <Link to="/profile">
        <button className={'btn-circle'} >
            <img src="https://image.flaticon.com/icons/svg/2922/2922506.svg" alt=""/>
        </button>
        </Link>

        <Link to="/ficha">
          <button className={'btn-circle-2'} >
              <img src="https://image.flaticon.com/icons/svg/3056/3056833.svg" alt=""/>
          </button>
        </Link>

        <Link to="/pacientes">
          <button className={'btn-circle-1'} >
              <img src="https://image.flaticon.com/icons/svg/2865/2865164.svg" alt=""/>
          </button>
        </Link>

        <Link to="/login">
          <button className={'btn-circle-3'} >
              <img src="https://image.flaticon.com/icons/svg/594/594732.svg" alt=""/>
          </button>
        </Link>
        </Form>
      </Container>  
    </div>
  )
}

export default Menu;