package com.example.mcxpriceappp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mcxpriceappp.R
import com.example.mcxpriceappp.api.Metals
import com.example.mcxpriceappp.viewModel.MainViewModel
import com.example.mcxpriceappp.viewModel.UiState

@Composable
fun LiveBhavScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value
    val scrollState = rememberScrollState()

    when (uiState) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000002)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Success -> {
            val metals = uiState.metals

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000002))
                    .padding(start = 10.dp, end = 10.dp, top = 95.dp)
                    .verticalScroll(scrollState), // Enable vertical scrolling here
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Card(
                        modifier = Modifier.wrapContentSize(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFD5A351))
                    ) {
                        Row(
                            modifier = Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Circle,
                                contentDescription = "Live Call",
                                tint = Color.Red,
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "LIVE",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                    Button(
                        onClick = { viewModel.refreshData() },
                        modifier = Modifier.wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD5A351),
                            contentColor = Color.Black
                        ),
                        elevation = ButtonDefaults.buttonElevation(30.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "REFRESH",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh",
                            modifier = Modifier.size(20.dp),
                            tint = Color.Black
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    PriceCard(
                        title = "GOLD MCX",
                        basePrice = metals.mcxGold * 10,
                        amPrice = metals.mcxGoldAM * 10,
                        pmPrice = metals.mcxGoldPM * 10,
                        unit = "/10gm",
                        imageResId = R.drawable.gold_bars,
                        modifier = Modifier.weight(1f)
                    )
                    PriceCard(
                        title = "SILVER MCX",
                        basePrice = metals.mcxSilver * 1000,
                        amPrice = metals.mcxSilverAM * 1000,
                        pmPrice = metals.mcxSilverPM * 1000,
                        unit = "/Kg",
                        imageResId = R.drawable.silverbar,
                        modifier = Modifier.weight(1f)
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF383636))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "GOLD IBJA 999",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFD5A351)
                        )
                        Text(
                            text = "₹${String.format("%.2f", metals.ibjaGold * 10)} /10gm",
                            fontSize = 15.sp,
                            color = Color.White
                        )
                    }
                }
                CurrencySpotCard(uiState)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "LIVE RATE WITH 3% GST",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
                Divider(
                    color = Color(0xFFD5A351),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                PriceSection(metals = metals)
            }
        }
        is UiState.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000002)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error: ${uiState.message}",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
fun PriceCard(
    title: String,
    basePrice: Double,
    amPrice: Double,
    pmPrice: Double,
    unit: String,
    imageResId: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF383636))
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFD5A351),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Divider(
                color = Color(0xFFD5A351),
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "₹${String.format("%.2f", basePrice)} $unit",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                    Text(
                        text = "AM: ₹${String.format("%.2f", amPrice)} $unit",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Text(
                        text = "PM: ₹${String.format("%.2f", pmPrice)} $unit",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }
        }
    }
}

@Composable
fun CurrencySpotCard(uiState: UiState) {
    if (uiState is UiState.Success) {
        val usdToInr = uiState.usdToInr
        val eurToInr = uiState.eurToInr
        val aedToInr = uiState.aedToInr

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 0.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF383636))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "INR SPOT",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFD5A351),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Divider(
                    color = Color(0xFFD5A351),
                    thickness = 1.dp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    CurrencyItem("USD", usdToInr)
                    DividerBox()
                    CurrencyItem("EUR", eurToInr)
                    DividerBox()
                    CurrencyItem("AED", aedToInr)
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(label: String, rate: Double) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
        Text(text = "₹${String.format("%.2f", rate)}", fontSize = 16.sp, color = Color.White)
    }
}

@Composable
fun DividerBox() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(24.dp)
            .background(Color(0xFFD5A351))
    )
}

@Composable
fun PriceCardWithDetails(
    title: String,
    mainPrice: String,
    amPrice: String,
    pmPrice: String,
    unit: String,
    cardColor: Color = Color(0xFF383636),
    accentColor: Color = Color(0xFFD5A351)
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = accentColor,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Divider(
                color = accentColor,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "₹$mainPrice $unit",
                    fontSize = 15.sp,
                    color = Color.White
                )
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "AM: ₹$amPrice $unit",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                    Text(
                        text = "PM: ₹$pmPrice $unit",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun PriceSection(
    metals: Metals,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PriceCardWithDetails(
            title = "GOLD 995 WITH GST",
            mainPrice = String.format("%.2f", calculateFinalPrice(metals.mcxGold * 10, 3.0, 386.0)),
            amPrice = String.format("%.2f", calculateFinalPrice(metals.mcxGoldAM * 10, 3.0, 386.0)),
            pmPrice = String.format("%.2f", calculateFinalPrice(metals.mcxGoldPM * 10, 3.0, 386.0)),
            unit = "/10gm"
        )
        PriceCardWithDetails(
            title = "SILVER 999 WITH GST",
            mainPrice = String.format("%.2f", calculateFinalPriceSilver(metals.mcxSilver, 3.0)),
            amPrice = String.format("%.2f", calculateFinalPriceSilver(metals.mcxSilverAM, 3.0)),
            pmPrice = String.format("%.2f", calculateFinalPriceSilver(metals.mcxSilverPM, 3.0)),
            unit = "/kg"
        )
        PriceCardWithDetails(
            title = "GOLD 999 BEFORE GST",
            mainPrice = String.format("%.2f", metals.mcxGold * 10),
            amPrice = String.format("%.2f", metals.mcxGoldAM * 10),
            pmPrice = String.format("%.2f", metals.mcxGoldPM * 10),
            unit = "/10gm"
        )
    }
}

fun calculateFinalPrice(basePrice: Double, gstPercent: Double = 3.0, premium: Double = 0.0): Double {
    val gst = basePrice * (gstPercent / 100)
    return basePrice + gst + premium
}

fun calculateFinalPriceSilver(basePrice: Double, gstPercent: Double = 3.0, premium: Double = 0.0): Double {
    val gst = basePrice * (gstPercent / 100)
    val finalprice = (basePrice + gst + premium) * 1000
    return finalprice
}