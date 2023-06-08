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
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
//            Wrap icon and wrapping row consist of image and title
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
//                Wrap image and title in a row
                Row(
                    modifier = Modifier
                        .width(width = 285.dp)
                ) {
                    Image(
                        painter = painterResource(procurement.pictureProject),
                        contentDescription = "Project Picture",
                        modifier = Modifier
                            .size(size = 50.dp)
                            .clip(CircleShape)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(width = 16.dp)
                    )
                    Column {
                        Text(
                            text = procurement.projectName,
                            style = MaterialTheme.typography.titleMedium,
                            color = Dark,
                            textAlign = TextAlign.Start,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "${procurement.instansiName} - ${procurement.city}",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                            color = LightGray,
                            textAlign = TextAlign.Start,
                        )
                    }
                }
                Icon(
                    imageVector = Icons.Default.BookmarkBorder,
                    contentDescription = "Icon bookmark",
                    modifier = Modifier
                        .height(24.dp)
                        .weight(1f) // Added weight modifier
                        .wrapContentWidth(Alignment.End)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun HomeProcurementPreview() {
    ProfferaTheme {
        Surface(color = WhiteSmoke) {
            HomeProcurement(
                procurement = Procurement(
                    pictureProject = R.drawable.dikti,
                    instansiName = "Kemristekdikti",
                    projectName = "Pembangunan Technopark",
                    city = "Jakarta",
                    costEstimate = "Rp.500 Juta",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. t enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    status = "Dalam Proses",
                    deadlineEstimate = "6 Bulan",
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}