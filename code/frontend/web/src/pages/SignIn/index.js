import React, { Component } from 'react'

import { Link } from 'react-router-dom'

import { Container, Form} from './components';

import Medicine from '../../assets/medicine.png';

import Sallut from '../../assets/sallut.svg';

class SingIn extends Component {

  state = {
    email: "",
    password: "",
    error: ""
  };

  handleSigIn = e => {
    e.preventDefault();
    alert("Você está na Aplicação")
  }

  render() {
    return (
          <Container>
            <Form onSubmit={this.handleSignIn}>
              <img src={Sallut} />
              {this.state.error && <p>{this.state.error}</p>}
              <input
                id='email'
                type='text'
                placeholder='Email'
                onChange={e => this.setState({ email: e.target.value })}
              />

              <input
                id='senha'
                type='password'
                placeholder='Senha'
                onChange={e => this.setState({ password: e.target.valu })}
              />

              <button type='submit'>Entrar</button>
              <hr />

              <Link to='/signUp'>Cadastrar</Link>
            </Form>
          </Container>
    );
  }
}

export default SingIn
