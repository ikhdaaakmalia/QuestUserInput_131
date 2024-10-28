package com.example.p4

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){
    var Nama by remember { mutableStateOf("") }                 //bertipe string karena ada tanda petik, jika int maka berisi angka
    var Email by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf("") }
    var NoTelp by remember { mutableStateOf("") }


    Column (modifier = modifier.fillMaxSize().padding(16.dp))
    {
        TextField(
            value = Nama,
            onValueChange = {Nama = it},                            //memanggil nama sesuai yg di tulis pada Nama
            label = {
                Text(text = "Nama")
            },
            placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                Text(text = "isi nama anda")                        //hint
            },
            modifier = Modifier.run { fillMaxSize().padding(0.5dp) }
        )
        TextField(
            value = Email,
            onValueChange = {Email = it},                            //memanggil Email sesuai yg di tulis pada Email
            label = {
                Text(text = "Email")
            },
            placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                Text(text = "isi email anda")                        //hint
            },
            modifier = Modifier.fillMaxSize().padding(0.5dp), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = Alamat,
            onValueChange = {Alamat = it},                            //memanggil Alamat sesuai yg di tulis pada Alamat
            label = {
                Text(text = "Alamat")
            },
            placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                Text(text = "isi alamat anda")                        //hint
            },
            modifier = Modifier.fillMaxSize().padding(0.5dp)
        )
        TextField(
            value = NoTelp,
            onValueChange = {NoTelp = it},                            //memanggil nama sesuai yg di tulis pada Nama
            label = {
                Text(text = "NoTelp")
            },
            placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                Text(text = "isi NoTelp anda")                        //hint
            },
            modifier = Modifier.run { fillMaxSize().padding(0.5dp) }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

    }
}

@Composable
fun TampilData(
    param : String, argum: String                                                   //bikin parameter untuk mempermudah memanggil semuanya
){
    Column (modifier = Modifier.padding(16.dp))
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f))           //weight memberi ruang seberapa banyak kpd elemen
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = argum, modifier = Modifier.weight(2f))

        }
    }
}