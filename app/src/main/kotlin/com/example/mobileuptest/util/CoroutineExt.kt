package com.example.mobileuptest.util

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

val ComponentContext.componentScope: CoroutineScope
    get() {
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

        lifecycle.doOnDestroy {
            scope.cancel()
        }

        return scope
    }
