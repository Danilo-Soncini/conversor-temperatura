package ufpr.tempcalc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton celsius = (RadioButton) findViewById(R.id.toCelsius);
        celsius.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCelsius();
            }
        });

        RadioButton fahrenheit = (RadioButton) findViewById(R.id.toFahrenheit);
        fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFahrenheit();
            }
        });

        Button converter = (Button) findViewById(R.id.converter);
        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().getDecorView().clearFocus();
                converter();
            }
        });


    }

    public void converter(){

        EditText temperatura = (EditText) findViewById(R.id.temperatura);
        TextView resposta = (TextView) findViewById(R.id.resultado);
        if(temperatura.length() == 0){
            Toast.makeText(this, "Forneça uma temperatura!",Toast.LENGTH_SHORT).show();
        }
        else {
            float temp = Float.parseFloat(temperatura.getText().toString());
            RadioButton fahrenheit = (RadioButton) findViewById(R.id.toFahrenheit);
            if (fahrenheit.isChecked()) {
                resposta.setText(temp + "°C  é : " + String.valueOf(C2F(temp)) + "°F." );
            }
            else {
                resposta.setText(temp + "°F  é : " + String.valueOf(F2C(temp)) + "°C." );
            }
        }

    }

    public float C2F(float celsius){
        return ((celsius*9/5)+32);
    }

    public float F2C(float fahrenheit){
        return ((fahrenheit-32)*5)/9;
    }

    public void setCelsius(){
        TextView simbolo = (TextView) findViewById(R.id.simbolo);
        simbolo.setText(" °F");
    }

    public void setFahrenheit (){
        TextView simbolo = (TextView) findViewById(R.id.simbolo);
        simbolo.setText(" °C");
    }
}
