package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.bmicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int intweight=55;
    int intage=22;
    int currentprogress;
    String mintprogress="170";
    String typeofuser="0";
    String weight="55";
    String age2="22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP )
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.gray));

        }

        getSupportActionBar().hide();


        binding.male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.male.setBackground(ContextCompat.getDrawable( getApplicationContext(),R.drawable.malefemalfocus));
                binding.female.setBackground(ContextCompat.getDrawable( getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });

        binding.female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalfocus));
                binding.male.setBackground(ContextCompat.getDrawable( getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });


        binding.seekbarforheight.setMax(300);
        binding.seekbarforheight.setProgress(170);
        binding.seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                binding.currentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        binding.incrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage=intage+1;
                age2=String.valueOf(intage);
                binding.mage.setText(age2);
            }
        });

        binding.incrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight=intweight+1;
                weight=String.valueOf(intweight);
                binding.mweight.setText(weight);
            }
        });

        binding.decrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage=intage-1;
                age2=String.valueOf(intage);
                binding.mage.setText(age2);
            }
        });

        binding.decrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intweight=intweight- 1;
                weight=String.valueOf(intweight);
                binding.mweight.setText(weight);
            }
        });





        binding.calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(typeofuser.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Select the gender", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0") ) {

                    Toast.makeText(MainActivity.this, "Incorrect Height", Toast.LENGTH_SHORT).show();
                }
                else if(intage==0 || intage <0)
                {
                    Toast.makeText(MainActivity.this, "Incorrect Age", Toast.LENGTH_SHORT).show();
                }
                else if(intweight==0 || intweight<0)
                {
                    Toast.makeText(MainActivity.this, "Incorrect Weight", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Intent intent=new Intent(MainActivity.this,bmiActivity.class);

                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("age",age2);
                    intent.putExtra("weight",weight);
                    startActivity(intent);
                }




            }
        });


    }
}