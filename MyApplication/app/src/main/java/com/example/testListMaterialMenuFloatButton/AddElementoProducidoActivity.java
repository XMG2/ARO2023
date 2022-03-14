package com.example.testListMaterialMenuFloatButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Toast;

import java.awt.font.NumericShaper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AddElementoProducidoActivity extends AppCompatActivity {
    private NumberPicker picker;
    List<Integer> numbers;
    List<String> numbers2;
    double precio;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_elemento_producido);

        numbers = Stream.iterate(0, n -> n + 1)
                .limit(1001)
                .collect(Collectors.toList());
        numbers2 = numbers.stream()
            .map(s -> String.valueOf(s))
            .collect(Collectors.toList());
        String[] num = new String[numbers2.size()];
        numbers2.toArray(num);
        picker = (NumberPicker)findViewById(R.id.numberPicker);
        NumberPicker.OnValueChangeListener onValueChangeListener =
                new 	NumberPicker.OnValueChangeListener(){
                    @Override
                    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                        precio = numberPicker.getValue()/100.0;
                        System.out.println(precio);
                    }
                };
        picker.setOnValueChangedListener(onValueChangeListener);
        picker.setMinValue(0);
        picker.setMaxValue(1000);
        picker.setDisplayedValues(num);
    }
}