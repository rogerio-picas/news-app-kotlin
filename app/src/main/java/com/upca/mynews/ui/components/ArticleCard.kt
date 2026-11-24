package com.upca.mynews.ui.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upca.mynews.models.Article
import coil.compose.AsyncImage


@Composable fun ArticleRowView(article: Article){

    //Likes counter state
    var likesCounter by remember { mutableStateOf( article.likes ?:0) }
    var isLiked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp,
        )
    ){
        Text(
            text = article.title ?: "",
            style = MaterialTheme.typography.titleLarge

        )
        Text(
            text = article.description?: "",
            style = MaterialTheme.typography.bodyMedium
        )
        if(article.urlToImage != null){
            AsyncImage(
                model = article.urlToImage,
                contentDescription = "IMAGEM DE EXEMPLO",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                onError = { println ("ERROR COIL: ${it.result.throwable}")}
            )
        }
        Row() {
            Text(
                text = ("Author: " + article.author) ?: "",
                style = MaterialTheme.typography.titleSmall
            )
        }
        Row(modifier = Modifier) {
            Button(onClick = {
                if (isLiked){
                    likesCounter--
                    isLiked = false
                }
                else{
                    likesCounter++
                    isLiked = true
                }
            })
            { Text(
                text = if(isLiked) "Liked" else "Like",
            )}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleRowViewPreview(){
    ArticleRowView(    Article (
        title = "Teste teste",
        description = "descricao descricao descricao descricao descricao descricao",
        author = "Bilau bilau",
        likes = 2,
    ))
}