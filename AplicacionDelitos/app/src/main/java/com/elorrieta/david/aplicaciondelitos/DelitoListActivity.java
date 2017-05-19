package com.elorrieta.david.aplicaciondelitos;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by usuario on 06/02/2017.
 */

public class DelitoListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DelitoListFragment();
    }
    public static Intent newIntent(Context pakageContest){

        Intent intent= new Intent(pakageContest,DelitoListActivity.class);

        return intent;

    }
}
