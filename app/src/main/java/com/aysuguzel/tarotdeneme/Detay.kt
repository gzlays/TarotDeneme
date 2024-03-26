package com.aysuguzel.tarotdeneme

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detay(
    tarotCards: Tarots,

    ) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "TAROTS", fontFamily = FontFamily.Serif) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.topbar),
                    titleContentColor = colorResource(id = R.color.textbeyaz)
                )
            )
        }


    ) { padding ->
        Column(
            modifier = Modifier
                .background(color = Color(36, 21, 71, 223))
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Dondurme(tarotCards)
        }
    }


}

@Composable
fun Dondurme(
    tarot: Tarots
) {

    var rotated by remember {
        mutableStateOf(false)
    }

    val rotar by animateFloatAsState(
        targetValue =
        if (rotated) 180f else 0f,
        animationSpec = tween(1000),
        label = ""
    )


    Card(modifier = Modifier
        .size(width = 300.dp, height = 500.dp)
        .fillMaxSize()
        .graphicsLayer {
            rotationY = rotar
            cameraDistance = 10 * density
        }
        .clickable { rotated = !rotated },

        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.topbar)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        if (!rotated) {
            Onyuz(
                tarot.tarot_resim_adi
            )
        } else {
            Arkayuz(
                rotar,
                tarot.tarot_adi,
                tarot.tarot_aciklama
            )
        }

    }
}


@Composable
fun Onyuz(
    image: String
) {
    Column {
        Image(
            painter = painterResource(id = image.toInt()), contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}


@Composable
fun Arkayuz(
    rotar: Float,
    adi: String,
    aciklama: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(10.dp))

        Text(text = adi,
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.textbeyaz),
            modifier = Modifier
                .padding(start = 2.dp)
                .graphicsLayer {
                    rotationY = rotar
                }
        )

        Spacer(modifier = Modifier.size(30.dp))


        Text(
            text = aciklama,
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.textbeyaz),
            modifier = Modifier
                .padding(all=11.dp)
                .graphicsLayer {
                    rotationY = rotar


           /* text = aciklama,
            fontFamily = FontFamily.Serif,
            color = colorResource(id = R.color.textbeyaz),
            modifier = Modifier
                .padding(all = 11.dp)
                .graphicsLayer {
                    rotationY = rotar */
                }
        )


    }
}


