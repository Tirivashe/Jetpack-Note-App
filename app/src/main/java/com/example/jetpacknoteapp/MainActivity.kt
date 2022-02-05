package com.example.jetpacknoteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacknoteapp.data.NoteDataSource
import com.example.jetpacknoteapp.model.Note
import com.example.jetpacknoteapp.screen.NoteScreen
import com.example.jetpacknoteapp.screen.NoteViewModel
import com.example.jetpacknoteapp.ui.theme.JetpackNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackNoteAppTheme {
                MyApp {
                    val noteViewModel = viewModel<NoteViewModel>()
                    NoteApp(noteViewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteApp(noteViewModel: NoteViewModel){
    val noteList = noteViewModel.noteList.collectAsState().value

    NoteScreen(
        notes = noteList,
        onAddNote = { note ->
            noteViewModel.addNote(note)
        },
        onRemoveNote = { note ->
            noteViewModel.removeNote(note)
        }
    )
}

@Composable
fun MyApp(content: @Composable ()-> Unit){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        content()
    }
}