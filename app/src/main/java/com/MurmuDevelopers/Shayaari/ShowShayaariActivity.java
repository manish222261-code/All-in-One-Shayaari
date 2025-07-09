package com.MurmuDevelopers.Shayaari;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class ShowShayaariActivity extends AppCompatActivity {

    private String b = "";

    private TextView textview1;

    private final Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_shayaari);

        LinearLayout show_shayaari_bg = findViewById(R.id.show_shayaari_bg);
        CardView cardview1 = findViewById(R.id.cardview1);
        textview1 = findViewById(R.id.textview1);
        LinearLayout linear2 = findViewById(R.id.linear2);
        MaterialButton copy_btn = findViewById(R.id.copy_btn);
        MaterialButton share_btn = findViewById(R.id.share_btn);

        AppBarLayout _app_bar = findViewById(R.id._app_bar);
        CoordinatorLayout _coordinator = findViewById(R.id._coordinator);
        Toolbar _toolbar = findViewById(R.id._toolbar);
        setSupportActionBar(_toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                onBackPressed();
            }
        });


        setTitle("Shayaari");
        textview1.setText(getIntent().getStringExtra("key"));
        cardview1.setCardBackgroundColor(0xFFFFCDD2);
        copy_btn.setBackgroundColor(0xFFFFFFFF);
        share_btn.setBackgroundColor(0xFFFFFFFF);

        copy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                ((ClipboardManager) getSystemService(ShowShayaariActivity.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview1.getText().toString()));
                //SketchwareUtil.showMessage(getApplicationContext(), "copied to clipboard");
                Toast.makeText(ShowShayaariActivity.this, "copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                b = textview1.getText().toString();
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                //i.putExtra(android.content.Intent.EXTRA_SUBJECT, a);
                i.putExtra(android.content.Intent.EXTRA_TEXT, b);
                startActivity(Intent.createChooser(i,"Share Using"));
            }
        });
    }
}
