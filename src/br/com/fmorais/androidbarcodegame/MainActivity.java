package br.com.fmorais.androidbarcodegame;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	// private SecureRandom random = new SecureRandom();
	// private String randString;
	private TextView tv2, tv4;
	private Button bt1, bt2, bt3;
	private String hex;
	private String contents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bt2 = (Button) findViewById(R.id.scan);
		bt2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// randString = new BigInteger(120, random).toString();
				// tv2 = (TextView) findViewById(R.id.tv2);
				// tv2.setText(randString);
				Display display = getWindowManager().getDefaultDisplay();
				int width;
				int height;
				if (android.os.Build.VERSION.SDK_INT >= 13) {
					Point size = new Point();
					display.getSize(size);
					width = size.x;
					height = size.y;
				} else {
					width = display.getWidth(); // deprecated
					height = display.getHeight(); // deprecated
				}
				Intent intent = new Intent(
						"br.com.fmorais.zxing.client.android.SCAN");

				if (display.getRotation() == (Surface.ROTATION_90)
						|| display.getRotation() == (Surface.ROTATION_270)) {
					intent.putExtra("SCAN_WIDTH", width - 20);
					intent.putExtra("SCAN_HEIGHT", height - 20);
				} else {
					intent.putExtra("SCAN_WIDTH", height - 20);
					intent.putExtra("SCAN_HEIGHT", width - 20);
				}
				startActivityForResult(intent, 0);

			}
		});
		// bt1 = (Button) findViewById(R.id.button1);
		// bt1.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// tv4 = (TextView) findViewById(R.id.tv4);
		// try {
		// MessageDigest md = MessageDigest.getInstance("MD5");
		// md.update(randString.getBytes());
		// byte[] digest = md.digest();
		// StringBuffer sb = new StringBuffer();
		// for (byte b : digest) {
		// sb.append(Integer.toHexString((int) (b & 0xff)));
		// }
		// hex = sb.toString();
		// tv4.setText(hex);
		// } catch (NoSuchAlgorithmException e) {
		// e.printStackTrace();
		// }
		//
		// }
		// });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				contents = intent.getStringExtra("SCAN_RESULT");
				// String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				tv2 = (TextView) findViewById(R.id.tv2);
				tv2.setText(contents);
				tv4 = (TextView) findViewById(R.id.tv4);
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(contents.getBytes());
					byte[] digest = md.digest();
					StringBuffer sb = new StringBuffer();
					for (byte b : digest) {
						sb.append(Integer.toHexString((int) (b & 0xff)));
					}
					hex = sb.toString();
					tv4.setText(hex);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				bt3 = (Button) findViewById(R.id.gerar);

				bt3.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent i = new Intent(MainActivity.this,
								StatsActivity.class);
						i.putExtra("HEX", hex);
						startActivity(i);

					}
				});
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
			}
		}
	}

}
