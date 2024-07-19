package br.ifmg.edu.bsi.progmovel.shareimage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewCorActivity extends AppCompatActivity {
    public static String EXTRA_COR_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.cor_atual";
    public static String EXTRA_NOVA_COR = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_cor";

    public static String EXTRA_COR_ATUAL2 = "br.ifmg.edu.bsi.progmovel.shareimage1.cor_atual2";
    public static String EXTRA_NOVA_COR2 = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_cor2";
    private EditText etCor;
    private EditText etCor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cor);

        etCor = findViewById(R.id.etCor);
        etCor2 = findViewById(R.id.etCor2);

        Intent intent = getIntent();

        String corAtual = intent.getStringExtra(EXTRA_COR_ATUAL);
        String corAtual2 = intent.getStringExtra(EXTRA_COR_ATUAL2);

        etCor.setText(corAtual);
        etCor2.setText(corAtual2);
    }
    public void enviarNovaCor(View v) {
        String novaCor = etCor.getText().toString();
        String novaCor2 = etCor2.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOVA_COR, novaCor);
        intent.putExtra(EXTRA_NOVA_COR2, novaCor2);

        setResult(RESULT_OK, intent);
        finish();
    }

}