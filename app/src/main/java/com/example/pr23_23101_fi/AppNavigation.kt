package com.example.pr23_23101_fi

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var showSplash by remember { mutableStateOf(true) }

    if (showSplash) {
        // Показываем заставку
        SplashScreen(onSplashComplete = { showSplash = false })
    } else {
        // Основная навигация
        NavHost(navController = navController, startDestination = "onboarding") {

            // 1. Онбординг (Onboard 1, 2, 3)
            composable("onboarding") {
                OnboardingScreen(
                    onSkip = { navController.navigate("login") },
                    onFinish = { navController.navigate("login") }
                )
            }

            // 2. Вход и регистрация
            composable("login") {
                LoginScreen(onNavigateToEmailCode = { navController.navigate("email_code") })
            }

            // 3. Код из Email
            composable("email_code") {
                EmailCodeScreen(onNavigateToCreatePassword = { navController.navigate("create_password") })
            }

            // 4. Создание пароля
            composable("create_password") {
                CreatePasswordScreen(onNavigateToCard = { navController.navigate("create_card") })
            }

            // 5. Карта пациента
            composable("create_card") {
                CreatePatientCardScreen(onNavigateToMain = { navController.navigate("dashboard") })
            }

            // 6. Главный экран
            composable("dashboard") {
                MainDashboardScreen()
            }
        }
    }
}