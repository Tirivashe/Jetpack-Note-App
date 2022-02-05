package com.example.jetpacknoteapp.widgets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.jetpacknoteapp.model.Note

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteCardList(
    notes: List<Note>,
    onRemoveNote: (Note) -> Unit
) {
    LazyColumn {
        items(notes) { note ->
            NoteCard(note = note, onNoteClick = { currentNote -> onRemoveNote(currentNote) })
        }
    }
}