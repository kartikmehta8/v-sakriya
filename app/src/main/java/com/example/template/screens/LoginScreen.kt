package com.example.template.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {
    var userName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 25.dp)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Welcome to App",
            style = MaterialTheme.typography.titleLarge
        )

        Column() {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = userName,
                onValueChange = {
                    userName = it
                },
                label = {
                    Text(
                        text = "Enter Police ID",
                        style = TextStyle(color = MaterialTheme.colorScheme.onSurface)
                    )
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = MaterialTheme.colorScheme
                        .surfaceVariant, textColor = MaterialTheme.colorScheme.onSurface
                ),
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(text = "Login")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login()
}