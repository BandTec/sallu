import React from 'react';
import HeaderInicial from '../../components/Header/index.js';
import { Link } from 'react-router-dom';
import Triagem from '../../assets/triagem.png';
import Historico from '../../assets/historico.png';
import Config from '../../assets/config.png';
import './styles.css';

function Welcome() {
    const nome = localStorage.getItem('nome');

    return (
        <div>
            <HeaderInicial />
            <div>
               <h1>Bem vindo {nome}</h1>
            </div>

            <div className = "menu" >
                <div className = "botoes">
                    <Link  to='/ficha'>
                        <button type="button">
                            <img src={Triagem} alt="Triagem" />
                              <h2>Triagem Virtual</h2>
                 </button></Link>
                </div>

                <div className = "botoes">
                    <Link to='/pacientes'>
                        <button type="button">
                            <img src={Historico} alt="Historico" />
                              <h2>Histórico</h2>
                 </button></Link>
                </div>

                <div className = "botoes">
                    <Link to=''>
                        <button type="button">
                            <img src={Config} alt="Historico" />
                              <h2>Configurações</h2>
                 </button></Link>
                </div>

            </div>
        </div>
    );
}

export default Welcome;