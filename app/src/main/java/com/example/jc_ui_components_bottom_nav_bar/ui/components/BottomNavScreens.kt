package com.example.jc_ui_components_bottom_nav_bar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var showBasicDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Home", color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.width(150.dp),
            onClick = {
                showDialog = true
            },
            shape = RoundedCornerShape(20.dp),
            elevation = ButtonDefaults.buttonElevation(10.dp),
            contentPadding = PaddingValues(4.dp)
        ) {
            Text(text = "Show Alert 1")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.width(150.dp),
            onClick = {
                showBasicDialog = true
            },
            shape = RoundedCornerShape(20.dp),
            elevation = ButtonDefaults.buttonElevation(10.dp),
            contentPadding = PaddingValues(4.dp)
        ) {
            Text(text = "Show Alert 2")
        }

        if (showDialog) {
            AlertDialogComponent {
                showDialog = false
            }
        }

        if (showBasicDialog) {
            BasicAlertDialogComponent {
                showBasicDialog = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicAlertDialogComponent(onDismiss: () -> Unit) {
    BasicAlertDialog(
        onDismissRequest = { onDismiss() },
        modifier = Modifier.padding(16.dp),
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Surface(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            shape = MaterialTheme.shapes.large,
            tonalElevation = 16.dp,
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text =
                    "This area typically contains the supportive text which presents the details regarding the Dialog's purpose.")
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(
                    onClick = { onDismiss() },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Confirm")
                }
            }
        }
    }
}

@Composable
fun AlertDialogComponent(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { (onDismiss()) }) {
                Text("Dismiss")
            }
        },
        title = {
            Text("AlertDialog Title")
        },
        text = {
            Text("This is the content of the alert dialog")
        },
        modifier = Modifier.padding(16.dp),
        icon = {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Info Icon",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
        },
        // define box shape
        shape = RoundedCornerShape(12.dp),
        // set box background color
        containerColor = Color.White,
        // set icon color
        iconContentColor = Color.Red,
        // set title text color
        titleContentColor = Color.Black,
        // set text color
        textContentColor = Color.DarkGray,
        // set elevation
        tonalElevation = 8.dp,
        // set properties
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
    )
}

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Search", color = Color.Black)
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile", color = Color.Black)
    }
}