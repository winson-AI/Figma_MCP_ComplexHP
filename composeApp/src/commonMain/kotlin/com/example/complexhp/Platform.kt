package com.example.complexhp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform