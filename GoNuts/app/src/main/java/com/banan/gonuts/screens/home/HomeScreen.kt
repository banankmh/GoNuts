package com.banan.gonuts.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.banan.gonuts.R
import com.banan.gonuts.screens.BottomNavigationBar
import com.banan.gonuts.ui.theme.Typography
import com.banan.gonuts.ui.theme.onBackground60
import com.banan.gonuts.ui.theme.onSecondary
import com.banan.gonuts.ui.theme.primary
import com.banan.gonuts.ui.theme.secondary

@Composable
fun HomeScreen(
    navController: NavController,
   viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    HomeContent(onClickToDetails ={}, navController =navController,  state = state)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    state: HomeUiState,
    onClickToDetails: () -> Unit,
    navController: NavController
) {
    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navController)
    }) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 24.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.let_s_gonuts),
                        style = Typography.labelLarge,
                    )
                    Text(
                        text = stringResource(R.string.order_your_favourite_donuts_from_here),
                        style = Typography.labelSmall,
                        color = onBackground60
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(45.dp)
                        .background(shape = RoundedCornerShape(15.dp), color = onSecondary)
                        .clip(RoundedCornerShape(15.dp)),
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription ="Search",
                        tint = primary
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                DonutsOffers(state.offersDonut, onClick = onClickToDetails)
                Donuts(state.donuts)
        }
        }
    }
}

