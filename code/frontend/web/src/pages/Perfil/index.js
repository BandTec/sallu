import React, { useState, useEffect } from 'react';
import { useApiService, useTokenService } from '../../services';
import Header from '../../components/Header';
import Swal from 'sweetalert2';
import './styles.css';
function Profile() {
    const { getToken } = useTokenService();
    const [api] = useApiService();
    const [ficha, setFicha] = useState({});

    var admin = "false";
    const [fetch, setFetch] = useState(false);
    const [password, setPassword] = useState(getToken());
    const [name, setName] = useState('');
    const [email, setEmail] = useState(localStorage.getItem('email'));
    const [birthdayDate, setBirthdayDate] = useState();
    const [telephone, setTelephone] = useState('')
    const idUser = localStorage.getItem('id');

    async function handleRegisterPut(e) {
        e.preventDefault();
        const data = {
            admin,
            name,
            email,
            birthdayDate,
            telephone
        };
        try {
            const response = await api.put('user', data);

            Swal.fire(
                'Boa!!!',
                'Alterações realizadas com sucesso.',
                'success'
            )
            localStorage.setItem('nome', name);
            //history.push('/');
        } catch (error) {
            Swal.fire(
                'Ops...',
                'Erro na alteração de dados, tente novamente',
                'error'
            )

        }
    }

    useEffect(() => {
        api.get(`user/${localStorage.getItem('id')}`, {
            headers: {
                Authorization: `Bearer ${getToken()}`,
            }
        }).then(response => {
            const user = response.data;

            setEmail(user.email);
            setName(user.name);
            setTelephone(user.telephone);
            setBirthdayDate(user.birthdayDate);

            setFetch(true);
        })
    }, []);

    function alterar() {
        document.getElementById("name").disabled = false;
        
        document.getElementById("telephone").disabled = false;
        document.getElementById("data").disabled = false;
    };

    return (
        <div>
            <Header />
            <body>
                {fetch ? (
                    <div className="container" keu={idUser}>
                        <form id="contact" onSubmit={handleRegisterPut}>
                            <center><h3>Configurações</h3></center>
                            <center><h4>Altere seus dados abaixo</h4></center>
                            <fieldset>
                                Nome de usuario:
                                <input placeholder={name} value={name} onChange={e => setName(e.target.value)} type="text" id="name" tabindex="1" disabled autoFocus />
                            </fieldset>

                            <fieldset>
                                E-mail:
                                <input placeholder={email} value={email} onChange={e => setEmail(e.target.value)} id="email" type="text"  disabled />
                            </fieldset>

                            <fieldset>
                                Telefone:
                                <input placeholder={telephone} value={telephone} onChange={e => setTelephone(e.target.value)} id="telephone" type="text"  disabled />
                            </fieldset>

                            <fieldset>
                                Data de nascimento:
                                <input placeholder={birthdayDate} value={birthdayDate} onChange={e => setBirthdayDate(e.target.value)} id="data" type="Date"  disabled />
                            </fieldset>

                            <fieldset>
                                <button  name="Alterar" type="button" id="contact-submit" onClick={alterar} data-submit="...Sending">Alterar</button>
                            </fieldset>

                            <fieldset>
                                <button name="Salvar Alteração" type="submit" id="contact-submit" data-submit="...Sending">Salvar alteração</button>
                            </fieldset>
                        </form>
                    </div>
                ) : null}
            </body>
        </div>
    );
}
export default Profile;