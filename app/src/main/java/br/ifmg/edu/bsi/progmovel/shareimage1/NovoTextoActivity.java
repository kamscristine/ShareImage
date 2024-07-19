package br.ifmg.edu.bsi.progmovel.shareimage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NovoTextoActivity extends AppCompatActivity {

    public static String EXTRA_TEXTO_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual";
    public static String EXTRA_NOVO_TEXTO = "br.ifmg.edu.bsi.progmovel.shareimage1.novo_texto";

    public static String EXTRA_TEXTO_ATUAL2 = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual_2";
    public static String EXTRA_NOVO_TEXTO2 = "br.ifmg.edu.bsi.progmovel.shareimage1.novo_texto_2";

    public static String EXTRA_NOVA_FONTE_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_fonte";
    public static String EXTRA_NOVA_FONTE = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_fonte";

    public static String EXTRA_NOVA_FONTE_ATUAL2 = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_fonte_2";
    public static String EXTRA_NOVA_FONTE2 = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_fonte_2";

    private EditText etTexto;
    private EditText etFonte;
    private EditText etTexto2;
    private EditText etFonte2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_texto);

        etTexto = findViewById(R.id.etTexto);
        etFonte = findViewById(R.id.etFonte);

        etTexto2 = findViewById(R.id.etTexto2);
        etFonte2 = findViewById(R.id.etFonte2);

        Intent intent = getIntent();
        String textoAtual = intent.getStringExtra(EXTRA_TEXTO_ATUAL);
        float fonteAtual = intent.getFloatExtra(EXTRA_NOVA_FONTE_ATUAL, 64f);

        String textoAtual2 = intent.getStringExtra(EXTRA_TEXTO_ATUAL2);
        float fonteAtual2 = intent.getFloatExtra(EXTRA_NOVA_FONTE_ATUAL2, 64f);
        etTexto.setText(textoAtual);
        etFonte.setText(String.valueOf(fonteAtual));

        etTexto2.setText(textoAtual2);
        etFonte2.setText(String.valueOf(fonteAtual2));
    }

    public void enviarNovoTexto(View v) {
        String novoTexto = etTexto.getText().toString();
        String novaFonte = etFonte.getText().toString();

        String novoTexto2 = etTexto2.getText().toString();
        String novaFonte2 = etFonte2.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOVO_TEXTO, novoTexto);
        intent.putExtra(EXTRA_NOVA_FONTE, novaFonte);

        intent.putExtra(EXTRA_NOVO_TEXTO2, novoTexto2);
        intent.putExtra(EXTRA_NOVA_FONTE2, novaFonte2);
        setResult(RESULT_OK, intent);
        finish();
    }
}