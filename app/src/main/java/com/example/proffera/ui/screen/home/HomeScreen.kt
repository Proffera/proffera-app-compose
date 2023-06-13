package com.example.proffera.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
    val scrollState = rememberLazyListState()

    val isScrolling = remember { mutableStateOf(false) }
    val lastOffset = remember { mutableStateOf(0) }

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemIndex }
            .collect { currentIndex ->
                val isScrollingUp = currentIndex < lastOffset.value
                isScrolling.value = currentIndex != lastOffset.value && !isScrollingUp
                lastOffset.value = currentIndex
            }
    }

    Scaffold(
        topBar = {
            if (!isScrolling.value) {
                AppBar(
                    drawerState = drawerState
                )
            }
        }
    ) {
        HomeScreenContent(dummyProcurement, scrollState)
    }
}


@Composable
fun HomeScreenContent(
    listProcurement: List<Procurement>,
    scrollState: LazyListState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .background(WhiteSmoke)
            .padding(16.dp),
        state = scrollState
    ) {
        item {
            Text(
                text = stringResource(id = R.string.header_wording),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Start,
                modifier = modifier
                    .width(230.dp)
                    .padding(top = 56.dp)
            )
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