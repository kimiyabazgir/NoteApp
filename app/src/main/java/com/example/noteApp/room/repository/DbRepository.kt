package com.example.noteApp.room.repository

import com.example.noteApp.room.db.NoteDao
import com.example.noteApp.room.db.NoteModel
import javax.inject.Inject

class DbRepository @Inject constructor(private val dao: NoteDao) {
    fun saveNote(entity:NoteModel)=dao.saveNote(entity)
    fun getAllNotes()=dao.getAllNote()
    fun deleteNotes(id : Int) = dao.deleteNote(id)
    fun updatedoneStatus(doneStatus:Boolean,id : Int,)=dao.updateDone(doneStatus,id)

}