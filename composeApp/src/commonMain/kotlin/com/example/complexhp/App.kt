package com.example.complexhp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import complexhp.composeapp.generated.resources.Res
import complexhp.composeapp.generated.resources.*

@Composable
@Preview
fun App() {
    MaterialTheme {
        BankingHomePage()
    }
}

@Composable
fun BankingHomePage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3629B7)) // Primary purple background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Status Bar
            StatusBar()

            // Main Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        Color.White,
                        RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                // Header Section
                HeaderSection()

                Spacer(modifier = Modifier.height(32.dp))

                // Bank Card
                BankCardSection()

                Spacer(modifier = Modifier.height(40.dp))

                // Categories Grid
                CategoriesGrid()
            }

            // Tab Bar
            TabBar()
        }
    }
}

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 24.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Time
        Text(
            text = "9:09",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontFamily = FontFamily.SansSerif
        )

        // Signal icons
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Mobile signal
            Image(
                painter = painterResource(Res.drawable.ic_status_mobile_signal),
                contentDescription = "Mobile Signal",
                modifier = Modifier.size(12.dp)
            )

            // Wifi
            Image(
                painter = painterResource(Res.drawable.ic_status_wifi),
                contentDescription = "Wifi",
                modifier = Modifier.size(12.dp)
            )
        }

        // Battery
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Battery outline
            Box(
                modifier = Modifier
                    .size(22.dp, 11.33.dp)
                    .background(Color.White.copy(alpha = 0.35f), RoundedCornerShape(1.33.dp)),
                contentAlignment = Alignment.Center
            ) {
                // Battery fill
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.82f)
                        .fillMaxHeight(0.75f)
                        .background(Color.White, RoundedCornerShape(0.67.dp))
                )
            }

            // Battery tip
            Box(
                modifier = Modifier
                    .size(1.33.dp, 3.33.dp)
                    .background(Color.White)
            )
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar and Greeting
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Avatar
            Image(
                painter = painterResource(Res.drawable.img_header_user_avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Greeting
            Text(
                text = "Hi, Push Puttichai",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif
            )
        }

        // Notification Icon with Badge
        Box(
            modifier = Modifier.size(26.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            // Notification Icon
            Image(
                painter = painterResource(Res.drawable.ic_header_notification_bell),
                contentDescription = "Notification",
                modifier = Modifier.size(24.dp)
            )

            // Badge
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(Color(0xFFFF4267), CircleShape)
                    .align(Alignment.TopEnd)
                    .offset(x = 2.dp, y = (-2).dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun BankCardSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(221.dp)
    ) {
        // Background layers with exact Figma positioning
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)  // 80% width (approximating Figma's left/right margins)
                .fillMaxHeight(0.74f)  // 74% height (bottom layer positioning)
                .background(
                    Color(0xFF5655B9),  // Primary/2 color from Figma
                    RoundedCornerShape(10.dp)
                )
                .align(Alignment.BottomCenter)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.88f)  // 88% width (Figma inset positioning)
                .fillMaxHeight(0.96f)  // 96% height (top layer positioning)
                .background(
                    Color(0xFFFF4267),  // Semantic/1 color from Figma
                    RoundedCornerShape(10.dp)
                )
                .align(Alignment.TopCenter)
        )

        // Main card with exact Figma positioning
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(0xFF3629B7),  // Primary/1 color
                    RoundedCornerShape(10.dp)
                )
        ) {
            // Card content with absolute positioning to match Figma
            Box(modifier = Modifier.fillMaxSize()) {
                // Card background (base layer)
                Box(
                    modifier = Modifier.fillMaxSize()
                )

                // Shape overlays (masked elements from Figma)
                // Note: In Compose, we simulate these with additional Box elements
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1.1233f)  // -12.33% width extension
                        .fillMaxHeight(1.5793f)  // -57.93% height extension
                        .background(Color(0xFF5655B9).copy(alpha = 0.3f))  // Semi-transparent overlay
                        .align(Alignment.TopStart)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(1.2936f)  // -29.36% width extension
                        .fillMaxHeight(1.3738f)  // 37.38% height extension
                        .background(Color(0xFFFF4267).copy(alpha = 0.2f))  // Semi-transparent overlay
                        .align(Alignment.TopStart)
                )

                // Card content with exact Figma positioning
                // Name - inset-[10.5%_48.33%_69.93%_6.25%]
                Text(
                    text = "John Smith",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 34.dp, top = 23.dp)  // 10.5% left, 6.25% top
                )

                // Card type - inset-[45.5%_50.02%_45.8%_6.25%]
                Text(
                    text = "Amazon Platinium",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 34.dp, top = 101.dp)  // 45.5% top, 6.25% left
                )

                // Visa logo - inset-[79.35%_8.13%_13.04%_77.63%]
                Image(
                    painter = painterResource(Res.drawable.ic_card_visa_logo),
                    contentDescription = "Visa",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 26.dp, top = 176.dp)  // 79.35% top, 8.13% left
                        .size(40.dp, 16.dp)
                )

                // Card numbers - inset-[59.78%_80.08%_27.17%_5%]
                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 34.dp, top = 133.dp),  // 59.78% top, 5% left
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "4756",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = "9018",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_card_hidden_numbers),
                        contentDescription = "Hidden",
                        modifier = Modifier.size(16.dp)
                    )
                }

                // Balance - inset-[73.5%_60.19%_11.28%_6.25%]
                Text(
                    text = "$3.469.52",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 196.dp, top = 163.dp)  // 73.5% top, 60.19% left
                )
            }
        }
    }
}

data class CategoryItem(
    val title: String,
    val icon: String
)

@Composable
fun CategoryCard(
    category: CategoryItem
) {
    Card(
        modifier = Modifier
            .size(100.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Icon
            Image(
                painter = painterResource(getIconResource(category.icon)),
                contentDescription = category.title,
                modifier = Modifier.size(28.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Title
            Text(
                text = category.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF979797),
                textAlign = TextAlign.Center,
                lineHeight = 16.sp,
                maxLines = 2
            )
        }
    }
}

@Composable
fun getIconResource(iconName: String): org.jetbrains.compose.resources.DrawableResource {
    return when (iconName) {
        "wallet" -> Res.drawable.ic_category_wallet
        "sync" -> Res.drawable.ic_category_transfer
        "credit_in" -> Res.drawable.ic_category_withdraw
        "mobile" -> Res.drawable.ic_category_mobile_prepaid
        "receipt" -> Res.drawable.ic_category_pay_bill
        "pig" -> Res.drawable.ic_category_save_online
        "credit_card" -> Res.drawable.ic_category_credit_card
        "file" -> Res.drawable.ic_category_transaction_report
        "contacts" -> Res.drawable.ic_category_beneficiary
        else -> Res.drawable.ic_category_wallet
    }
}

@Composable
fun CategoriesGrid() {
    val categories = listOf(
        CategoryItem("Account\nand Card", "wallet"),
        CategoryItem("Transfer", "sync"),
        CategoryItem("Withdraw", "credit_in"),
        CategoryItem("Mobile\nprepaid", "mobile"),
        CategoryItem("Pay the\nbill", "receipt"),
        CategoryItem("Save\nonline", "pig"),
        CategoryItem("Credit\ncard", "credit_card"),
        CategoryItem("Transaction\nreport", "file"),
        CategoryItem("Beneficiary", "contacts")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
    ) {
        items(categories) { category ->
            CategoryCard(category = category)
        }
    }
}

@Composable
fun TabBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(91.dp)
    ) {
        // Tab bar background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        )

        // Tab bar shadow
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black.copy(alpha = 0.07f))
                .align(Alignment.TopCenter)
        )

        // Tab content
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // More tab
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_tab_more),
                    contentDescription = "More",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "More",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF979797),
                    fontFamily = FontFamily.SansSerif
                )
            }

            // Home tab (active)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color(0xFF3629B7), RoundedCornerShape(20.dp))
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_tab_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Home",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
            }

            // Search tab
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_tab_search),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Search",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF979797),
                    fontFamily = FontFamily.SansSerif
                )
            }

            // Alternative Search tab
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_tab_search_alt),
                    contentDescription = "Search Alt",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Discover",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF979797),
                    fontFamily = FontFamily.SansSerif
                )
            }
        }

        // Home indicator
        Box(
            modifier = Modifier
                .width(134.dp)
                .height(5.dp)
                .background(Color(0xFFCACACA), RoundedCornerShape(2.5.dp))
                .align(Alignment.BottomCenter)
                .offset(y = (-8).dp)
        )
    }
}