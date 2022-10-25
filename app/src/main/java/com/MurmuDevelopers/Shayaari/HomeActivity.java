package com.MurmuDevelopers.Shayaari;

import android.animation.*;
import android.app.*;
import android.content.*;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout First_Row;
	private LinearLayout Second_Row;
	private LinearLayout Third_Row;
	private ImageView imageview7;
	private CardView cardview1;
	private CardView cardview2;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private TextView textview2;
	private CardView cardview3;
	private CardView cardview4;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview4;
	private TextView textview4;
	private CardView cardview5;
	private CardView cardview6;
	private ImageView imageview5;
	private TextView textview5;
	private ImageView imageview6;
	private TextView textview6;
	private LinearLayout _drawer_drawer_bg;
	private LinearLayout _drawer_logo_bg;
	private LinearLayout _drawer_title_bg;
	private LinearLayout _drawer_bg_drawer;
	private LinearLayout _drawer_developer_bg;
	private ImageView _drawer_logo_img;
	private TextView _drawer_title_txt;
	private CardView _drawer_home;
	private CardView _drawer_share;
	private CardView _drawer_contact_developer;
	private CardView _drawer_setting;
	private ImageView _drawer_home_pic;
	private TextView _drawer_home_text;
	private ImageView _drawer_share_img;
	private TextView _drawer_share_txt;
	private ImageView _drawer_call_img;
	private TextView _drawer_call_txt;
	private ImageView _drawer_setting_img;
	private TextView _drawer_setting_txt;
	private TextView _drawer_developer_txt;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
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
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		First_Row = findViewById(R.id.First_Row);
		Second_Row = findViewById(R.id.Second_Row);
		Third_Row = findViewById(R.id.Third_Row);
		imageview7 = findViewById(R.id.imageview7);
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		cardview3 = findViewById(R.id.cardview3);
		cardview4 = findViewById(R.id.cardview4);
		imageview3 = findViewById(R.id.imageview3);
		textview3 = findViewById(R.id.textview3);
		imageview4 = findViewById(R.id.imageview4);
		textview4 = findViewById(R.id.textview4);
		cardview5 = findViewById(R.id.cardview5);
		cardview6 = findViewById(R.id.cardview6);
		imageview5 = findViewById(R.id.imageview5);
		textview5 = findViewById(R.id.textview5);
		imageview6 = findViewById(R.id.imageview6);
		textview6 = findViewById(R.id.textview6);
		_drawer_drawer_bg = _nav_view.findViewById(R.id.drawer_bg);
		_drawer_logo_bg = _nav_view.findViewById(R.id.logo_bg);
		_drawer_title_bg = _nav_view.findViewById(R.id.title_bg);
		_drawer_bg_drawer = _nav_view.findViewById(R.id.bg_drawer);
		_drawer_developer_bg = _nav_view.findViewById(R.id.developer_bg);
		_drawer_logo_img = _nav_view.findViewById(R.id.logo_img);
		_drawer_title_txt = _nav_view.findViewById(R.id.title_txt);
		_drawer_home = _nav_view.findViewById(R.id.home);
		_drawer_share = _nav_view.findViewById(R.id.share);
		_drawer_contact_developer = _nav_view.findViewById(R.id.contact_developer);
		_drawer_setting = _nav_view.findViewById(R.id.setting);
		_drawer_home_pic = _nav_view.findViewById(R.id.home_pic);
		_drawer_home_text = _nav_view.findViewById(R.id.home_text);
		_drawer_share_img = _nav_view.findViewById(R.id.share_img);
		_drawer_share_txt = _nav_view.findViewById(R.id.share_txt);
		_drawer_call_img = _nav_view.findViewById(R.id.call_img);
		_drawer_call_txt = _nav_view.findViewById(R.id.call_txt);
		_drawer_setting_img = _nav_view.findViewById(R.id.setting_img);
		_drawer_setting_txt = _nav_view.findViewById(R.id.setting_txt);
		_drawer_developer_txt = _nav_view.findViewById(R.id.developer_txt);
		
		cardview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AttitudeShayaariActivity.class);
				startActivity(intent);
			}
		});
		
		cardview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), FunnyShayaariActivity.class);
				startActivity(intent);
			}
		});
		
		cardview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), RomanticShayaariActivity.class);
				startActivity(intent);
			}
		});
		
		cardview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), LoveShayaariActivity.class);
				startActivity(intent);
			}
		});
		
		cardview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), DostiShayaariActivity.class);
				startActivity(intent);
			}
		});
		
		cardview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), GirlsShayaariActivity.class);
				startActivity(intent);
			}
		});
		
		_drawer_home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://t.me/allinoneshayaari"));
				startActivity(intent);
				SketchwareUtil.showMessage(getApplicationContext(), "Join our Telegram Group for Latest Update! ");
			}
		});
		
		_drawer_contact_developer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ContactDeveloperActivity.class);
				startActivity(intent);
			}
		});
		
		_drawer_setting.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "It will be available soon! ");
			}
		});
	}
	
	private void initializeLogic() {
		cardview1.setCardBackgroundColor(0xFFEAC9E8);
		cardview2.setCardBackgroundColor(0xFFF0F1A5);
		cardview3.setCardBackgroundColor(0xFFC1A4F8);
		cardview4.setCardBackgroundColor(0xFFEDC0D2);
		cardview5.setCardBackgroundColor(0xFFB6FAA5);
		cardview6.setCardBackgroundColor(0xFF43CBFF);
		_drawer_home.setCardBackgroundColor(0xFFFFCDD2);
		_drawer_share.setCardBackgroundColor(0xFFFFCDD2);
		_drawer_contact_developer.setCardBackgroundColor(0xFFFFCDD2);
		_drawer_setting.setCardBackgroundColor(0xFFFFCDD2);
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
}