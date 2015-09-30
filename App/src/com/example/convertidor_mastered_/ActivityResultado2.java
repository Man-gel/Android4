package com.example.convertidor_mastered_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ActivityResultado2 extends Activity {
	private TextView resGrados;
	private Double input;
	private boolean reset = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado2);
		resGrados = (TextView)findViewById(R.id.tv_resFar);
		obtenerYcalcularValor();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_resultado2, menu);
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
	
	public void reset(View v)
	{
		resGrados.setText("0 °F");
		enviarReset();
	}
	
	private void enviarReset()
	{
		Intent intencion = new Intent(this, MainActivity.class);
		intencion.putExtra("reset", reset);
		startActivity(intencion);
	}
	private void obtenerYcalcularValor()
	{
		Bundle recibido = getIntent().getExtras();
		input = recibido.getDouble("input");
		String res = ( (input * 1.8) + 32) + " °F";
		resGrados.setText(res);
	}
}
