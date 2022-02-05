package com.example.jetpacknoteapp.screen

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacknoteapp.data.NoteDataSource
import com.example.jetpacknoteapp.model.Note
import com.example.jetpacknoteapp.widgets.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note)-> Unit,
    onRemoveNote: (Note)-> Unit
){

    Column(modifier = Modifier.padding(6.dp)) {
        TopBarWidget()
        Form(onAddNote)
        Divider(modifier = Modifier.padding(10.dp))
        NoteCardList(notes, onRemoveNote)
    }
}