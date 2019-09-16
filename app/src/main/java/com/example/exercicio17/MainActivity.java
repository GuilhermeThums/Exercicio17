package com.example.exercicio17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] paises = getResources().getStringArray(R.array.array_paises);
        String[] estados = getResources().getStringArray(R.array.array_estados);
        String[] cidades = getResources().getStringArray(R.array.array_cidades_goias);

        final Spinner spinnerPais = (Spinner) findViewById(R.id.pais);
        final Spinner spinnerEstado = (Spinner) findViewById(R.id.estado);
        final Spinner spinnerCidade = (Spinner) findViewById(R.id.cidade);

        ArrayAdapter<String> paisAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, paises);
        ArrayAdapter<String> estadoAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, estados);
        ArrayAdapter<String> cidadeAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, cidades);

        spinnerPais.setAdapter(paisAdapter);
        spinnerEstado.setAdapter(estadoAdapter);
        spinnerCidade.setAdapter(cidadeAdapter);

        spinnerPais.setOnItemClickListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelectedListener(AdapterView<?> arg0, View arg1,int position, long arg3){
                spinnerPais.setSelection(position);
            }

            public void onNothingSelected(AdapterView<?> arg0){

            }

        });

        spinnerEstado.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemSelectedListener(AdapterView<?> arg0, View arg1, int position, long arg3){
                spinnerEstado.setSelection(position);
            }

            public void onNothingSelected(AdapterView<?> arg0){

            }
        });



        Spinner textView = findViewById(R.id.pais);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        textView.setAdapter(adapter);

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

        //EditText cep = findViewById(R.id.cep);
        //int cepNumero = Integer.parseInt(cep.getText().toString());


        /*AutoCompleteTextView pais = findViewById(R.id.pais);
        String paisText = pais.getText().toString();

        AutoCompleteTextView estado = findViewById(R.id.estado);
        String estadoText = estado.getText().toString();

        AutoCompleteTextView cidade = findViewById(R.id.cidade);
        String cidadeText = cidade.getText().toString();


        boolean nomeRegex = Pattern.matches("\\d", nomeText);
        boolean sobrenomeRegex = Pattern.matches("\\d", sobrenomeText);
        boolean cepRegex = Pattern.matches();
        */
        if(TextUtils.isEmpty(nomeText)){
            Toast toast = Toast.makeText(context, "Campo 'nome' vazio!", duracao);
            toast.show();
        } else if (TextUtils.isEmpty(sobrenomeText)) {
            Toast toast = Toast.makeText(context, "Campo 'sobrenome' vazio!", duracao);
            toast.show();
        }



    }
}
