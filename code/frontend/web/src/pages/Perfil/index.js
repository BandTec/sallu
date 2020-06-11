import React from 'react';
import Header from '../../components/Header';
import './styles.css';
function Profile() {

    return (
        <div>
            <Header />
            <body>
                <div className="container">
                    <form id="contact">
                        <center><h3>Configurações</h3></center>
                        <center><h4>Altere seus dados abaixo</h4></center>
                        <fieldset>
                            <input placeholder="Alterar seu nome" type="text" tabindex="1" required autofocus />
                        </fieldset>

                        <fieldset>
                            <input placeholder="Alterar e-mail" type="email" tabindex="2" required />
                        </fieldset>

                        <fieldset>
                            <input placeholder="Aterar telefone" type="tel" tabindex="3" required />
                        </fieldset>

                        <fieldset>
                            <input placeholder="Alterar senha" type="text" tabindex="4" required />
                        </fieldset>

                        <fieldset>
                            <input placeholder="Confirmar senha alterada" type="text" tabindex="4" required />
                        </fieldset>

                        <fieldset>
                            <button name="Alterar" type="submit" id="contact-submit" data-submit="...Sending">Alterar</button>
                        </fieldset>

                        <fieldset>
                            <button name="Salvar Alteração" type="submit" id="contact-submit" data-submit="...Sending">Salvar alteração</button>
                        </fieldset>

                    </form>
                </div>
            </body>
        </div>
    );
}

export default Profile;