package com.example.p4

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var Gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-laki", "Perempuan")

    var confNama by remember { mutableStateOf("") }
    var confEmail by remember { mutableStateOf("") }
    var confAlamat by remember { mutableStateOf("") }
    var confNoTelp by remember { mutableStateOf("") }
    var confGender by remember { mutableStateOf("") }


    Column (modifier = modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally)
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
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Row (modifier = modifier.fillMaxWidth()){                       //looping
            dataGender.forEach{selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = Gender == selectedGender,
                        onClick = {Gender = selectedGender}
                    )
                    Text(text = selectedGender)}
            }
        }
        TextField(
            value = Email,
            onValueChange = {Email = it},                            // it = memanggil Email sesuai yg di tulis pada Email
            label = {
                Text(text = "Email")
            },
            placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                Text(text = "isi email anda")                        //hint
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = Alamat,
            onValueChange = {Alamat = it},                            //it = memanggil Alamat sesuai yg di tulis pada Alamat
            label = {
                Text(text = "Alamat")
            },
            placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                Text(text = "isi alamat anda")                        //hint
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        TextField(
            value = NoTelp,
            onValueChange = {NoTelp = it},                            //it = memanggil NoTelp sesuai yg di tulis pada NoTelp
            label = {
                Text(text = "NoTelp")
            },
            placeholder = {                                         //unit itu dlm wget maka ditaruhdi dlm kurung kurawal
                Text(text = "isi NoTelp anda")                       //hint
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {                                          //button kliknya
            confNama = Nama
            confEmail = Email
            confAlamat = Alamat
            confNoTelp = NoTelp
            confGender = Gender
        }){
            Text(text = "Simpan")                                   //conf = biar datanya tampil setelah di pencet button simpan nya
        }
        TampilData(
            param = "Nama",                                         // label dan isi
            argum = confNama)
        TampilData(
            param = "Email",
            argum = confEmail)
        TampilData(
            param = "Alamat",
            argum = confAlamat)
        TampilData(
            param = "NoTelep",
            argum = confNoTelp)
        TampilData(
            param = "Gender",
            argum = confGender)
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
            Text(
                text = param,
                modifier = Modifier.weight(0.8f))                                    //weight memberi ruang seberapa banyak kpd elemen
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f))
            Text(
                text = argum,
                modifier = Modifier.weight(2f))
        }
    }
}