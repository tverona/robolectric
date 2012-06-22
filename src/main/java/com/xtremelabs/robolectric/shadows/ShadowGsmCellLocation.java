package com.xtremelabs.robolectric.shadows;

import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.RealObject;

@Implements(GsmCellLocation.class)
public class ShadowGsmCellLocation extends ShadowCellLocation {
    private int mLac;
    private int mCid;
    private int mPsc;

    /**
     * Empty constructor.  Initializes the LAC and CID to -1.
     */
    public void __constructor__() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
    }

    /**
     * Initialize the object from a bundle.
     */
    public void __constructor__(Bundle bundle) {
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
    }

    /**
     * @return gsm location area code, -1 if unknown, 0xffff max legal value
     */
    @Implementation
    public int getLac() {
        return mLac;
    }

    /**
     * @return gsm cell id, -1 if unknown, 0xffff max legal value
     */
    @Implementation
    public int getCid() {
        return mCid;
    }

    /**
     * On a UMTS network, returns the primary scrambling code of the serving
     * cell.
     *
     * @return primary scrambling code for UMTS, -1 if unknown or GSM
     */
    @Implementation
    public int getPsc() {
        return mPsc;
    }

    /**
     * Invalidate this object.  The location area code and the cell id are set to -1.
     */
    @Implementation
    public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
    }

    /**
     * Set the location area code and the cell id.
     */
    @Implementation
    public void setLacAndCid(int lac, int cid) {
        mLac = lac;
        mCid = cid;
    }

    /**
     * Set the primary scrambling code.
     * @hide
     */
    @Implementation
    public void setPsc(int psc) {
        mPsc = psc;
    }

    @Override
    @Implementation
    public int hashCode() {
        return mLac ^ mCid;
    }

    @Override
    @Implementation
    public boolean equals(Object o) {
        GsmCellLocation s;

        try {
            s = (GsmCellLocation)o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (o == null) {
            return false;
        }

        return equalsHandlesNulls(mLac, s.getLac()) && equalsHandlesNulls(mCid, s.getCid())
            && equalsHandlesNulls(mPsc, s.getPsc());
    }

    @Override
    @Implementation
    public String toString() {
        return "["+ mLac + "," + mCid + "," + mPsc + "]";
    }

    /**
     * Test whether two objects hold the same data values or both are null
     *
     * @param a first obj
     * @param b second obj
     * @return true if two objects equal or both are null
     */
    @Implementation
    private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    /**
     * Set intent notifier Bundle based on service state
     *
     * @param m intent notifier Bundle
     */
    @Implementation
    public void fillInNotifierBundle(Bundle m) {
        m.putInt("lac", mLac);
        m.putInt("cid", mCid);
        m.putInt("psc", mPsc);
    }

    /**
     * @hide
     */
    @Implementation
    public boolean isEmpty() {
        return (mLac == -1 && mCid == -1 && mPsc == -1);
    }
}
