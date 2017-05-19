package com.elorrieta.david.aplicaciondelitos;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.List;
import java.util.UUID;


/**
 * Created by usuario on 12/02/2017.
 */

public class DelitoPagerActivity extends FragmentActivity {
    public static  final String ARG_DELITO_ID="com.elorrieta.david.aplicaciondelitos.DelitoFragment.delito_id";
    private ViewPager mViewPager;
    private List<Delito> mDelitos;

    public static Intent newIntent(Context pakageContest, UUID delitoId){
        Log.i("sss",delitoId+" <----dpa");
        Intent intent= new Intent(pakageContest,DelitoPagerActivity.class);
        intent.putExtra(ARG_DELITO_ID,delitoId);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delito_pager);

        UUID delitoId=(UUID)getIntent().getSerializableExtra(ARG_DELITO_ID);
Log.i("sss",delitoId+" <---cambiar");

        mDelitos= DelitoLab.get(this).getDelitos();

        mViewPager= (ViewPager) findViewById(R.id.activity_delito_pager_view_pager);
        android.support.v4.app.FragmentManager fragmentmanager= getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentmanager) {
            @Override
            public Fragment getItem(int position) {
                Log.i("sss","posicion--->"+position+"  "+mDelitos.get(position).getmId());

                return DelitoFragment.newInstance( mDelitos.get(position).getmId());
            }

            @Override
            public int getCount() {
                return mDelitos.size();
            }


        });
        for(int x =0; x< mDelitos.size();x++){

            if(mDelitos.get(x).getmId().equals(delitoId)){

                mViewPager.setCurrentItem(x);
                break;

            }

        }
    }
}
