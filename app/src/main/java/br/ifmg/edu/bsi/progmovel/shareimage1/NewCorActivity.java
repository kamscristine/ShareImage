package br.ifmg.edu.bsi.progmovel.shareimage1;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewCorActivity extends AppCompatActivity {
    public static String EXTRA_COR_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.cor_atual";
    public static String EXTRA_NOVA_COR = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_cor";

    private EditText etCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_cor);

        etCor = findViewById(R.id.etCor);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}