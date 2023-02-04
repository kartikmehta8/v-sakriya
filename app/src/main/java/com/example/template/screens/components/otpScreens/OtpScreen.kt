package com.example.template.screens.components.otpScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterCodeUI(
    code: String,
    onCodeChange: (String) -> Unit,
    phone: String,
    onGo: (KeyboardActionScope.() -> Unit)?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                vertical = 56.dp,
                horizontal = 20.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = phone,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Waiting to automatically detect an SMS sent to $phone"
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = code, onValueChange = onCodeChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(onGo = onGo),
            singleLine = true,
            label = { Text(text = "Enter OTP") },
            leadingIcon = {
                Icon(Icons.Default.ArrowBack, contentDescription = "")
            },
            modifier = Modifier.fillMaxWidth(0.45f)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Enter 6 Digit OTP")
    }

}