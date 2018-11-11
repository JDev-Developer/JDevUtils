package it.jdev.jdevapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import it.jdev.jdevutils.common.JDialog;
import it.jdev.jdevutils.common.OnDialogCallback;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button testButton = findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JDialog.showAlertDialogWithMessage("Messaggio", "Positivo", "Negativo", TestActivity.this, new OnDialogCallback() {
                    @Override
                    public void onPositiveButton() {
                        Toast.makeText(TestActivity.this, "Ho cliccato sul pulsante positivo", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNegativeButton() {
                        Toast.makeText(TestActivity.this, "Ho cliccato sul pulsante negativo", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
