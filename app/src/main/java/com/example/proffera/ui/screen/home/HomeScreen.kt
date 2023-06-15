package com.example.proffera.ui.screen.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proffera.R
import com.example.proffera.data.remote.response.ProcurementResponse
import com.example.proffera.ui.common.UiState
import com.example.proffera.ui.components.HomeProcurement
import com.example.proffera.ui.components.Search
import com.example.proffera.ui.components.appbar.AppBar
import com.example.proffera.ui.theme.WhiteSmoke

@Composable
fun HomeScreen(drawerState: DrawerState, viewModel: HomeViewModel = hiltViewModel()) {
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(WhiteSmoke)
        ) {
            viewModel.procurementsState.collectAsState().value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getAllProcurements()
                    }
                    is UiState.Success -> {
                        HomeScreenContent(
                            listProcurement = uiState.data,
                            scrollState = scrollState
                        )
                    }
                    is UiState.Error -> {
                        Log.d(TAG, "HomeScreen: Error")
                    }
                }
            }
        }
    }
}


@Composable
fun HomeScreenContent(
    listProcurement: List<ProcurementResponse>,
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
        items(listProcurement) { procurement ->
            HomeProcurement(
                projectName = procurement.data.firstOrNull()?.data?.namaPaket ?: "",
                winnerVendor = procurement.data.firstOrNull()?.data?.namaPemenang ?: "",
                city = procurement.data.firstOrNull()?.data?.workingAddress ?: "",
                projectCost = procurement.data.firstOrNull()?.data?.pagu.toString(),
                projectDescription = procurement.data.firstOrNull()?.data?.description ?: "",
                projectStatus = "Dalam Review",
                projectDuration = "6 Bulan",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}


//@Composable
//@Preview(showBackground = true, device = Devices.PIXEL_4)
//fun HomeScreenPreview() {
//    ProfferaTheme() {
//        Surface(color = WhiteSmoke) {
//            HomeScreen(drawerState = rememberDrawerState(DrawerValue.Closed))
//        }
//
//    }
//}