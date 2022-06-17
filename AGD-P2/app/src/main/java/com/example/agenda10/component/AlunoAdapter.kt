package com.example.agenda10.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda10.MainActivity
import com.example.agenda10.R
import com.example.agenda10.model.Aluno
import com.squareup.picasso.Picasso

class AlunoAdapter(
    var list_alunos: List<Aluno>,
    val alunoView: MainActivity
): RecyclerView.Adapter<AlunoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_aluno, parent, false)

        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        Picasso.get()
            .load(list_alunos[position].imagemUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imagem)

        holder.nome.text = list_alunos[position].nome
        holder.matricula.text = list_alunos[position].matricula

        holder.card.setOnClickListener {
            (alunoView as IOnClick).onClickAluno(list_alunos[position])
        holder.card.setOnClickListener {
             (alunoView as IOnClick).onClickElement(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list_alunos.size
    }
}