package com.example.calculadoragas_etn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText tndGas;
    private EditText tndEtn;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tndGas = findViewById(R.id.tndGas);
        tndGas.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tndEtn = findViewById(R.id.tndEtn);
        tndEtn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btComp = findViewById(R.id.btComp);

        btComp.setOnClickListener(op -> calc());
    }

    private void calc() {

        float gas = Float.parseFloat(tndGas.getText().toString());
        float etn = Float.parseFloat(tndEtn.getText().toString());
        String res = "";
        if(etn < gas*0.7){
            res = "O etanol compensa mais que a gasolina.";
        }else{
            res = "A gasolina compensa mais que o etanol.";
        }

        tvRes.setText(res);

        tndEtn.setText("");
        tndGas.setText("");
    }
}