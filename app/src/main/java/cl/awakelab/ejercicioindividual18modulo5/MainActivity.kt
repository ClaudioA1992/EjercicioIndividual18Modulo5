package cl.awakelab.ejercicioindividual18modulo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.awakelab.ejercicioindividual18modulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}