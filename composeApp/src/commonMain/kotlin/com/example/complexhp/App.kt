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
            Spacer(modifier = Modifier.height(10.dp))
            // Header Section
            HeaderSection()
            // Main Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .offset(y=30.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {

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
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar and Greeting
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
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
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.offset(y = 5.dp),
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
                .width(327.dp)                     // 固定宽度
                .align(Alignment.Center)           // 水平 + 垂直均居中
        ) {
            Box(
                modifier = Modifier
                    .size(261.dp, 164.dp)
                    .offset(y=57.dp)
                    .background(
                        Color(0xFF5655B9),// Semantic/1 color from Figma
                        RoundedCornerShape(10.dp)
                    )
                    .align(Alignment.TopCenter)
            )
            Box(
                modifier = Modifier
                    .size(287.dp, 178.dp)
                    .offset(y=35.dp)
                    .background(
                        Color(0xFFFF4267),  // Semantic/1 color from Figma
                        RoundedCornerShape(10.dp)
                    )
                    .align(Alignment.TopCenter)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(204.dp)
                    .background(
                        Color(0xFF1573FF),  // Semantic/1 color from Figma
                        RoundedCornerShape(10.dp)
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .align(Alignment.TopCenter)
            ) {
                Box(
                    modifier = Modifier
                        .offset(x = (-130).dp, y = (-25).dp)
                        .size(350.dp)          // 圆的直径，按需要改
                        .aspectRatio(1f)
                        .background(Color(0xFF1E1671), CircleShape)// 左上角偏移
                )

                /* 圆2 */
                Box(
                    modifier = Modifier
                        .offset(x = 223.dp, y = (-59).dp)
                        .size(190.dp)          // 圆的直径，按需要改
                        .aspectRatio(1f)
                        .background(Color(0xFF4EB4FF), CircleShape)// 右下角偏移
                )
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
                        .padding(start = 253.dp, top = 161.dp)  // 79.35% top, 8.13% left
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
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        repeat(4) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(Color.White)
                            )
                        }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        repeat(4) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(Color.White)
                            )
                        }
                    }

                    Text(
                        text = "9018",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif
                    )
                }

                Text(
                    text = "$3.469.52",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = 34.dp, top = 163.dp)  // 73.5% top, 60.19% left
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
            Row(
                modifier = Modifier
                    .size(width = 92.dp, height = 36.dp)
                    .background(Color(0xFF3629B7), RoundedCornerShape(20.dp)),   // 背景色可换
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_tab_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                )

                Text(
                    text = "Home",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
            }

            Image(
                painter = painterResource(Res.drawable.ic_tab_search_alt),
                contentDescription = "Search Alt",
                modifier = Modifier.size(24.dp)
            )

            Image(
                painter = painterResource(Res.drawable.ic_tab_mail),
                contentDescription = "mail",
                modifier = Modifier.size(24.dp)
            )

            Image(
                painter = painterResource(Res.drawable.ic_tab_more),
                contentDescription = "More",
                modifier = Modifier.size(24.dp)
            )
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