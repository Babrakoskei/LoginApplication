package com.example.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var spGender: Spinner
    lateinit var etEmail: EditText
    lateinit var etPhone: EditText
    lateinit var etPassword: EditText
    lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
    }
    fun castViews(){
        etName=findViewById(R.id.etName)//casting views in the activity.
        spGender=findViewById(R.id.spGender)
        etEmail=findViewById(R.id.etEmail)
        etPhone=findViewById(R.id.etPhone)
        etPassword=findViewById(R.id.etPassword)
        button1=findViewById(R.id.button1)
        var gender= arrayOf("female","male")
        var genderAdapter = ArrayAdapter(baseContext,android.R.layout.simple_spinner_dropdown_item,gender)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGender.adapter=genderAdapter
        clickRegister()
    }


    fun clickRegister() {
        //onclick listener for button
        button1.setOnClickListener {
            var name=etName.text.toString()
            //Toast.makeText(baseContext,name,Toast.LENGTH_LONG).show()//toasting
            var gender=""
            var email=etEmail.text.toString()
            var phonenumber=etPhone.text.toString()
            var password=etPassword.text.toString()
            var details= Details(name,gender,phonenumber,password,email)
            var intent = Intent(baseContext,nextLogin::class.java)
            startActivity(intent)
        }
    }
//data class to hold all data.
data class Details(var name:String,var gender:String,var email:String,var phonenumber: String,var password:String)


}
