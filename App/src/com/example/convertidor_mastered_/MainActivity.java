package com.example.convertidor_mastered_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText input;
	private TextView info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		input = (EditText)findViewById(R.id.et_inputUser);
		info = (TextView)findViewById(R.id.tv_infoMain);
		info.requestFocus();
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void convertirKms(View v)
	{
		lanzarIntKmToM();
	}
	
	public void convertirGrados(View v)
	{
		lanzarIntCtoF();
	}
	
	private void lanzarIntKmToM()
	{
		Intent intencion = new Intent(this, ActivityResultado.class);
		intencion.putExtra("input", Double.parseDouble(input.getText().toString()));
		startActivity(intencion);		
	
	}
	
	private void lanzarIntCtoF()
	{
		Intent intencion = new Intent(this, ActivityResultado2.class);
		intencion.putExtra("input", Double.parseDouble(input.getText().toString()));
		startActivity(intencion);		
	
	}
}
