package com.example.week_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    BottleDispenser bottledispenser = BottleDispenser.getInstance();
    TextView text;
    TextView money;
    EditText mEdit;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Current amount: " + progressChangedValue + "€" ,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addMoney(View v){
        System.out.println(seekbar.getProgress());
        String addM = bottledispenser.addMoney(seekbar.getProgress());
        text.setText(addM);
    }

    public void printBottles(View v){
        text.setText("");
        for(int i = 0;i<bottledispenser.bottle_array.size();i++) {
            text.append(i+1 +". Name: "+bottledispenser.bottle_array.get(i).getName()+"    Size: "+bottledispenser.bottle_array.get(i).getSize()+"	Price: "+bottledispenser.bottle_array.get(i).getCost()+"\n");
        }
    }

    public void buyBottle(View v){
        mEdit   = (EditText)findViewById(R.id.editText);
        String value = mEdit.getText().toString();
        int choice = Integer.parseInt(value);
        String buyB = bottledispenser.buyBottle(choice);
        text.setText(buyB);
    }

    public void returnMoney(View v) {
        String returnM = bottledispenser.returnMoney();
        text.setText(returnM);
    }

}
