package com.upca.mynews.models

data class NewsResponse(
    var status: String?,
    var totalResults: Int = 0,
    var articles: List<Article>?
)