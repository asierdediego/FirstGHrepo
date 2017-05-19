package com.elorrieta.david.aplicaciondelitos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 *
 */

public class DelitoListFragment extends Fragment {

    private RecyclerView mDelitoRecyclerView;
    private DelitoAdapter mDelitoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_delito_list,container,false);
        mDelitoRecyclerView= (RecyclerView) v.findViewById(R.id.delito_recycler_view);
        mDelitoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){
    DelitoLab delitoLab= DelitoLab.get(getActivity());
    List<Delito> delitos = delitoLab.getDelitos();
        if(mDelitoAdapter==null) {
            mDelitoAdapter = new DelitoAdapter(delitos);
            mDelitoRecyclerView.setAdapter(mDelitoAdapter);
        }else{

mDelitoAdapter.notifyDataSetChanged();

        }

}
    private class DelitoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitulotextView;
        private TextView mFechatextView;
        private CheckBox mResueltoCheckBox;
        private Delito mDelito;





        public DelitoHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
       mTitulotextView= (TextView) itemView.findViewById(R.id.list_item_titulo_textview);
            mFechatextView= (TextView) itemView.findViewById(R.id.list_fecha_textview);
            mResueltoCheckBox= (CheckBox) itemView.findViewById(R.id.list_item_delito_resuelto_checkbox);
            mResueltoCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mResueltoCheckBox.setChecked(mResueltoCheckBox.isChecked());
                    mDelito.setResuelto(mResueltoCheckBox.isChecked());
                }
            });

        }

        public void bindDelito(Delito delito){

            mDelito=delito;
            Log.i("aaa","delito :"+delito.getmTitle());
            Log.i("aaa","mDelito :"+mDelito.getmTitle());

            mTitulotextView.setText(mDelito.getmTitle());
            mFechatextView.setText(mDelito.getFecha().toString());
            mResueltoCheckBox.setChecked(mDelito.isResuelto());
            if(DelitoLab.get(getActivity()).isAdim()){

                mTitulotextView.setEnabled(true);
                mFechatextView.setEnabled(true);
                mResueltoCheckBox.setEnabled(true);

            }else{
              //  mTitulotextView.setEnabled(false);
                mFechatextView.setEnabled(false);
                mResueltoCheckBox.setEnabled(false);

            }

        }


        @Override
        public void onClick(View v) {
         //   Toast.makeText(getActivity(),mDelito.getmTitle()+" ha sido clicado",Toast.LENGTH_SHORT).show();
            Log.i("sss",mDelito.getmId()+" <----dlf");
            Intent intent= DelitoPagerActivity.newIntent(getActivity(),mDelito.getmId());
            startActivity(intent);

        }
    }
    private class DelitoAdapter extends RecyclerView.Adapter<DelitoHolder>{
        private List<Delito> mDelitos;

        public DelitoAdapter(List<Delito>delitos){

            mDelitos=delitos;
        }

        @Override
        public DelitoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater=  LayoutInflater.from(getActivity());
            View v= layoutInflater.inflate(R.layout.list_item_delito,parent,false);// hay que mirarlo
            return new DelitoHolder(v);
        }

        @Override
        public void onBindViewHolder(DelitoHolder holder, int position) {
            Log.i("aaa",""+position);
            Delito delito=mDelitos.get(position);
            Log.i("aaa",delito.getmTitle());
            holder.bindDelito(delito);
        }

        @Override
        public int getItemCount() {

            Log.i("aaa",""+mDelitos.size());
            return mDelitos.size();
        }
    }

}
