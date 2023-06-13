package com.example.proffera.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proffera.R
import com.example.proffera.data.remote.model.Procurement
import com.example.proffera.data.remote.model.dummyProcurement
import com.example.proffera.ui.components.HomeProcurement
import com.example.proffera.ui.components.Search
import com.example.proffera.ui.components.appbar.AppBar
import com.example.proffera.ui.theme.ProfferaTheme
import com.example.proffera.ui.theme.WhiteSmoke

@Composable
fun HomeScreen(drawerState: DrawerState) {
    Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState
            )
        }
    ) {
        HomeScreenContent(dummyProcurement)
    }
}


@Composable
fun HomeScreenContent(listProcurement: List<Procurement>, modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .background(WhiteSmoke)
            .padding(16.dp)
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 56.dp)
            ) {
                Box(Modifier.weight(1f)) {
                    Text(
                        text = stringResource(id = R.string.header_wording),
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Start,
                        modifier = modifier
                            .width(230.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(id = R.string.project_picture),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clip(CircleShape)
                )
            }
            Search(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
        }
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
            HomeScreen(drawerState = rememberDrawerState(DrawerValue.Closed))
        }

    }
}