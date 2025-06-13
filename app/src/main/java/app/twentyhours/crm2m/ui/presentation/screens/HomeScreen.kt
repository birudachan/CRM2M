package app.twentyhours.crm2m.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.twentyhours.crm2m.ui.theme.CRM2MTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "CRM2M", style = TextStyle.Default.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            )
                        )
                    }
                },
            )
        }
    ) {
        HomeScreenContent(it)
    }
}

@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth(),
        )
        Column(
            modifier = modifier.padding(horizontal = 12.dp),
        ) {
            UserProfileSection()
        }
    }
}

@Composable
private fun UserProfileSection(
    modifier: Modifier = Modifier,
    profileImg: String = "",
    name: String = "Hồ Lê Ngọc Truyền",
    role: String = "Cán bộ QLKH",
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        UserProfileImage(
            imageUrl = profileImg,
            modifier = Modifier.size(42.dp)
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp,
                alignment = Alignment.CenterVertically
            ),
        ) {
            Text(
                text = name,
                color = Color.Black,
                style = TextStyle.Default.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                ),
            )
            Text(
                text = role,
                color = MaterialTheme.typography.bodySmall.color.copy(alpha = 0.5f),
                style = TextStyle.Default.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                ),
            )
        }
    }
}

@Composable
private fun UserProfileImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.1f),
                shape = RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = imageUrl)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenContentPreview() {
    CRM2MTheme {
        HomeScreen()
    }
}