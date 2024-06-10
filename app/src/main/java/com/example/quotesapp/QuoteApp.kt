package com.example.quotesapp

import QuoteViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
//import kotlin.text.Typography.quote

import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun QuoteApp(
    viewModel: QuoteViewModel=viewModel()
){

    val quote = viewModel.quote
    Column(
        modifier= Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Quotes", color = colorResource(id = R.color.goodred),
            fontSize = 28.sp, fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier=Modifier.height(300.dp))

         quote?.let{
            Text(
                text=it.q,
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "- ${it.a}",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic
            )
        }?: Text(
            text = "Here Will be Quote",
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif
        )
        
        Spacer(modifier = Modifier.height(270.dp))
        Button(onClick = { viewModel.getQuote() }){
                Text("Next",
                    fontFamily = FontFamily.SansSerif)

        }

    }
}


