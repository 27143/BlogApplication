package com.example.blogapplication

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.blogapplication.RequestModel.RegisterUserRequestModel
import com.example.blogapplication.ResponseModel.RegisterResponseModel
import com.example.blogapplication.Retrofit.RetrofitInstance
import com.example.blogapplication.databinding.ActivityCreateAccountBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSignUp.setOnClickListener{
            val  userName = binding.etUserName.text.toString()
            val emailid = binding.etEmailId.text.toString()
            val password = binding.etPassword.text.toString()
            val about = binding.etAbout.text.toString()

            if (valid(userName,emailid,password,about)) {

                try{
                    val model = RegisterUserRequestModel(about,emailid,userName,password)
                    Log.d("MODEL",model.toString())
                    RetrofitInstance.getInstance().register(model).enqueue(object:Callback<RegisterResponseModel>{
                        override fun onResponse(
                            call: Call<RegisterResponseModel>,
                            response: Response<RegisterResponseModel>
                        ) {
                            Log.d("ERROR",response.body().toString())
                            if(response.isSuccessful)
                            {
                                val data = response.body()
                                if (data!= null)
                                {
                                    Toast.makeText(this@CreateAccountActivity,"User Registered Successfully",Toast.LENGTH_LONG).show()
                                }

                            }
                            else
                            {
                                Toast.makeText(this@CreateAccountActivity,"Something went : ${response.code()}",Toast.LENGTH_LONG).show()

                            }
                        }

                        override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                           Toast.makeText(this@CreateAccountActivity,"Fail to get Response",Toast.LENGTH_LONG).show()
                        }

                    })
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }

        }
    }

    private fun valid(userName: String, emailid: String, password: String, about: String): Boolean {

        if (userName.isEmpty())
        {
            binding.etUserName.setError("Please Enter User Name")
            return false
        }
        else if(emailid.isEmpty())
        {
            binding.etEmailId.setError("Please enter password")
            return false
        }
        else if(password.isEmpty())
        {
            binding.etPassword.setError("Please enter Password")
            return false
        }
        else if(about.isEmpty())
        {
            binding.etAbout.setError("Please enter About")
            return false
        }
        return true 

    }
}