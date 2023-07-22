package cl.awakelab.ejercicioindividual18modulo5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.awakelab.ejercicioindividual18modulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSharedPreferences = getSharedPreferences("cookie", Context.MODE_PRIVATE)

        binding.buttonGuardar.setOnClickListener {
            val texto = binding.editTextString.text.toString()
            val entero = binding.editTextNumber.text.toString().toInt()
            val decimal = binding.editTextNumberDecimal.text.toString().toFloat()
            val switch = binding.switch1.isChecked

            guardarDatos(texto, entero, decimal,switch)
        }

        binding.buttonMostrar.setOnClickListener {
            mostrarDatos()
        }

        binding.buttonBorrar.setOnClickListener {
            borrarDatos()
        }

        binding.buttonBorrarMemoria.setOnClickListener {
            borrarDeSharedPreferences()
        }

    }

    private fun guardarDatos(texto: String, entero: Int, decimal: Float, switch: Boolean) {
        mSharedPreferences.edit().putString("miTexto", texto).apply()
        mSharedPreferences.edit().putInt("miEntero", entero).apply()
        mSharedPreferences.edit().putFloat("miDecimal", decimal).apply()
        mSharedPreferences.edit().putBoolean("miBoolean", switch).apply()
    }

    private fun mostrarDatos() {
        val texto = mSharedPreferences.getString("miTexto", "")
        val entero = mSharedPreferences.getInt("miEntero", 0)
        val decimal = mSharedPreferences.getFloat("miDecimal", 0.0F)
        val boolean = mSharedPreferences.getBoolean("miBoolean", false)

        binding.textViewValorString.text = texto
        binding.textViewValorNumeroUno.text = entero.toString()
        binding.textViewNumeroDecimal.text = decimal.toString()

        binding.switch1.isChecked = boolean
    }

    private fun borrarDatos() {
        binding.textViewValorString.text = ""
        binding.textViewValorNumeroUno.text = ""
        binding.textViewNumeroDecimal.text = ""

        binding.editTextString.text.clear()
        binding.editTextNumber.text.clear()
        binding.editTextNumberDecimal.text.clear()
        binding.switch1.isChecked = false

    }

    private fun borrarDeSharedPreferences() {
        mSharedPreferences.edit().clear().apply()
    }

}

