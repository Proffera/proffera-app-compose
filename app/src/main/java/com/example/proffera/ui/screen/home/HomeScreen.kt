package com.example.proffera.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proffera.data.remote.model.Procurement
import com.example.proffera.data.remote.model.dummyProcurement
import com.example.proffera.ui.components.HomeProcurement
import com.example.proffera.ui.components.Search
import com.example.proffera.ui.theme.ProfferaTheme
import com.example.proffera.ui.theme.WhiteSmoke

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HomeScreenContent(modifier = modifier)
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Icon bookmark",
                )
            }
            Image(
                painter = painterResource(id = com.example.proffera.R.drawable.ic_launcher_background),
                contentDescription = "Project Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(CircleShape)
            )
        }
        Text(
            text = "Temukan Proyek Anda di Sini",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(top = 8.dp)
                .width(230.dp)
        )
        Search(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
        HomeCardProcurement(dummyProcurement)
    }
}

@Composable
fun HomeCardProcurement(
    listProcurement: List<Procurement>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(listProcurement, key = { it.instansiName }) { procurement ->
            HomeProcurement(procurement)
        }
    }
}


@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun HomeScreenPreview() {
    ProfferaTheme() {
        Surface(color = WhiteSmoke) {
            HomeScreen()
        }

    }
}