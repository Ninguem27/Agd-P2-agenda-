package com.example.agenda10.component

import com.example.agenda10.model.Aluno

interface IOnClick {

    fun onClickAluno(aluno: Aluno)

    fun onClickElement(position: Int)
}