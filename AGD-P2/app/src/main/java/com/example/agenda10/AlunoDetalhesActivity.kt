package com.example.agenda10

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda10.model.Aluno
import de.hdodenhof.circleimageview.CircleImageView

class AlunoDetalhesActivity : AppCompatActivity() {

    var aluno: Aluno? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aluno_detalhes)

        aluno = intent.getParcelableExtra("aluno")

        findViewById<CircleImageView>(R.id.aluno_detalhes_imagem)
            .setImageResource(R.drawable.ic_launcher_background)


        findViewById<TextView>(R.id.aluno_detalhes_matricula).text = aluno?.matricula
        findViewById<TextView>(R.id.aluno_detalhes_nome).text = aluno?.nome
    }
}