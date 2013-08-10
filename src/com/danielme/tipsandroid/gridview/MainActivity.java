package com.danielme.tipsandroid.gridview;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.danieme.tipsandroid.gridview.R;

/**
 * 
 * @author danielme.com
 * 
 */
public class MainActivity extends Activity {

	ImageView imagenSeleccionada;
	Gallery gallery;

	@Override 
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Integer[] imagenes = { R.drawable.a, R.drawable.b, R.drawable.c,
				R.drawable.d, R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,
				R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o}; 
		
		GridView gridView = (GridView) findViewById(R.id.gridView);
		
		//el número de columnas se calculará en función del tamaño de pantalla y la posición
		boolean bigScreen = (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
		
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
		{
			if (bigScreen)
			{
				gridView.setNumColumns(4);
			}
			else
			{
				gridView.setNumColumns(3);
			}
		}
		else
		{
			if (bigScreen)
			{
				gridView.setNumColumns(3);
			}
			else
			{
				gridView.setNumColumns(2);
			}
		}
		 
		gridView.setAdapter(new GalleryAdapter(this, imagenes));
 
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Toast.makeText(MainActivity.this, ((TextView) view.findViewById(R.id.textView1)).getText() + " seleccionada", Toast.LENGTH_SHORT).show(); 
			}
		});
		
	} 
}