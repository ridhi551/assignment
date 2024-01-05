package com.example.netclan.refine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;

import com.example.netclan.R;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.Slider;

public class RefineActivity extends AppCompatActivity {
    public static final float minValue = 0f;
    public static final float maxValue = 100f;
    private AutoCompleteTextView select;
    private ArrayAdapter<String> adapter;
    private String [] items ;
    private Slider slider;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        items = getResources().getStringArray(R.array.ideas);
        select = findViewById(R.id.select);
        dropDown();
        slider = findViewById(R.id.slide);
        slider.setValueFrom(minValue);
        slider.setValueTo(maxValue);
    }
    private void dropDown(){
        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,items);
        select.setAdapter(adapter);}
}