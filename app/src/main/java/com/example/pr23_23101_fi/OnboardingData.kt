package com.example.pr23_23101_fi

import androidx.annotation.DrawableRes

data class OnboardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)

val onboardingPages = listOf(
    OnboardingPage(
        image = R.drawable.ic_analyses,
        title = "Анализы",
        description = "Экспресс сбор и получение проб"
    ),
    OnboardingPage(
        image = R.drawable.ic_notifications,
        title = "Уведомления",
        description = "Вы быстро узнаете о результатах"
    ),
    OnboardingPage(
        image = R.drawable.ic_monitoring,
        title = "Мониторинг",
        description = "Наши врачи всегда наблюдают за вашими показателями здоровья"
    )
)