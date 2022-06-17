package com.example.agenda10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda10.component.AlunoAdapter
import com.example.agenda10.component.IOnClick
import com.example.agenda10.model.Aluno

class MainActivity : AppCompatActivity(), IOnClick {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AlunoAdapter

    private var itensClicados = mutableListOf<Int>()
    private var totalClicks: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_alunos = mutableListOf(
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "Jonatas", "12345"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-6.jpg","Maria","67891"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "João","01112"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-6.jpg", "Renata","13141"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "Lara","51617"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "Carlos","18192")
        )

        recyclerView = findViewById(R.id.recycler_view)
        adapter = AlunoAdapter(list_alunos, this)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun onClickAluno(aluno: Aluno) {
        val intent = Intent(this, AlunoDetalhesActivity::class.java)
        intent.putExtra("aluno", aluno)
        startActivity(intent)
    }

    override fun onClickElement(position: Int) {

        Toast.makeText(this, "Item ${position}", Toast.LENGTH_LONG).show() // ${} = interpolação

        if(!itensClicados.contains(position)) {
            itensClicados.add(position)
        }
        Log.d("ITEM", "Clicks: ${++totalClicks}: $itensClicados")
    }

}