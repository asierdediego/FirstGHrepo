package com.elorrieta.david.aplicaciondelitos;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */

public class DelitoLab {
    private static DelitoLab sDelitoLab;
    private List<Delito> mDelitos;
    private static boolean adim;

    public static boolean isAdim() {
        return adim;
    }

    public static void setAdim(boolean adim) {
        DelitoLab.adim = adim;
    }

    public static DelitoLab get(Context context1){

        if(sDelitoLab==null){
                    sDelitoLab= new DelitoLab(context1);
                }
        return sDelitoLab;

            }

private DelitoLab(Context context){

    mDelitos=new ArrayList<>();

    for(int x = 0 ; x< 100; x++){
        Delito delito= new Delito();

        delito.setmTitle("Delito  nº"+x);
        delito.setResuelto(x%2==0);

        mDelitos.add(delito);

    }



}

    public List getDelitos(){

        return mDelitos;

    }

    public Delito getDelito(UUID id){

        for(Delito delito : mDelitos){

            if(delito.getmId().equals(id)){

                return delito;
                }

             }

    return null;
    }

}
