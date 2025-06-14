package app.twentyhours.crm2m.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.twentyhours.crm2m.ui.presentation.components.ListItem
import app.twentyhours.crm2m.ui.presentation.components.ListTitle
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
            .padding(paddingValues)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth(),
        )
        Column(
            modifier = modifier.padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            UserProfileSection()
            SearchBarSection()
            OverallSection()
            QuickSummarySection()
            RecentActivitiesSection()
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
                color = MaterialTheme.colorScheme.onSurface,
                style = TextStyle.Default.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                ),
            )
            Text(
                text = role,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
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
    )
}

@Composable
private fun SearchBarSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(4.dp),
                )
                .padding(start = 12.dp, end = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Tim kiếm khách hàng...",
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                style = TextStyle.Default.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                ),
            )
            Box(
                modifier = Modifier
                    .width(32.dp)
                    .height(24.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(2.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.background,
                )
            }
        }
        Text(
            text = "Go CIF hoac ten khach hang de tim kiem nhanh.",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            style = TextStyle.Default.copy(
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            ),
        )
    }
}

@Composable
private fun OverallSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ListTitle(title = "TONG QUAN")
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Khach hang Quan ly",
                    value = "150",
                )
                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Tong du no (trd)",
                    value = "222,000",
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Tong HDV (trd)",
                    value = "50,000",
                )
                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Viec can lam hom nay",
                    value = "10",
                )
            }
        }
    }
}

@Composable
private fun SummaryItem(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                shape = RoundedCornerShape(
                    4.dp
                )
            )
            .padding(12.dp)
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            style = TextStyle.Default.copy(
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            ),
        )
        Text(
            text = value,
            color = MaterialTheme.colorScheme.onSurface,
            style = TextStyle.Default.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            ),
        )
    }
}

@Composable
private fun QuickSummarySection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ListTitle(title = "THONG KE NHANH")
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ListItem(
                title = "No den han, dao han",
                value = "25",
                icon = Icons.Default.DateRange,
            )
            ListItem(
                title = "So luong khoan vay",
                value = "200",
                icon = Icons.Default.AccountBox,
            )
            ListItem(
                title = "Khach hang moi trong thang",
                value = "15",
                icon = Icons.Default.Add,
            )
        }
    }
}

@Composable
private fun RecentActivitiesSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ListTitle(title = "HOAT DONG GAN DAY")
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ListItem(
                title = "Nguyen Van A",
                subtitle = "Thu no",
                icon = Icons.Default.Person,
            )
            ListItem(
                title = "Le Thi B",
                subtitle = "Nhac no den han",
                icon = Icons.Default.Person,
            )
            ListItem(
                title = "Le Thi B",
                subtitle = "Nhac no den han",
                icon = Icons.Default.Person,
            )
            ListItem(
                title = "Le Thi B",
                subtitle = "Nhac no den han",
                icon = Icons.Default.Person,
            )
            ListItem(
                title = "Le Thi B",
                subtitle = "Nhac no den han",
                icon = Icons.Default.Person,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenContentPreview() {
    CRM2MTheme {
        HomeScreen()
    }
}