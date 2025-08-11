package com.example.complexhp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import complexhp.composeapp.generated.resources.Res
import complexhp.composeapp.generated.resources.compose_multiplatform
import complexhp.composeapp.generated.resources.hero_image
import complexhp.composeapp.generated.resources.product_image
import complexhp.composeapp.generated.resources.play_icon

@Composable
@Preview
fun App() {
    MaterialTheme {
        ComplexHomePage()
    }
}

@Composable
fun ComplexHomePage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            TopNavigationBar()
        }
        
        item {
            HeroSection()
        }
        
        item {
            FeaturedSection()
        }
        
        item {
            StatsSection()
        }
        
        item {
            TestimonialsSection()
        }
        
        item {
            CTASection()
        }
        
        item {
            FooterSection()
        }
    }
}

@Composable
fun TopNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo
        Text(
            text = "LOGO",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A73E8)
        )
        
        // Navigation Menu
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("Home", "About", "Services", "Contact").forEach { item ->
                Text(
                    text = item,
                    fontSize = 16.sp,
                    color = Color(0xFF5F6368)
                )
            }
            
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A73E8)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Get Started", color = Color.White)
            }
        }
    }
}

@Composable
fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Build Amazing Products",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF202124),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Create beautiful, responsive designs with our powerful platform",
            fontSize = 20.sp,
            color = Color(0xFF5F6368),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A73E8)
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(48.dp)
            ) {
                Text("Start Free Trial", color = Color.White, fontSize = 16.sp)
            }
            
            OutlinedButton(
                onClick = { },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(48.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.play_icon),
                    contentDescription = "Play",
                    modifier = Modifier.size(16.dp),
                    tint = Color(0xFF1A73E8)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Watch Demo", color = Color(0xFF1A73E8), fontSize = 16.sp)
            }
        }
        
        Spacer(modifier = Modifier.height(48.dp))
        
        // Hero Image Placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(
                    Color(0xFFF1F3F4),
                    RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.hero_image),
                contentDescription = "Hero Image",
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun FeaturedSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF8F9FA))
            .padding(horizontal = 24.dp, vertical = 64.dp)
    ) {
        Text(
            text = "Featured Products",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF202124),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            items(3) { index ->
                ProductCard(
                    title = "Product ${index + 1}",
                    description = "Amazing features that will help you build better products",
                    price = "$${(index + 1) * 99}"
                )
            }
        }
    }
}

@Composable
fun ProductCard(
    title: String,
    description: String,
    price: String
) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(320.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(
                        Color(0xFFF1F3F4),
                        RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.product_image),
                    contentDescription = "Product Image",
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.Fit
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF202124)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color(0xFF5F6368),
                lineHeight = 20.sp
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = price,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A73E8)
                )
                
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A73E8)
                    ),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text("Buy Now", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun StatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 64.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        listOf(
            "1M+" to "Users",
            "50K+" to "Projects",
            "99.9%" to "Uptime",
            "24/7" to "Support"
        ).forEach { (number, label) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = number,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A73E8)
                )
                Text(
                    text = label,
                    fontSize = 16.sp,
                    color = Color(0xFF5F6368)
                )
            }
        }
    }
}

@Composable
fun TestimonialsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF8F9FA))
            .padding(horizontal = 24.dp, vertical = 64.dp)
    ) {
        Text(
            text = "What Our Customers Say",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF202124),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            items(3) { index ->
                TestimonialCard(
                    name = "Customer ${index + 1}",
                    role = "CEO, Company ${index + 1}",
                    testimonial = "This platform has transformed how we build products. Highly recommended!"
                )
            }
        }
    }
}

@Composable
fun TestimonialCard(
    name: String,
    role: String,
    testimonial: String
) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "\"$testimonial\"",
                fontSize = 16.sp,
                color = Color(0xFF202124),
                lineHeight = 24.sp
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            Color(0xFF1A73E8),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name.first().toString(),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Column {
                    Text(
                        text = name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF202124)
                    )
                    Text(
                        text = role,
                        fontSize = 14.sp,
                        color = Color(0xFF5F6368)
                    )
                }
            }
        }
    }
}

@Composable
fun CTASection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A73E8))
            .padding(horizontal = 24.dp, vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ready to Get Started?",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Join thousands of satisfied customers today",
            fontSize = 18.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.height(48.dp)
        ) {
            Text(
                "Start Your Free Trial",
                color = Color(0xFF1A73E8),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF202124))
            .padding(horizontal = 24.dp, vertical = 48.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "LOGO",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Building the future of digital products",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                Column {
                    Text(
                        text = "Product",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    listOf("Features", "Pricing", "Security").forEach { item ->
                        Text(
                            text = item,
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.7f),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
                
                Column {
                    Text(
                        text = "Company",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    listOf("About", "Careers", "Contact").forEach { item ->
                        Text(
                            text = item,
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.7f),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        HorizontalDivider(color = Color.White.copy(alpha = 0.2f))
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "© 2024 Company Name. All rights reserved.",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f)
            )
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                listOf("Privacy", "Terms", "Cookies").forEach { item ->
                    Text(
                        text = item,
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}