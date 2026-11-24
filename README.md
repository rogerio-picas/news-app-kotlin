# News App (MyNews)

Android application built with **Kotlin** and **Jetpack Compose** that displays top headlines fetched from [NewsAPI](https://newsapi.org/).

## Prerequisites

- [Android Studio](https://developer.android.com/studio)
- Android SDK (API 26 or higher)
- A free API key from [NewsAPI](https://newsapi.org/)

## Getting Started

1. **Clone the repository**
   ```bash
   git clone <REPOSITORY_URL>
   cd mynews
   ```

2. **Configure the API key**
   Copy `.env.example` to `.env` in the project root and add your API key:
   ```bash
   cp .env.example .env
   ```
   Edit `.env`:
   ```env
   NEWS_API_KEY=your_newsapi_key_here
   ```
   > `.env` is listed in `.gitignore` and will not be pushed to the repository.

3. **Open and run**
   - Open the `mynews` folder in **Android Studio**.
   - Wait for **Gradle Sync** to finish (it loads `NEWS_API_KEY` into `BuildConfig`).
   - Select an Android emulator or physical device and click **Run**.

## Project Structure (Where to Edit)

```text
app/src/main/java/com/upca/mynews/
├── MainActivity.kt              # Main screen (Scaffold, TopBar, and BottomBar)
├── api/
│   ├── NewsApiService.kt        # NewsAPI endpoints (Retrofit)
│   └── RetrofitInstance.kt      # HTTP client setup
├── models/
│   ├── Article.kt               # Article data model
│   └── NewsResponse.kt          # API response model
└── ui/
    ├── home/
    │   ├── HomeView.kt          # News list screen
    │   └── HomeViewModel.kt     # UI state and API fetch logic
    ├── components/
    │   └── ArticleCard.kt       # Individual article card
    └── theme/                   # Colors, typography, and Material 3 theme
```
