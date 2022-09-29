package utez.edu.adivinarelnumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var intentos = 0
    var numero = (1..101).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtIntentos = findViewById<TextView>(R.id.txtIntentos)
        val txtResuelto = findViewById<TextView>(R.id.txtResuelto)
        val edtValor = findViewById<EditText>(R.id.edtValor)
        val btnAdivinar = findViewById<Button>(R.id.btnAdivinar)
        val btnRendirse = findViewById<Button>(R.id.btnRendirse)
        val btnInicar = findViewById<Button>(R.id.btnIniciar)

        btnInicar.setOnClickListener {
            btnAdivinar.isEnabled = true
            btnRendirse.isEnabled = true
            numero = (1..101).random()
            intentos = 10
            txtResuelto.text = "Adivina el numero"
            txtIntentos.text = intentos.toString()

        }

        btnAdivinar.setOnClickListener {
            val valor = edtValor.text.toString().toInt()

            if (intentos == 0) {
                txtResuelto.text = "Se acabaron los intentos"
                txtIntentos.text = "El numero era: $numero"
                btnAdivinar.isEnabled = false
                btnRendirse.isEnabled = false

            } else if (valor == numero) {
                txtResuelto.text = "Felicidades, adivinaste el numero"

            } else if (valor > numero) {
                txtResuelto.text = "El numero es menor"
                intentos--
                txtIntentos.text = intentos.toString()

            } else if (valor < numero) {
                txtResuelto.text = "El numero es mayor"
                intentos--
                txtIntentos.text = intentos.toString()
            }

        }

        btnRendirse.setOnClickListener {
            txtResuelto.text = "El numero era: $numero"
            btnAdivinar.isEnabled = false
            btnRendirse.isEnabled = false

        }

    }
}