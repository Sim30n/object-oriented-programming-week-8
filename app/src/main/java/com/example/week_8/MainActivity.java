package com.example.week_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;



public class MainActivity extends AppCompatActivity {

    BottleDispenser bottledispenser = BottleDispenser.getInstance();
    Context context = null;
    TextView text;
    SeekBar seekbar;
    Spinner sBrands;
    Spinner s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        context = MainActivity.this;
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

        String[] arraySpinner = new String[] {
                "0.5", "1.5"
        };
        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        String[] arrayBrands = new String[] {
                "Pepsi Max", "Coca-Cola Zero", "Fanta Zero"
        };
        sBrands = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayBrands);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBrands.setAdapter(brandAdapter);
    }

    public void addMoney(View v){
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
        s = (Spinner) findViewById(R.id.spinner);
        String value = sBrands.getSelectedItem().toString();
        String size_str = s.getSelectedItem().toString();
        double size = Double.parseDouble(size_str);
        String buyB = bottledispenser.buyBottle(value, size);
        text.setText(buyB);
    }

    public void returnMoney(View v) {
        String returnM = bottledispenser.returnMoney();
        text.setText(returnM);
    }

    public void writeFile(View v){
        try{
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput("kuitti.txt", Context.MODE_PRIVATE));
            String s = bottledispenser.printRecipt();
            ows.write(s);
            System.out.println(s);
            ows.close();
        } catch(IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        } finally {
            System.out.println("Kirjoitettu");
        }
    }

}
