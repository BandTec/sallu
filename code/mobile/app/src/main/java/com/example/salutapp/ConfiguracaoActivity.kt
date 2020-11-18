package com.example.salutapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.set
import com.example.salutapp.api.RetrofitConfig
import com.example.salutapp.api.dto.UsuarioDto
import com.example.salutapp.api.model.Usuario
import kotlinx.android.synthetic.main.activity_configuracao.*
import kotlinx.android.synthetic.main.activity_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfiguracaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao)
        var nomeUsuario= intent.extras?.getString("nome")
        tv_usuario.text=nomeUsuario
        dadosUsuario()
    }

    fun dadosUsuario(){
        var idUsuario= intent.extras?.getString("id")
        val api = RetrofitConfig().requestUsuario()
        val callUsuario = api.getUsuarioDados(Integer(idUsuario))

        callUsuario.enqueue(object: Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(applicationContext, "Deu ruim $t", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                val usuario = response.body()

                val genero = usuario?.sex
                et_nome.setText(usuario?.name)
                et_gmail.setText(usuario?.email)
                et_telefone.setText(usuario?.cellphone)
                et_nascimento.setText(usuario?.birthday)
                if (genero.equals("f") || genero.equals("F")){
                    et_genero.setText("Feminino")
                }else{
                    et_genero.setText("Masculino")
                }
            }
        })
    }

    fun alterarDados(v: View){
        if (swAlteracaoFinalizada.isChecked) {
            val api = RetrofitConfig().requestUsuario()
            val usuario= UsuarioDto(
                    et_nome.text.toString(),
                    et_gmail.text.toString(),
                    et_telefone.text.toString(),
                    false,
                    et_nascimento.text.toString(),
                    et_genero.text.toString()
            )
            val callUsuario = api.putUsuarioDados(usuario)

            callUsuario.enqueue(object: Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Deu ruim $t", Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.code() == 200) {
                        Toast.makeText(this@ConfiguracaoActivity,getString(R.string.msg_alterar_sucesso_config), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@ConfiguracaoActivity, getString(R.string.msg_alterar_erro_config), Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}