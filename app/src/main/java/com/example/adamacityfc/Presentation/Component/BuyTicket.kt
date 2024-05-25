package com.example.adamacityfc.Presentation.Component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BuyTicket(text1:String,
              text2:String="Adama City F.c",
              date:String){
    OutlinedCard (
        modifier = Modifier.padding(12.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier
                    .padding(start = 5.dp)
                    .weight(0.6f)
            ){
                Text(text = "$text2 vs $text1",style = MaterialTheme.typography.labelLarge, maxLines = 2)
                Text(text = date, 
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Thin))
            }
            var isEnable by remember {
                mutableStateOf(true)
            }
            var buttonText by remember {
                mutableStateOf("Get Ticket")
            }
            Button(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(10.dp),
                enabled = isEnable,
                onClick = {
                    isEnable=false
                    buttonText="Pending"
                }) {
                Text(text = buttonText)
            }
        }
    }
}