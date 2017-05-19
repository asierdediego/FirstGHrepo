package com.elorrieta.david.aplicaciondelitos;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 *
 */

public class DelitoListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DelitoListFragment();
    }
    public static Intent newIntent(Context pakageContest){

        return new Intent(pakageContest,DelitoListActivity.class);

    }
}
