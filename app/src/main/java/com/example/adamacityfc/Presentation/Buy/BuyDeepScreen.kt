package com.example.adamacityfc.Presentation.Buy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adamacityfc.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyDeepScreen(){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "News",
                style = MaterialTheme.typography.headlineMedium) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        ) {

            item {

            }

            item {
                val desc="Striking Color: The \"Ruby Red\" T-shirt boasts a bold and eye-catching red hue that instantly grabs attention. It's a color that symbolizes energy, passion, and a zest for life.\n" +
                        "Perfect Fit: Designed to flatter, this T-shirt comes in a range of sizes to ensure a comfortable and tailored fit for everyone. Its dimensions are meticulously crafted to accentuate your best features and provide a stylish silhouette."
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.background
                        ),
                        shape = CardDefaults.elevatedShape,
                        onClick = { /*TODO*/ }) {

                        Image(
                            modifier = Modifier
                                .padding(paddingValues)
                                .height(120.dp)
                                .fillMaxWidth(),
                            contentScale = ContentScale.FillHeight,
                            painter = painterResource(id = R.drawable.clubtshirt),
                            contentDescription = ""
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "TShirt", style = MaterialTheme.typography.labelSmall)
                    Text(text = "Price: 350 Birr")
                    Text(text = desc)

                    var isEnabled by remember { mutableStateOf(true) }
                    var buttonText by remember { mutableStateOf("Buy") }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 25.dp),
                        enabled = isEnabled,
                        onClick = {
                            isEnabled=false
                            buttonText="Pending"
                            isEnabled = false }) {
                        Text(text = buttonText)
                    }
                }
            }
        }
    }
}





@Composable
@Preview
fun view(){
    BuyDeepScreen()
}