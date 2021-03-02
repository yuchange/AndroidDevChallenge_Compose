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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PetDetail(viewModel: PetViewModel) {
    Column(
        Modifier
            .layout { measurable, constraints ->
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height) {
                    val offset = if (viewModel.detailPage) 0 else placeable.width
                    placeable.placeRelative(offset, 0)
                }
            }
            .fillMaxSize()
            .background(Color.White)) {
        Image(
            painterResource(R.mipmap.exit),"exit",
            Modifier
                .size(40.dp)
                .background(
                    Color.White
                )
                .clickable {
                    viewModel.detailPet = null
                    viewModel.detailPage = false
                })
        if (viewModel.detailPet!=null) {
            Image(
                painterResource(viewModel.detailPet!!.avatar), "avatar", Modifier.fillMaxWidth().size(200.dp),
                Alignment.Center)
            Text(viewModel.detailPet!!.info, Modifier.fillMaxWidth(), Color.Blue,25.sp)
        }
    }

}





