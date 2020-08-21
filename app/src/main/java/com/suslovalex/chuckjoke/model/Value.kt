package com.suslovalex.chuckjoke.model


data class Value(
    val id: Int,
    val joke: String,
    val categories: List<Any>
)