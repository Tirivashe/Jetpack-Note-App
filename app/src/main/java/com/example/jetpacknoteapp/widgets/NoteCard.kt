package com.example.jetpacknoteapp.widgets

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpacknoteapp.model.Note
import com.example.jetpacknoteapp.utils.formatDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClick: (Note)-> Unit
){
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(color = 0xFFDFE6EB),
        elevation = 6.dp
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 14.dp, vertical = 6.dp)
                .clickable { onNoteClick(note) },
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
            Text(
                text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.caption
            )
        }
    }
}