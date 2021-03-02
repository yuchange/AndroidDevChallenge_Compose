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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Pet

class PetViewModel :ViewModel(){

    val petList by mutableStateOf(
        listOf(
            Pet("Adopting a dog or puppy",R.mipmap.dog,"Adopting a dog is a great way to give a dog or puppy a second chance by providing a loving fur-ever home. Find out what you need to know before adopting."),
            Pet("Adopting a cat or kitten",R.mipmap.cat,"Cats make wonderful companions and there are many cats and kittens available for adoption at the RSPCA. Find out what you need to know before adopting a cat."),
                    Pet("Adopting other animals",R.mipmap.laoshu,"There are many types of animals looking for new homes. Find out about how to care for different types of animals and how they can make great pets.")
        )
    )

    var detailPage by mutableStateOf(false)

    var detailPet : Pet? by mutableStateOf(null)

    var offset = 500.dp

    fun goToDetail(pet:Pet){
       detailPage = true
        detailPet = pet
    }



}