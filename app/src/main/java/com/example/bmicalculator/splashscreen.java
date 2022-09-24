package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.bmicalculator.databinding.ActivitySplashscreenBinding;

public class splashscreen extends AppCompatActivity {

    ActivitySplashscreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP )
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.gray));

        }

        getSupportActionBar().hide();


        Thread thread=new Thread()
        {

            public  void run(){

                try {
                    sleep(4000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent= new Intent(splashscreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }


            }


        }; thread.start();



    }
}