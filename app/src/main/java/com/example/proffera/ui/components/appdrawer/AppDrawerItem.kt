package com.example.proffera.ui.components.appdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.proffera.DrawerParams
import com.example.proffera.ui.theme.LightGray
import com.example.proffera.ui.theme.ProfferaTheme

@Composable
fun <T : Any> AppDrawerItem(item: AppDrawerItemInfo<T>, isSelected: Boolean, onClick: (options: T) -> Unit) =
    Surface(
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick(item.drawerOption) },
        shape = RoundedCornerShape(20),
    ) {
        val background = if (isSelected) {
            LightGray // Set the background color for the selected item
        } else {
            Transparent // Set the background color for non-selected items
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(background)
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = item.drawableId),
                contentDescription = stringResource(id = item.descriptionId),
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = item.title),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

class NavigationItemProvider : PreviewParameterProvider<AppDrawerItemInfo<Screen>> {
    override val values = sequence {
        DrawerParams.drawerButtons.forEach { element ->
            yield(element)
        }
    }
}

@Preview
@Composable
fun NavigationItemPreview(@PreviewParameter(NavigationItemProvider::class) state: AppDrawerItemInfo<Screen>) {
    ProfferaTheme {
        AppDrawerItem(item = state, isSelected = false, onClick = {})
    }
}