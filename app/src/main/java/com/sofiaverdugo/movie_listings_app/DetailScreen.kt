package com.sofiaverdugo.movie_listings_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sofiaverdugo.movie_listings_app.ui.theme.MovielistingsappTheme

@Composable
fun DetailScreen(movieId: Int, onBack: () -> Unit) {
    val movie = movies.first { it.id == movieId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFF12121F))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(movie.picture),
            contentDescription = "Póster de ${movie.title}",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
        )
        Text(
            text = movie.title,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${movie.year} - ${movie.length} min - ${movie.genre}",
            color = Color.White,
            fontWeight = FontWeight.Normal
        )
        Text(text = "Director: ${movie.director}",
            color = Color.White,
            fontWeight = FontWeight.Normal)

        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        Text(text = movie.description,
            color = Color.White,
            fontWeight = FontWeight.Normal)
        OutlinedButton(
            onClick = onBack
        ) {
            Text("Go back",
                color = Color.White,
                fontWeight = FontWeight.SemiBold)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MovielistingsappTheme() {
        DetailScreen(movieId = 1, onBack = { })
    }
}