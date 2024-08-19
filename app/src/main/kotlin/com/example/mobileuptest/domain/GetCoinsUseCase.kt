package com.example.mobileuptest.domain

import com.example.mobileuptest.domain.model.Coin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCoinsUseCaseImpl(
    private val repository: Repository
) : GetCoinsUseCase {

    override suspend fun invoke(currency: String): List<Coin> {
        return withContext(Dispatchers.IO) {
            repository.getCoins(currency)
        }
    }
}

interface GetCoinsUseCase {
    suspend operator fun invoke(currency: String): List<Coin>
}
