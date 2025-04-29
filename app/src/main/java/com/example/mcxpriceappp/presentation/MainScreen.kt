package com.example.mcxpriceappp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mcxpriceappp.data.NavItem

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*

import androidx.compose.ui.res.painterResource
import com.example.mcxpriceappp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navItemList = listOf(
        NavItem(label = "Live Bhav", icon = Icons.Default.BarChart),
        NavItem(label = "Contact", icon = Icons.Default.Call),
        // NavItem(label = "Profile", icon = Icons.Default.Person)
    )
    val selectedIndex = remember { mutableIntStateOf(0) }
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF000002))) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Column(
                    modifier = Modifier.padding(top = 5.dp)
                        .background(Color(0xFF000002)), // Increases only top padding
                ) {
                    ActionBar()
                }
            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFD5A351), // Golden border
                            shape = RoundedCornerShape(
                                topEnd = 36.dp,
                                bottomStart = 36.dp,
                                bottomEnd = 36.dp
                            )
                        )
                ) {
                    NavigationBar(
                        containerColor = Color(0xFF000002)

                    ) {
                        navItemList.forEachIndexed { index, navItem ->
                            NavigationBarItem(
                                selected = selectedIndex.intValue == index,
                                onClick = { selectedIndex.intValue = index },
                                icon = {
                                    Icon(
                                        imageVector = navItem.icon,
                                        contentDescription = navItem.label,
                                        tint = if (selectedIndex.intValue == index) Color(0xFFD5A351) else Color.White // Golden when selected
                                    )
                                },
                                label = {
                                    Text(
                                        text = navItem.label,
                                        color = if (selectedIndex.intValue == index) Color(
                                            0xFFD5A351
                                        ) else Color.White // Golden when selected
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color(0xFFD5A351), // Golden when selected
                                    unselectedIconColor = Color.White, // White when unselected
                                    selectedTextColor = Color(0xFFD5A351), // Golden text when selected
                                    unselectedTextColor = Color.White, // White text when unselected
                                    indicatorColor = Color.Transparent //  Removes background hover effect
                                )

                            )
                        }
                    }
                }
            },
            containerColor = Color.Transparent
        )
        { innerPadding ->
            ContentScreen(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color(0xFF000002)),
                selectedIndex.intValue
            )
        }
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when (selectedIndex) {
       0 -> LiveBhavScreen(modifier)//LiveBhavScreen() baad m krdena
//        0 -> LiveBhavScreen()
        1 -> ContactScreen(modifier)
      //  2 -> ProfileScreen()
    }
}
@Composable
fun ActionBar(
    modifier: Modifier = Modifier.background(Color(0xFF000002))
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 0.dp),
        verticalAlignment = Alignment.CenterVertically, // Align items properly
        horizontalArrangement = Arrangement.Start // Ensures elements don't spread out
    ) {
        Image(
            painter = painterResource(id = R.drawable.brandlogo1),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.brandname1),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}