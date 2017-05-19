package com.elorrieta.david.aplicaciondelitos;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.UUID;

public class Indice extends FragmentActivity {
private Button mAdminButton;
    private Button mClienteButton;
    private Button mIrListButton;
    private boolean admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indice);

        mAdminButton= (Button) findViewById(R.id.admin);
        mClienteButton= (Button) findViewById(R.id.Cliente);


        mAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               admin=true;
                DelitoLab.get(getBaseContext()).setAdim(admin);
                Intent i= DelitoListActivity.newIntent(getBaseContext());
                startActivity(i);
            }
        });
        mClienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin=false;
                DelitoLab.get(getBaseContext()).setAdim(admin);
                Intent i= DelitoListActivity.newIntent(getBaseContext());
                startActivity(i);
            }
        });




    }

}
