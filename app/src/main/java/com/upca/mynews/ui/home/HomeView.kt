package com.upca.mynews.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.upca.mynews.models.Article
import com.upca.mynews.ui.components.ArticleRowView


@Composable
fun HomeView(modifier: Modifier = Modifier, articles: List<Article>){
    LazyColumn(modifier = modifier) {
            items(articles){ article -> ArticleRowView(article = article) }
    }
}

@Preview(showBackground = true)
@Composable fun HomeViewPreview(){
    val exampleArticlesList = listOf(
        Article(
            title = "Notific asidaos ai dsaids ao iajsda",
            description = "descricao descricao descricao descricao descricao descricao",
            author = "Oi oi bilau",
            likes = 32,
        ),
        Article(
            title = "PAOSDAOSD OA SDOA SKDOK DAO teste",
            description = "descricao descricao descricao descricao descricao descricao",
            author = "POPO",
            likes = 2,
        ),
        Article(
            title = "OIASJDIASIDA ASDASDASS",
            description = "descricao descricao descricao descricao descricao descricao",
            author = "DDD DDD",
            likes = 12,
        ))
    HomeView(modifier = Modifier, exampleArticlesList )
}