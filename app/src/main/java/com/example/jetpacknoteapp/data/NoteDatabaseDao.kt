package com.example.jetpacknoteapp.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.example.jetpacknoteapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query(value = "SELECT * FROM notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query(value = "SELECT * FROM notes_tbl WHERE id=:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query(value = "DELETE FROM notes_tbl")
    suspend fun deleteAll()
}
