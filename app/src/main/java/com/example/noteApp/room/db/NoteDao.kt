package com.example.noteApp.room.db

import androidx.room.*
import com.example.noteApp.NOTE_TABLE

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(note: NoteModel)

    @Query("Select * From $NOTE_TABLE ORDER BY id ASC")
    fun getAllNote(): MutableList<NoteModel>


    @Query("DELETE FROM $NOTE_TABLE WHERE id = :id")
    fun deleteNote(id: Int)

    @Query("UPDATE $NOTE_TABLE SET `doneStatus` = :doneStatus  WHERE id = :id")
    fun updateDone(doneStatus: Boolean,id:Int)


}