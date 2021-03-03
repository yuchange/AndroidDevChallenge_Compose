/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun HomePetList(viewModel: PetViewModel) {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            PetList(viewModel)
        }
    }
}

@Composable
fun PetList(viewModel: PetViewModel) {
    LazyColumn(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        itemsIndexed(viewModel.petList) { index, pet ->
            PetListItem(pet)
        }
    }
}

@Composable
fun PetListItem(pet: Pet) {
    val viewModel: PetViewModel = viewModel()
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    viewModel.goToDetail(pet)
                }
            )
    ) {
        Image(
            painterResource(pet.avatar), "avatar",
            Modifier
                .padding(20.dp, 20.dp, 20.dp, 20.dp)
                .size(200.dp)
                .clip(
                    RoundedCornerShape(4.dp)
                )
        )
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {

            Text(pet.name, fontSize = 25.sp, color = Color.Blue)
        }
    }
}
