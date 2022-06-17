package com.example.agenda10.model

import android.os.Parcel
import android.os.Parcelable


class Aluno(var imagemUrl: String?, var nome: String?, var matricula: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imagemUrl)
        parcel.writeString(nome)
        parcel.writeString(matricula)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Aluno> {
        override fun createFromParcel(parcel: Parcel): Aluno {
            return Aluno(parcel)
        }

        override fun newArray(size: Int): Array<Aluno?> {
            return arrayOfNulls(size)
        }
    }
}