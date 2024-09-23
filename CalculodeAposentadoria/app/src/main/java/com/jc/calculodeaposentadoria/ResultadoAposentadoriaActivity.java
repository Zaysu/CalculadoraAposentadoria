package com.jc.calculodeaposentadoria;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultadoAposentadoriaActivity extends Activity {

    private TextView tvResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_aposentadoria);

        tvResultado = findViewById(R.id.tv_resultado);
        btnVoltar = findViewById(R.id.btn_voltar);

        Intent intent = getIntent();
        int montante = intent.getIntExtra("MONTANTE", 0);
        int anosContribuicao = intent.getIntExtra("ANOS_CONTRIBUICAO", 0);
        double taxaJuros = intent.getDoubleExtra("TAXA_JUROS", 0.0);

        double I_taxJuros = taxaJuros / 12;

        double Cresult = montante * I_taxJuros;
        double Cresult2 = Cresult / 1 + I_taxJuros;
        double Cresult3 = anosContribuicao * 12;
        double Cresult4 = Cresult2 * Cresult2 * Cresult3;

        double CresultFinal = Cresult4 - 1;


        tvResultado.setText(String.format("Contribuição mensal necessaria sera de:" + CresultFinal));


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltarIntent = new Intent(ResultadoAposentadoriaActivity.this, MainActivity.class);
                startActivity(voltarIntent);
                finish();
            }
        });
    }



}

