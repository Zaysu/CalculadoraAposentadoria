package com.jc.calculodeaposentadoria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private EditText cMontante, cAnosContribuicao, cTaxajuros;
    private Button btnCalcular;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cMontante = findViewById(R.id.c_montante);
        cAnosContribuicao = findViewById(R.id.anos_contribuicao);
        cTaxajuros = findViewById(R.id.c_taxa_Juros);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String montanteStr = cMontante.getText().toString();
                String cAnosContribuicaoStr = cAnosContribuicao.getText().toString();
                String taxaJurosStr = cTaxajuros.getText().toString();

                    int montante = Integer.parseInt(montanteStr);
                    int anosContribuicao = Integer.parseInt(cAnosContribuicaoStr);
                    double taxaJuros = Double.parseDouble(taxaJurosStr);

                    Intent intent = new Intent(MainActivity.this, ResultadoAposentadoriaActivity.class);
                    intent.putExtra("MONTANTE", montante);
                    intent.putExtra("ANOS_CONTRIBUICAO", anosContribuicao);
                    intent.putExtra("TAXA_JUROS", taxaJuros);
                    startActivity(intent);

            }
        });
    }
}
