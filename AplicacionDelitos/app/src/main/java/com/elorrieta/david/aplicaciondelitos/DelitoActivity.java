package com.elorrieta.david.aplicaciondelitos;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 *
 */

public class DelitoActivity extends SingleFragmentActivity {
    public static  final String ARG_DELITO_ID="com.elorrieta.david.aplicaciondelitos.DelitoFragment.delito_id";


    @Override
    protected Fragment createFragment() {

        UUID delitoId=(UUID)getIntent().getSerializableExtra(ARG_DELITO_ID);

        return  DelitoFragment.newInstance(delitoId);
    }

    public static Intent newIntent(Context pakageContest,UUID delitoId){
        Intent intent= new Intent(pakageContest,DelitoActivity.class);
        intent.putExtra(ARG_DELITO_ID,delitoId);
        return intent;

    }

}
