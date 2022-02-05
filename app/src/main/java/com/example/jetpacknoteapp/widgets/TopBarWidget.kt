package com.example.jetpacknoteapp.widgets

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.jetpacknoteapp.R

@Composable
fun TopBarWidget() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = null)
        },
        backgroundColor = Color(0xFFDADFE3)
    )
}