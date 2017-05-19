package com.elorrieta.david.aplicaciondelitos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class Indice extends FragmentActivity
{
	private Button mAdminButton;
	private Button mClienteButton;
	private Button mIrListButton;
	private boolean admin;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_indice);

		mAdminButton = (Button) findViewById(R.id.admin);
		mClienteButton = (Button) findViewById(R.id.Cliente);


		mAdminButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				admin = true;
				DelitoLab.get(getBaseContext()).setAdim(admin);
				Intent i = DelitoListActivity.newIntent(getBaseContext());
				startActivity(i);
			}
		});
		mClienteButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				admin = false;
				DelitoLab.get(getBaseContext()).setAdim(admin);
				Intent i = DelitoListActivity.newIntent(getBaseContext());
				startActivity(i);
			}
		});


	}

}
