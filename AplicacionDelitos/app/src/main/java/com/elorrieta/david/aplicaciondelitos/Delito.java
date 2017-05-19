package com.elorrieta.david.aplicaciondelitos;

import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 31/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class Delito {

    private UUID mId;
    private String mTitle;
    private boolean mResuelto;
    private Date mFecha;

    Delito(){
          mId= UUID.randomUUID();
            mFecha=new Date();

    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getFecha() {
        return mFecha;
    }

    public void setFecha(Date fecha) {
        mFecha = fecha;
    }

    public boolean isResuelto() {
        return mResuelto;
    }

    public void setResuelto(boolean resuelto) {
        mResuelto = resuelto;
    }
}
