package com.herbeth.calculagastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.btCalcular) {
            calcular()
        }
    }

    private fun calcular() {

        if (validacao()) {
            try {
                val distancia = distancia.text.toString().toFloat()
                val preco = preco.text.toString().toFloat()
                val autonomia = autonomia.text.toString().toFloat()

                val result = (distancia * preco) / autonomia

                resultado.text = "R$ ${"%.2f".format(result)}"
            } catch (e: NumberFormatException){
                Toast.makeText(this, getString(R.string.campos_validos), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.todos_campos), Toast.LENGTH_LONG).show()
        }

    }

    private fun validacao(): Boolean {
        return (distancia.text.toString() != ""
                && preco.text.toString() != ""
                && autonomia.text.toString() != ""
                && autonomia.text.toString() != "0")
    }
}