import React, { useState, useEffect } from 'react';
import { useApiService, useTokenService } from '../../services';
import Header from '../../components/Header';
import Swal from 'sweetalert2';
import './styles.css';
function Profile() {
    const { getToken } = useTokenService();
    const [api] = useApiService();
    const [ficha, setFicha] = useState([]);

    var admin ="false";
    const [password, setPassword] = useState(getToken());
    const [name, setName] = useState('');
    const [email, setEmail] = useState(localStorage.getItem('email'));
    const [birthdayDate, setBirthdayDate] = useState();
    const [telephone, setTelephone] = useState('')
    
    async function handleRegisterPut(e){
        e.preventDefault();
        const data = {
            admin,
            password,
            name,
            email,
            telephone
        };
        try{    
        const response = await api.put('user', data);
        
        Swal.fire(
            'Boa!!!',
            'Alterações realizadas com sucesso.',
            'success'
          )
          localStorage.setItem('nome',name);
        //history.push('/');
        }catch(error){
            Swal.fire(
                'Ops...',
                'Erro na alteração de dados, tente novamente',
                'error'
              )
            
        }
    }

    useEffect(() => {
        api.get(`user`, {
            headers: {
                Authorization: `Bearer ${getToken()}`,
            }
        }).then(response => {
            setFicha(response.data);
        })
    }, []);

    function alterar() {
        document.getElementById("name").disabled = false;
        document.getElementById("telephone").disabled = false;
        document.getElementById("senha").disabled = false;
    }

    return (
        <div>
            <Header />
            <body>
                {ficha.map((ficha) => (
                    <div className="container">
                        <form id="contact" onSubmit={handleRegisterPut}>
                            <center><h3>Configurações</h3></center>
                            <center><h4>Altere seus dados abaixo</h4></center>
                            <fieldset>
                                Nome de usuario:
                                <input placeholder={ficha.name} onChange={e=> setName(e.target.value)} type="text" id="name" tabindex="1"  disabled />
                            </fieldset>

                            <fieldset>
                                E-mail:
                                <input placeholder={ficha.email} value={ficha.email} onChange={e=> setEmail(ficha.email)} id="email" type="text" tabindex="2"  disabled />
                            </fieldset>

                            <fieldset>
                                Telefone:
                                <input placeholder={ficha.telephone} onChange={e=> setTelephone(e.target.value)} id="telephone" type="text" tabindex="3" disabled />
                            </fieldset>

                            <fieldset>
                                Data de nascimento:
                                <input placeholder={ficha.birthdayDate}  type="text" tabindex="3" disabled />
                            </fieldset>

                            <fieldset>
                                Senha:
                                <input   id="senha" type="password" tabindex="3" disabled />
                            </fieldset>

                            <fieldset>
                                <button onClick={alterar} name="Alterar" type="button" id="contact-submit" data-submit="...Sending">Alterar informações</button>
                            </fieldset>

                            <fieldset>
                                <button name="Salvar Alteração" type="submit" id="contact-submit" data-submit="...Sending">Salvar alteração</button>
                            </fieldset>
                        </form>
                    </div>
                ))};
            </body>
        </div>
    );
}
export default Profile;