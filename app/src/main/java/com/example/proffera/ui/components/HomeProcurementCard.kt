package com.example.proffera.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.HourglassEmpty
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proffera.R
import com.example.proffera.data.remote.model.Procurement
import com.example.proffera.ui.theme.*

@Composable
fun HomeProcurement(
    procurement: Procurement,
    modifier: Modifier = Modifier,
) {
//    var isTooltipVisible by remember {
//        mutableStateOf(false)
//    }
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = WhiteSmoke,
        ),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(procurement.pictureProject),
                        contentDescription = "Project Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clip(CircleShape)
                    )
                }
                Icon(
                    imageVector = Icons.Default.BookmarkBorder,
                    contentDescription = "Icon bookmark",
                )
            }
            Text(
                text = procurement.instansiName,
                style = MaterialTheme.typography.titleSmall.copy(color = Gray),
                modifier = Modifier.padding(top = 24.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(Modifier.weight(0.5f)) {
                    Text(
                        text = procurement.projectName,
                        style = MaterialTheme.typography.titleLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                }
                Text(
                    text = procurement.costEstimate,
                    style = MaterialTheme.typography.titleLarge.copy(color = Dark),
                )
            }
            Text(
                text = procurement.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
                    .padding(top = 8.dp),
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(Modifier.weight(1f)) {
                    Card(
                        modifier = Modifier
                            .width(120.dp)
                            .height(IntrinsicSize.Min)
                            .padding(top = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Blue),
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = procurement.status,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                ),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.HourglassEmpty,
                        contentDescription = "deadline"
                    )
                    Text(
                        text = procurement.deadlineEstimate,
                        style = MaterialTheme.typography.titleSmall.copy(color = Dark),
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun HomeProcurementPreview() {
    ProfferaTheme {
        HomeProcurement(
            procurement = Procurement(
                pictureProject = R.drawable.dikti,
                instansiName = "Kemristekdikti",
                projectName = "Pembangunan Technopark",
                costEstimate = "Rp.500 Juta",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. t enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                status = "Dalam Proses",
                deadlineEstimate = "6 Bulan",
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}