package com.example.archivo_leer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.FileInputStream;


public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    TextView tv;
    EditText ed1;

    String data;
    private String file = "miarchivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        ed1 = (EditText) findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=ed1.getText().toString();
                try {
                    FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(), "Archivo Guardado", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream fin= openFileInput(file);
                    int c;
                    String temp="";
                    while((c= fin.read()) != -1){
                        temp= temp + Character.toString((char)c);
                    }
                    tv.setText(temp);
                    Toast.makeText(getBaseContext(), "Archivo Leido", Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }
            }
        });
    }
}
