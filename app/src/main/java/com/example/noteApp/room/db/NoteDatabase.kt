package com.example.noteApp.room.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [NoteModel::class], version = 5, exportSchema = false)
abstract class NoteDatabase :RoomDatabase(){
    abstract fun noteDao():NoteDao
}