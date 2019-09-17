package com.example.exercicio17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] paises = getResources().getStringArray(R.array.array_paises);
        final String[] estados = getResources().getStringArray(R.array.array_estados);
        final String[] cidades = getResources().getStringArray(R.array.array_cidades_goias);

        final Spinner spinnerPais = (Spinner) findViewById(R.id.pais);
        final Spinner spinnerEstado = (Spinner) findViewById(R.id.estado);
        final Spinner spinnerCidade = (Spinner) findViewById(R.id.cidade);

        final ArrayAdapter<String> paisAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, paises);
        final ArrayAdapter<String> estadoAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, estados);
        final ArrayAdapter<String> cidadeAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, cidades);

        spinnerPais.setAdapter(paisAdapter);

        spinnerPais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 28){
                    spinnerEstado.setAdapter(estadoAdapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 8){
                    spinnerCidade.setAdapter(cidadeAdapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    public void sendMessage(View view){
        Context context = getApplicationContext();
        String texto;
        int duracao = Toast.LENGTH_SHORT;

        EditText nome = findViewById(R.id.nome);
        String nomeText = nome.getText().toString();

        EditText sobrenome = findViewById(R.id.sobrenome);
        String sobrenomeText = sobrenome.getText().toString();

        EditText endereco = findViewById(R.id.endereco);
        String enderecoText = endereco.getText().toString();

        EditText cep = findViewById(R.id.cep);
        String cepNumero = cep.getText().toString();

        boolean cepRegex = Pattern.matches("[0-9]{8}",cepNumero);

        if(TextUtils.isEmpty(nomeText)){
            Toast toast = Toast.makeText(context, "Campo 'nome' vazio!", duracao);
            toast.show();
        } else if (TextUtils.isEmpty(sobrenomeText)) {
            Toast toast = Toast.makeText(context, "Campo 'sobrenome' vazio!", duracao);
            toast.show();
        } else if (TextUtils.isEmpty(enderecoText)){
            Toast toast = Toast.makeText(context, "Campo 'endereço' vazio!", duracao);
            toast.show();
        } else if (!cepRegex){
            Toast toast = Toast.makeText(context, "Campo 'cep' inválido!", duracao);
            toast.show();
        } else{
            Toast toast = Toast.makeText(context, "Formulário enviado", duracao);
            toast.show();
        }
    }
}
