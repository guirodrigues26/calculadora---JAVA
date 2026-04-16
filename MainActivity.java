package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtTela;
    String numero1 = "";
    String numero2 = "";
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTela = findViewById(R.id.txtTela);

        // Registrar os botões
        int[] botoes = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnSomar, R.id.btnSubtrair, R.id.btnMultiplicar, R.id.btnDividir,
                R.id.btnIgual, R.id.btnLimpar
        };

        for (int id : botoes) {
            findViewById(id).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        // Números
        if (v.getId() == R.id.btn0) adicionarNumero("0");
        else if (v.getId() == R.id.btn1) adicionarNumero("1");
        else if (v.getId() == R.id.btn2) adicionarNumero("2");
        else if (v.getId() == R.id.btn3) adicionarNumero("3");
        else if (v.getId() == R.id.btn4) adicionarNumero("4");
        else if (v.getId() == R.id.btn5) adicionarNumero("5");
        else if (v.getId() == R.id.btn6) adicionarNumero("6");
        else if (v.getId() == R.id.btn7) adicionarNumero("7");
        else if (v.getId() == R.id.btn8) adicionarNumero("8");
        else if (v.getId() == R.id.btn9) adicionarNumero("9");

            // Operações
        else if (v.getId() == R.id.btnSomar) definirOperacao("+");
        else if (v.getId() == R.id.btnSubtrair) definirOperacao("-");
        else if (v.getId() == R.id.btnMultiplicar) definirOperacao("*");
        else if (v.getId() == R.id.btnDividir) definirOperacao("/");

            // Igual e Limpar
        else if (v.getId() == R.id.btnIgual) calcular();
        else if (v.getId() == R.id.btnLimpar) limpar();
    }

    void adicionarNumero(String num) {
        if (operacao.isEmpty()) {
            numero1 += num;
            txtTela.setText(numero1);
        } else {
            numero2 += num;
            txtTela.setText(numero2);
        }
    }

    void definirOperacao(String op) {
        if (!numero1.isEmpty()) {
            operacao = op;
        }
    }

    void calcular() {
        if (numero1.isEmpty() || numero2.isEmpty() || operacao.isEmpty()) return;

        double n1 = Double.parseDouble(numero1);
        double n2 = Double.parseDouble(numero2);
        double resultado = 0;

        switch (operacao) {
            case "+": resultado = n1 + n2; break;
            case "-": resultado = n1 - n2; break;
            case "*": resultado = n1 * n2; break;
            case "/":
                if (n2 != 0) resultado = n1 / n2;
                else {
                    txtTela.setText("Erro");
                    limpar();
                    return;
                }
                break;
        }

        txtTela.setText(String.valueOf(resultado));
        numero1 = String.valueOf(resultado);
        numero2 = "";
        operacao = "";
    }

    void limpar() {
        numero1 = "";
        numero2 = "";
        operacao = "";
        txtTela.setText("0");
    }
}