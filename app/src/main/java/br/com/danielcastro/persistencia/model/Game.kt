package br.com.danielcastro.persistencia.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Game")
data class Game(
        @PrimaryKey(autoGenerate = true) var id: Int?,
        var nome: String,
        var genero: String
)