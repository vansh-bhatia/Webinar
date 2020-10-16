package com.example.webinar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveBtn.setOnClickListener{
            val id=idField.text.toString()
            val name = nameField.text.toString()
            val age = ageField.text.toString()
            val userData = UserData(name, age)
            val ref = FirebaseDatabase.getInstance().getReference("${id}/")
            ref.setValue(userData)
                .addOnSuccessListener {
                    Toast.makeText(this,"Saved Successfully",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Failure To Save Data",Toast.LENGTH_SHORT).show()
                }
        }
    }
}

data class UserData(val name:String,val age:String){
    constructor():this("","")
}