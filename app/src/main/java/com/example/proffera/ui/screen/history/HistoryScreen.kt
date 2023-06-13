package com.example.proffera.ui.screen.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.proffera.R
import com.example.proffera.ui.theme.ProfferaTheme

@Composable
fun NavigationDrawer() {
    LazyColumn(
        modifier = Modifier
            .width(width = 360.dp)
            .padding(all = 12.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color(0xfff7f2fa))
    ) {
        item {
            BuildingBlocksHeadline()
        }
        item {
            BuildingBlocksSectionHeader()
        }
        item {
            StyleActiveStateEnabledShowIconTrue()
        }
        items(3) {
            StyleInactiveStateEnabledShowIconTrue()
        }
        item {
            Horizontalmiddleinset()
        }
        item {
            BuildingBlocksSectionHeader()
        }
        items(3) {
            StyleInactiveStateEnabledShowIconTrue()
        }
        item {
            Horizontalmiddleinset()
        }
        item {
            BuildingBlocksSectionHeader()
        }
        items(3) {
            StyleInactiveStateEnabledShowIconTrue()
        }
    }
}

@Composable
fun BuildingBlocksHeadline() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp)
            .padding(
                start = 16.dp,
                end = 8.dp,
                top = 8.dp,
                bottom = 8.dp
            )
    ) {
        Text(
            text = "Title",
            color = Color(0xff49454f),
            lineHeight = 1.43.em,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun BuildingBlocksSectionHeader() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 18.dp
            )
            .clip(shape = RoundedCornerShape(100.dp))
    ) {
        Text(
            text = "Section Header",
            color = Color(0xff49454f),
            lineHeight = 1.43.em,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun StyleActiveStateEnabledShowIconTrue() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp)
            .clip(shape = RoundedCornerShape(100.dp))
            .background(color = Color(0xffe8def8))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 24.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_enterprise),
                contentDescription = "Icon",
                tint = Color(0xff1d192b)
            )
            Spacer(
                modifier = Modifier
                    .width(width = 12.dp)
            )
            Text(
                text = "Label",
                color = Color(0xff1d192b),
                lineHeight = 1.43.em,
                style = TextStyle(
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .width(width = 12.dp)
            )
            Text(
                text = "100+",
                color = Color(0xff1d192b),
                textAlign = TextAlign.End,
                lineHeight = 1.43.em,
                style = TextStyle(
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
                )
            )
        }
    }
}

@Composable
fun StyleInactiveStateEnabledShowIconTrue() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp)
            .clip(shape = RoundedCornerShape(100.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 24.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_enterprise),
                contentDescription = "Icon",
                tint = Color(0xff49454f)
            )
            Spacer(
                modifier = Modifier
                    .width(width = 12.dp)
            )
            Text(
                text = "Label",
                color = Color(0xff49454f),
                lineHeight = 1.43.em,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun Horizontalmiddleinset() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Divider(
            color = Color(0xffcac4d0)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ApplyButtonPreview() {
    ProfferaTheme() {
        NavigationDrawer()
    }
}