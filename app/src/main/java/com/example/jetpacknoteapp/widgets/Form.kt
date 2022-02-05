package com.example.jetpacknoteapp.widgets


import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.jetpacknoteapp.model.Note

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Form(
    onAddNote: (Note) -> Unit,
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NoteInputWidget(
            text = title,
            label = "Title",
            onTextChange = { text ->
                if (text.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }
                )
                    title = text
            },
            modifier = Modifier.padding(vertical = 9.dp)
        )
        NoteInputWidget(
            text = description,
            label = "Add A Note",
            onTextChange = { text ->
                if (text.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }
                )
                    description = text
            },
            modifier = Modifier.padding(vertical = 9.dp)
        )
        NoteButton(
            text = "Save",
            onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddNote(Note(title = title, description = description))
                    title = ""
                    description = ""
                    Toast.makeText(context, "New Note Added", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}