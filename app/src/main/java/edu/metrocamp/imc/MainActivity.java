package edu.metrocamp.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editPeso = findViewById(R.id.edit_peso);
        this.mViewHolder.editAltura = findViewById(R.id.edit_altura);
        this.mViewHolder.viewImc = findViewById(R.id.text_valor_imc);
        this.mViewHolder.buttonCalcular = findViewById(R.id.button_calcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(v.getId() == R.id.button_calcular) {
            Double peso = Double.valueOf(this.mViewHolder.editPeso.getText().toString());
            Double altura = Double.valueOf(this.mViewHolder.editAltura.getText().toString()) / 100;
            Double imc = peso / (altura * altura);
            this.mViewHolder.viewImc.setText(String.format("%.2f",imc));
        }
    }

    private static class ViewHolder {
        EditText editPeso;
        EditText editAltura;
        TextView viewImc;
        Button buttonCalcular;
    }
}
