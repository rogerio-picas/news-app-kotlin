package com.upca.mynews.ui.home
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upca.mynews.BuildConfig
import com.upca.mynews.api.RetrofitInstance
import com.upca.mynews.models.Article
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var articles by mutableStateOf<List<Article>>(emptyList())
            private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        fetchNews()
    }

    private fun fetchNews(){
        viewModelScope.launch{
            isLoading=true
            try {
                val response = RetrofitInstance.api.getTopHeadlines(
                    apiKey = BuildConfig.NEWS_API_KEY
                )
                articles = response.articles ?: emptyList()
            } catch (e: Exception){
              print("API ERROR: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}