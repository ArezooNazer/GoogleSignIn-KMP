package com.example.googlesingin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform