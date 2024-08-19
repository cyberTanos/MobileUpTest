package com.example.mobileuptest.domain

interface GetCoinsUseCase {
    operator fun invoke(): List<String>
}
