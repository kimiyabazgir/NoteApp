package com.example.noteApp.room.di

import android.content.Context
import androidx.room.Room
import com.example.noteApp.NOTE_DATABASE
import com.example.noteApp.room.db.NoteDatabase
import com.example.noteApp.room.db.NoteModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,NoteDatabase::class.java, NOTE_DATABASE).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db:NoteDatabase)=db.noteDao()

    @Provides
    fun provideEntity()=NoteModel()
}