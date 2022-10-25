package com.MurmuDevelopers.Shayaari;

import android.animation.*;
import android.animation.Animator;
import android.animation.ObjectAnimator;
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
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private LinearLayout Background;
	private LinearLayout Linear_Background;
	private LinearLayout Linear_Bottom;
	private ImageView App_Logo;
	private TextView App_Version;
	
	private ObjectAnimator Animator = new ObjectAnimator();
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		Background = findViewById(R.id.Background);
		Linear_Background = findViewById(R.id.Linear_Background);
		Linear_Bottom = findViewById(R.id.Linear_Bottom);
		App_Logo = findViewById(R.id.App_Logo);
		App_Version = findViewById(R.id.App_Version);
		
		Animator.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator _param1) {
				intent.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(intent);
				finishAffinity();
			}
			
			@Override
			public void onAnimationCancel(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animator _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =MainActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFCDD2);
		}
		Animator.setTarget(App_Logo);
		Animator.setPropertyName("alpha");
		Animator.setFloatValues((float)(0), (float)(1));
		Animator.setRepeatMode(ValueAnimator.REVERSE);
		Animator.setRepeatCount((int)(1));
		Animator.setDuration((int)(2000));
		Animator.start();
	}
	
}