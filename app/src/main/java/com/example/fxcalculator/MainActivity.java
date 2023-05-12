package com.example.fxcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText balance;
    private EditText maxRick;
    private EditText pipStoplot;
    private EditText pip_dinh_day_keylbqt;
    private TextView vol;

    private double investMoney;
    private double _balance;
    private double _maxRick;
    private double _pipInStopLot;
    private double _pip_dinh_day_keylbqt;

    private double _vol;

    private TextView vol1;
    private TextView vol2;
    private TextView vol3;
    private TextView vol4;
    private TextView vol5;


    private TextView pip3;
    private TextView pip4;
    private TextView pip5;



    private void setVol() {

        pip3.setText("0.00");
        pip4.setText("0.00");
        pip5.setText("0.00");
        try {
            _balance = Double.valueOf(balance.getText().toString()).doubleValue();
            _maxRick = Double.valueOf(maxRick.getText().toString()).doubleValue();
            investMoney = _balance * _maxRick / 100;



            _pipInStopLot = Double.valueOf(pipStoplot.getText().toString()).doubleValue();

            String result2 = "0.00";
            String result3 = "0.00";
            String result4 = "0.00";
            String result5 = "0.00";





            try {
                _pip_dinh_day_keylbqt = Double.valueOf(pip_dinh_day_keylbqt.getText().toString()).doubleValue();

                result2 = String.valueOf(Double.parseDouble(String.valueOf((investMoney * 2 * 0.1) / (10 * (_pipInStopLot - _pip_dinh_day_keylbqt)))));
                try {
                    int position = result2.indexOf(".")+ 3;
                    result2 = result2.substring(0, position);

                } catch (Exception e) {
                    System.out.println("Err(62):" + e);
                }

                try {
                    if(_pipInStopLot > _pip_dinh_day_keylbqt){
                        result3 = String.valueOf(Double.parseDouble(String.valueOf((investMoney * 2 * 0.2) / (10 * (_pipInStopLot - _pip_dinh_day_keylbqt - (_pipInStopLot - _pip_dinh_day_keylbqt)*0.25)))));
                        pip3.setText(String.valueOf(Double.parseDouble(String.valueOf((_pipInStopLot - _pip_dinh_day_keylbqt)*0.25))));
                        result4 = String.valueOf(Double.parseDouble(String.valueOf((investMoney * 2 * 0.4) / (10 * (_pipInStopLot - _pip_dinh_day_keylbqt -(_pipInStopLot - _pip_dinh_day_keylbqt)*0.5)))));
                        pip4.setText(String.valueOf(Double.parseDouble(String.valueOf((_pipInStopLot - _pip_dinh_day_keylbqt)*0.5))));
                        result5 = String.valueOf(Double.parseDouble(String.valueOf((investMoney * 2 * 0.2) / (10 * (_pipInStopLot - _pip_dinh_day_keylbqt -(_pipInStopLot - _pip_dinh_day_keylbqt)*0.75)))));
                        pip5.setText(String.valueOf(Double.parseDouble(String.valueOf((_pipInStopLot - _pip_dinh_day_keylbqt)*0.75))));
                        try {
                            int position = result3.indexOf(".")+ 3;
                            result3 = result3.substring(0, position);
                        } catch (Exception e) {
                            System.out.println("Err(76): " + e);
                        }
                        try {
                            int position = result4.indexOf(".")+ 3;
                            result4 = result4.substring(0, position);
                        } catch (Exception e) {
                            System.out.println("Err(82): " + e);
                        }
                        try {
                            int position = result5.indexOf(".") + 3;
                            result5 = result5.substring(0, position);
                        } catch (Exception e) {
                            System.out.println("Err(88): " + e);
                        }
                    }
                } catch (Exception e) {
                }

            } catch (Exception e) {
                System.out.println("Err: " + e);
            }

            String result = String.valueOf(Double.parseDouble(String.valueOf(investMoney / (10 * _pipInStopLot))));
            System.out.println("resulr: " + result );

            String result1 = String.valueOf(Double.parseDouble(String.valueOf((investMoney * 2 * 0.1) / (10 * _pipInStopLot))));


            try {
                int position = result.indexOf(".") + 3;
                result = result.substring(0, position);

                position = result1.indexOf(".") + 3;
                result1 = result1.substring(0, position);


            } catch (Exception e) {
                System.out.println("Err: " + e);
            }
            vol.setText(result);
            vol1.setText(result1);
            vol2.setText(result2);
            vol3.setText(result3);
            vol4.setText(result4);
            vol5.setText(result5);


        } catch (Exception e) {
            vol.setText("");
            System.out.println("Err: " + e);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);



        balance = findViewById(R.id.balance);
        maxRick = findViewById(R.id.max_rick);
        pipStoplot = findViewById(R.id.pip_stoplot);
        pip_dinh_day_keylbqt = findViewById(R.id.pip_dinh_day_keylbqt);

        vol = findViewById(R.id.vol);
        vol1 = findViewById(R.id.vol1);
        vol2 = findViewById(R.id.vol2);
        vol3 = findViewById(R.id.vol3);
        vol4 = findViewById(R.id.vol4);
        vol5 = findViewById(R.id.vol5);


        pip3 = findViewById(R.id.pip3);
        pip4 = findViewById(R.id.pip4);
        pip5 = findViewById(R.id.pip5);




        try {
            _balance = Double.valueOf(balance.getText().toString()).doubleValue();
            _maxRick = Double.valueOf(maxRick.getText().toString()).doubleValue();
            investMoney = _balance * _maxRick / 100;


            try {
                _pipInStopLot = Double.valueOf(pipStoplot.getText().toString()).doubleValue();
                vol.setText(String.valueOf(Double.parseDouble(String.valueOf(investMoney / (10 * _pipInStopLot)))));

            } catch (Exception e) {
                System.out.println("Err: " + e);
            }

        } catch (Exception e) {
            System.out.println("Err: " + e);
        }


        balance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setVol();
            }
        });

        maxRick.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setVol();
            }
        });

        pipStoplot.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setVol();
            }
        });


        pip_dinh_day_keylbqt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setVol();
            }
        });


    }
}