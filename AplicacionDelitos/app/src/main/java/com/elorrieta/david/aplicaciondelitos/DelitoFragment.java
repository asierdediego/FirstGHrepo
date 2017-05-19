package com.elorrieta.david.aplicaciondelitos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by admin on 01/02/2017.
 */

public class DelitoFragment extends Fragment {


    private static  final String ARG_DELITO_ID="com.elorrieta.david.aplicaciondelitos.DelitoFragment.delito_id";
    private Delito mDelito;
    private EditText mTitulo;
    private Button mFechaButton;
    private CheckBox mResueltoCheckbox;
    private static UUID mDelitoId;
    private static UUID mDelitoId2;


    public static DelitoFragment newInstance(UUID delitoID){
        Bundle args = new Bundle();
        mDelitoId2=delitoID;
        args.putSerializable(ARG_DELITO_ID,delitoID);
        DelitoFragment fragment= new DelitoFragment();
        fragment.setArguments(args);
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("sss","Oncreate");
        UUID delitoId;
        super.onCreate(savedInstanceState);
        mDelito= new Delito();

        if(mDelitoId==(UUID) getActivity().getIntent().getSerializableExtra(ARG_DELITO_ID)){
           delitoId=mDelitoId2;


        }else{

            delitoId=(UUID) getActivity().getIntent().getSerializableExtra(ARG_DELITO_ID);
            mDelitoId=delitoId;
        }

        Log.i("sss",delitoId+" aaaaa");
        mDelito=DelitoLab.get(getActivity()).getDelito(delitoId);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.delito_fragment,container,false);
        Log.i("sss","OncreateView");

        mTitulo = (EditText) v.findViewById(R.id.titulo_delito);
        Log.i("sss",mDelito.getmId()+"    ccc");
        mTitulo.setText(mDelito.getmTitle());
        mTitulo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mDelito.setmTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        mFechaButton= (Button) v.findViewById(R.id.fecha_delito);
        mFechaButton.setText(mDelito.getFecha().toString());
        mFechaButton.setEnabled(false);

        mResueltoCheckbox= (CheckBox) v.findViewById(R.id.delito_resuelto);
         mResueltoCheckbox.setChecked(mDelito.isResuelto());
        mResueltoCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mDelito.setResuelto(isChecked);
            }
        });
        if(DelitoLab.get(getActivity()).isAdim()){
            mFechaButton.setEnabled(true);
            mTitulo.setEnabled(true);
            mResueltoCheckbox.setEnabled(true);
        }
        else{
            mFechaButton.setEnabled(false);
            mTitulo.setEnabled(false);
            mResueltoCheckbox.setEnabled(false);
        }
        return v;
    }
}
