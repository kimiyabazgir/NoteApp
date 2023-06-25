package com.example.noteApp.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteApp.NOTE_TABLE

@Entity(tableName = NOTE_TABLE )
data class NoteModel(
@PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title: String="",
    var doneStatus:Boolean=false
)
