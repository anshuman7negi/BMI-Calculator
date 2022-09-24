package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bmicalculator.databinding.ActivityBmiBinding;

public class bmiActivity extends AppCompatActivity {

    ActivityBmiBinding binding;

    TextView mbmidisplay,mbmigender,mbmicategory;
    ImageView mimageView;
    Intent intent;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBmiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP )
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.gray));

        }

        getSupportActionBar().hide();


        intent=getIntent();

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

        if(intbmi<18.5)
        {
            binding.bmicategory.setText("UnderWeight (Patlu)");
            binding.background.setBackgroundColor(Color.YELLOW);
            binding.imageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<=24.9 && intbmi>18.5)
        {
            binding.bmicategory.setText("Healthy (Smart)");
            binding.background.setBackgroundColor(Color.GREEN);
            binding.imageview.setImageResource(R.drawable.ok);
        }
        else if(intbmi<29.9 && intbmi>25.0)
        {
            binding.bmicategory.setText("OverWeight (Motu)");
            binding.background.setBackgroundColor(Color.YELLOW);
            binding.imageview.setImageResource(R.drawable.warning);
        }

        else
        {
            binding.bmicategory.setText("Obese (Bhut jada MOTU)");
            binding.background.setBackgroundColor(Color.RED);
            binding.imageview.setImageResource(R.drawable.crosss);

        }



        binding.genderdisplay.setText(intent.getStringExtra("gender"));
        binding.bmidisplay.setText(mbmi);




        binding.Recalculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bmiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}