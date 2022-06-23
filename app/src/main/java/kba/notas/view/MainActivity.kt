package kba.notas.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kba.notas.R
import kba.notas.databinding.ActivityMainBinding
import kba.notas.domain.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            calculate()
        }
    }

    private fun calculate() {

        generateTotal()
    }

    private fun cleanFields() {

        textDuzentosReais.text = "0"
        textCemReais.text = "0"
        textCinquentaReais.text = "0"
        textVinteReais.text = "0"
        textDezReais.text = "0"
        textCincoReais.text = "0"
        textDoisReais.text = "0"
        textUmReal.text = "0"
    }

    private fun generateTotal() {

        cleanFields()

        if (editValor.text.toString() == "") {

            binding.textResp.visibility = View.VISIBLE
            binding.textResp.text = this.getString(R.string.error_number)

        } else {

            binding.textResp.visibility = View.GONE

            val note = Note(editValor.text.toString().toInt())
            val valueNote = note.value
            var rest = 0

            var note200 = Math.floor((valueNote / 200).toDouble())
            rest = valueNote % 200

            var note100 = Math.floor((rest / 100).toDouble())
            rest %= 100

            var note50 = Math.floor((rest / 50).toDouble())
            rest %= 50

            var note20 = Math.floor((rest / 20).toDouble())
            rest %= 20

            var note10 = Math.floor((rest / 10).toDouble())
            rest %= 10

            var note5 = Math.floor((rest / 5).toDouble())
            rest %= 5

            var note2 = Math.floor((rest / 2).toDouble())
            rest %= 2

            var note1 = Math.floor((rest / 1).toDouble())
            rest %= 1

            printNotes(note200, note100, note50, note20, note10, note5, note2, note1)
        }
    }

    private fun printNotes( note200: Double,note100: Double,note50: Double,note20: Double,
                            note10: Double,note5: Double,note2: Double,note1: Double
    ) {
        binding.textDuzentosReais.text = Math.round(note200).toString()
        binding.textCemReais.text = Math.round(note100).toString()
        binding.textCinquentaReais.text = Math.round(note50).toString()
        binding.textVinteReais.text = Math.round(note20).toString()
        binding.textDezReais.text = Math.round(note10).toString()
        binding.textCincoReais.text = Math.round(note5).toString()
        binding.textDoisReais.text = Math.round(note2).toString()
        binding.textUmReal.text = Math.round(note1).toString()
    }
}