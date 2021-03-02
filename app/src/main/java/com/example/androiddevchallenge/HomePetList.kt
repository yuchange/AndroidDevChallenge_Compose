package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.Pet


    @Composable
    fun HomePetList(viewModel:PetViewModel) {
        Column(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .background(Color.White)
                    .fillMaxSize()) {
                PetList(viewModel)
            }
        }


    }

    @Composable
    fun PetList(viewModel: PetViewModel) {
        LazyColumn(
            Modifier
                .background(Color.White)
                .fillMaxWidth()){
            itemsIndexed(viewModel.petList){index, pet ->
                petListItem(pet)

            }


        }


    }
    @Composable
    fun petListItem(pet: Pet) {
        val viewModel: PetViewModel = viewModel()
        Row(
            Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    viewModel.goToDetail(pet)
//                viewModel.offset = 0.dp
//                Log.d("123456", "${viewModel!!.currentPage!!.name}")
                })
        ){
            Image(
                painterResource(pet.avatar),"avatar",
                Modifier
                    .padding(20.dp, 20.dp, 20.dp, 20.dp)
                    .size(200.dp)
                    .clip(
                        RoundedCornerShape(4.dp)
                    ))
            Column(
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                Text(pet.name,fontSize = 25.sp,color = Color.Blue)
            }


        }


    }
