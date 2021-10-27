package com.thiagoalves.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco,
            numeroSeis, numeroSete, numeroOito, numeroNove, botaoPonto, soma, subtracao, multiplicacao,
            divisao, igual, botaoLimpar;

    private TextView textoExpressao, textoResultado;
    private ImageView botaoBackspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciaComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        botaoPonto.setOnClickListener(this);
        soma.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        subtracao.setOnClickListener(this);

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoExpressao.setText("");
                textoResultado.setText("");
            }
        });

        botaoBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.textExpression);
                String caracteres = expressao.getText().toString();

                if(!caracteres.isEmpty()){
                    byte valorZero = 0;
                    int valorPadrao = caracteres.length() - 1;
                    String textoExpressao = caracteres.substring(valorZero, valorPadrao);
                    expressao.setText(textoExpressao);
                }
                textoResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expressao = new ExpressionBuilder(textoExpressao.getText().toString()).build();
                    double resultadoOperacao = expressao.evaluate();
                    long resultadoLongo = (long) resultadoOperacao;

                    if(resultadoOperacao == (double) resultadoLongo){
                        textoResultado.setText((CharSequence) String.valueOf(resultadoLongo));
                    } else {
                        textoResultado.setText((CharSequence) String.valueOf(resultadoOperacao));
                    }
                } catch (Exception e){

                }
            }
        });
    }

    private void iniciaComponentes(){
        numeroZero = findViewById(R.id.buttonZero);
        numeroUm = findViewById(R.id.buttonOne);
        numeroDois = findViewById(R.id.buttonTwo);
        numeroTres = findViewById(R.id.buttonTree);
        numeroQuatro = findViewById(R.id.buttonFour);
        numeroCinco = findViewById(R.id.buttonFive);
        numeroSeis = findViewById(R.id.buttonSix);
        numeroSete = findViewById(R.id.buttonSeven);
        numeroOito = findViewById(R.id.buttonEight);
        numeroNove = findViewById(R.id.buttonNine);
        botaoPonto = findViewById(R.id.buttonScore);
        soma = findViewById(R.id.buttonAddition);
        subtracao = findViewById(R.id.buttonSubtraction);
        multiplicacao = findViewById(R.id.buttonMultiply);
        divisao = findViewById(R.id.buttonDivision);
        igual = findViewById(R.id.buttonEquals);
        botaoLimpar = findViewById(R.id.buttonClean);
        botaoBackspace = findViewById(R.id.buttonBackspace);
        textoExpressao = findViewById(R.id.textExpression);
        textoResultado = findViewById(R.id.textResult);
    }

    public void adicionaExpressao(String texto, boolean limpaDados){

        if(textoResultado.getText().equals("")){
            textoExpressao.setText(" ");
        }

        if(limpaDados){
            textoResultado.setText(" ");
            textoExpressao.append(texto);
        } else {
            textoExpressao.append(textoResultado.getText());
            textoExpressao.append(texto);
            textoResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonZero:
                adicionaExpressao("0", true);
                break;
            case R.id.buttonOne:
                adicionaExpressao("1", true);
                break;
            case R.id.buttonTwo:
                adicionaExpressao("2", true);
                break;
            case R.id.buttonTree:
                adicionaExpressao("3", true);
                break;
            case R.id.buttonFour:
                adicionaExpressao("4", true);
                break;
            case R.id.buttonFive:
                adicionaExpressao("5", true);
                break;
            case R.id.buttonSix:
                adicionaExpressao("6", true);
                break;
            case R.id.buttonSeven:
                adicionaExpressao("7", true);
                break;
            case R.id.buttonEight:
                adicionaExpressao("8", true);
                break;
            case R.id.buttonNine:
                adicionaExpressao("9", true);
                break;
            case R.id.buttonScore:
                adicionaExpressao(".", true);
                break;
            case R.id.buttonAddition:
                adicionaExpressao("+", false);
                break;
            case R.id.buttonSubtraction:
                adicionaExpressao("-", false);
                break;
            case R.id.buttonMultiply:
                adicionaExpressao("*", false);
                break;
            case R.id.buttonDivision:
                adicionaExpressao("/", false);
                break;
        }
    }
}