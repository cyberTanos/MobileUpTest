package com.example.mobileuptest.data

import com.example.mobileuptest.domain.Repository
import com.example.mobileuptest.domain.mapper.toDomain
import com.example.mobileuptest.domain.model.Coin

class RepositoryImpl(
    private val remote: RemoteCoinsDataSource
) : Repository {

    override suspend fun getCoins(currency: String): List<Coin> {
        return remote.getCoins(currency).toDomain()
    }
}
