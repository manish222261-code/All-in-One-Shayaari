package com.MurmuDevelopers.Shayaari;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class ShowShayaariActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String b = "";
	
	private LinearLayout show_shayaari_bg;
	private CardView cardview1;
	private TextView textview1;
	private LinearLayout linear2;
	private MaterialButton copy_btn;
	private MaterialButton share_btn;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.show_shayaari);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		show_shayaari_bg = findViewById(R.id.show_shayaari_bg);
		cardview1 = findViewById(R.id.cardview1);
		textview1 = findViewById(R.id.textview1);
		linear2 = findViewById(R.id.linear2);
		copy_btn = findViewById(R.id.copy_btn);
		share_btn = findViewById(R.id.share_btn);
		
		copy_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview1.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "copied to clipboard");
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
	
	private void initializeLogic() {
		setTitle("Shayaari");
		textview1.setText(getIntent().getStringExtra("key"));
		cardview1.setCardBackgroundColor(0xFFFFCDD2);
		copy_btn.setBackgroundColor(0xFFFFFFFF);
		share_btn.setBackgroundColor(0xFFFFFFFF);
	}
	
}