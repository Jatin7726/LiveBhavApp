package com.example.mcxpriceappp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mcxpriceappp.presentation.components.customShadow

@Composable
fun ContactScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF000002))
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
    ) {
        // Location Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(102.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 16.dp,
                bottomEnd = 16.dp,
                bottomStart = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF383636)
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ControlButton(
                        icon = Icons.Default.LocationOn,
                        contentDescription = "Location"
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("ADDRESS", color = Color(0xFFD5A351), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("Near Ram Janki Mandir, Khamariya, Lakhimpur Kheri", color = Color.White, fontSize = 14.sp)
                }
            }
        }

        // Contact Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(102.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 16.dp,
                bottomEnd = 16.dp,
                bottomStart = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF383636)
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ControlButton(
                        icon = Icons.Default.Call,
                        contentDescription = "Phone"
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("CONTACT", color = Color(0xFFD5A351), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("Phn No1: 9696668650", color = Color.White, fontSize = 15.sp)
                    Text("Phn No2: 9889414601", color = Color.White, fontSize = 15.sp)
                }
            }
        }

        // Email Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(102.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 16.dp,
                bottomEnd = 16.dp,
                bottomStart = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF383636)
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ControlButton(
                        icon = Icons.Default.Email,
                        contentDescription = "Email"
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("EMAIL", color = Color(0xFFD5A351), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(7.dp))
                    Text("Email: vishaljewelller01@gmail.com", color = Color.White, fontSize = 15.sp)
                }
            }
        }
    }
}

@Composable
private fun ControlButton(
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(0xFFD5A351),
        shape = CircleShape,
        modifier = modifier
            .size(48.dp)
            .customShadow(
                color = Color.Black,
                alpha = 0.15f,
                shadowRadius = 16.dp,
                borderRadius = 48.dp,
                offsetY = 4.dp
            ),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
