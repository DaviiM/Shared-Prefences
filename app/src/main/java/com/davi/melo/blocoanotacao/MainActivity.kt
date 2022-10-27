package com.davi.melo.blocoanotacao

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.davi.melo.blocoanotacao.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var preferencias: AnotacaoPreferencia? = null
    private var editAnotacao: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editAnotacao = findViewById<EditText>(R.id.blocoAnotacao)
        var preferencias = AnotacaoPreferencia(applicationContext)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val textoRecuperado = editAnotacao.getText().toString()
            if (textoRecuperado == ""){
                Snackbar.make(it, "Digite uma anotação para ser salva", Snackbar.LENGTH_INDEFINITE).show()
            } else {
                preferencias!!.salvarAnotacao(textoRecuperado)
                Snackbar.make(it, "Anotação salva com sucesso", Snackbar.LENGTH_INDEFINITE).show()
            }
        }

        val anotacao = preferencias!!.recuperarAnotacao()
        if (anotacao!= ""){
            editAnotacao.setText(anotacao)
        }
    }

}