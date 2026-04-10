package com.example.pr23_23101_fi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CreatePasswordScreen(
    onNavigateToCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    var pin by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
            Text(
                "Пропустить",
                color = Color(0xFF0560FA),
                modifier = Modifier.align(Alignment.CenterEnd).clickable { onNavigateToCard() }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("Создайте пароль", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Для защиты ваших персональных данных", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(40.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = if (index < pin.length) Color(0xFF0560FA) else Color(0xFFE0E0E0),
                            shape = CircleShape
                        )
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "⌫")
        keys.chunked(3).forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                row.forEach { key ->
                    if (key.isEmpty()) {
                        Spacer(modifier = Modifier.size(80.dp))
                    } else {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(Color(0xFFF5F5F5), shape = CircleShape)
                                .clickable {
                                    if (key == "⌫") {
                                        if (pin.isNotEmpty()) pin = pin.dropLast(1)
                                    } else if (pin.length < 4) {
                                        pin += key
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(key, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
    }

    LaunchedEffect(pin) {
        if (pin.length == 4) {
            delay(400)
            onNavigateToCard()
        }
    }
}