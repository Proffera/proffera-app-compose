package com.example.proffera.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proffera.R
import com.example.proffera.ui.components.ProcurementDescCard
import com.example.proffera.ui.theme.*

@Composable
fun DetailScreen() {

}

@Composable
fun DetailContent(
    agencyName: String,
    projectName: String,
    @DrawableRes projectImage: Int,
    projectLocation: String,
    projectDescription: String,
    projectJobs: String,
    projectContractPrice: String,
    projectExecutionTime: String,
    projectRisk: String,
    projectStatus: String,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            Modifier
                .fillMaxWidth()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = DarkBlue,
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(
                        text = agencyName,
                        style = MaterialTheme.typography.titleLarge.copy(color = White),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Card(
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = WhiteSmoke,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(top = 130.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = projectName,
                            style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp),
                        )
                        Text(
                            text = "$agencyName - $projectLocation",
                            style = MaterialTheme.typography.titleSmall,
                            color = LightGray,
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 24.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth(),
//                            .padding(horizontal = 40.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ProcurementDescCard(
                            name = "Vendor",
                            organization = "PT Wayne Enterprise",
                            imageIcon = R.drawable.ic_enterprise,
                            modifier = Modifier.padding(start = 25.dp)
                        ) {

                        }
                        ProcurementDescCard(
                            name = "Tender",
                            organization = "Kemenristekdikti",
                            imageIcon = R.drawable.ic_info,
                            modifier = Modifier.padding(end = 25.dp)
                        ) {

                        }
                    }
                }
            }
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 80.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    shadowElevation = 16.dp,
                    color = DarkBlue,
                    modifier = Modifier.size(100.dp)
                ) {
                    Image(
                        painter = painterResource(projectImage),
                        contentDescription = "Project Image",
                        modifier = Modifier
                            .size(size = 100.dp)
                            .border(1.dp, DarkOrange, CircleShape)
                            .clip(CircleShape)
                            .shadow(
                                elevation = 8.dp,
                                shape = CircleShape,
                                clip = true
                            )
                    )
                }
            }
        }
    }

}


@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun DetailScreenPreview() {
    ProfferaTheme() {
        Surface(color = WhiteSmoke) {
            DetailContent(
                "Kemenristekdikti",
                "Pembangunan Technopark",
                R.drawable.dikti,
                "Jakarta",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. t enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "Membangun technopark yang bagus",
                "Rp.500jt",
                "Juli 2023 - Desember 2023",
                "Tinggi",
                "Dalam Proses"
            )
        }

    }
}
