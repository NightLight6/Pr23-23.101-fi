package com.example.pr23_23101_fi

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onNavigateToEmailCode: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    val isFormValid = email.contains("@") && email.contains(".")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text("👋", fontSize = 40.sp)
        Text(
            "Добро пожаловать!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF141414)
        )
        Text(
            "Войдите, чтобы пользоваться функциями приложения",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text("Вход по E-mail", color = Color.Gray, fontSize = 14.sp)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("example@mail.ru", color = Color.LightGray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0560FA),
                unfocusedBorderColor = Color(0xFFE0E0E0)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNavigateToEmailCode,
            enabled = isFormValid,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFormValid) Color(0xFF0560FA) else Color(0xFFE0E0E0)
            )
        ) {
            Text("Далее", color = if (isFormValid) Color.White else Color.Gray)
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = { /* Логика Яндекс */ },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White
            )
        ) {
            Text("Войти с Яндекс", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}