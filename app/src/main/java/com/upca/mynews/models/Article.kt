package com.upca.mynews.models

import java.util.Date

data class Article (
    val title : String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val author: String? = null,
    val likes: Int = 0,
    val publishedAt: Date? = null,
    )