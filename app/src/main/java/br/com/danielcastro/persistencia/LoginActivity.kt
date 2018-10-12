package br.com.danielcastro.persistencia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    val sharedPreferences = getSharedPreferences("myapp", Context.MODE_PRIVATE)


    if (sharedPreferences.getBoolean("MANTER_CONECTADO", false)){
        startActivity(Intent(this, ListaActivity::class.java))
        finish()
    }

    btConectar.setOnClickListener {
        val editor = sharedPreferences.edit()
        editor.putBoolean("MANTER_CONECTADO", cbManter.isChecked)
        editor.putString("USUARIO", etUsuario.text.toString())
        editor.apply()
        startActivity(Intent(this, ListaActivity::class.java))
        finish()
    }






    }
}
