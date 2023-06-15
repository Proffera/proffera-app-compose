package com.example.proffera.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proffera.R
import com.example.proffera.ui.theme.*

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = OtterBrown),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(400.dp)
                .aspectRatio(1f)
                .scale(1.85f)
                .background(color = MetallicBronze, shape = CircleShape)
        ) {
            Box(
                modifier = Modifier
                    .size(400.dp)
                    .aspectRatio(1f)
                    .scale(0.75f)
                    .background(color = Oil, shape = CircleShape)
            ) {

            }
        }
        Box(
            modifier = Modifier.size(300.dp),
            contentAlignment = Alignment.Center,
            content = {
                // Round logo in the center
                Image(
                    painter = painterResource(R.drawable.logo_proffera), // Replace with your logo image resource
                    contentDescription = "Logo",
                )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    ProfferaTheme {
        Surface(color = WhiteSmoke) {
            SplashScreen()
        }
    }
}