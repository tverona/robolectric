package com.xtremelabs.robolectric.shadows;

import android.os.Bundle;
import android.telephony.cdma.CdmaCellLocation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.RealObject;

@Implements(CdmaCellLocation.class)
public class ShadowCdmaCellLocation extends ShadowCellLocation {
    private int mBaseStationId = -1;

    /**
     * @hide
     */
    public final static int INVALID_LAT_LONG = Integer.MAX_VALUE;

    /**
     * Latitude is a decimal number as specified in 3GPP2 C.S0005-A v6.0.
     * It is represented in units of 0.25 seconds and ranges from -1296000
     * to 1296000, both values inclusive (corresponding to a range of -90
     * to +90 degrees). Integer.MAX_VALUE is considered invalid value.
     */
    private int mBaseStationLatitude = INVALID_LAT_LONG;

    /**
     * Longitude is a decimal number as specified in 3GPP2 C.S0005-A v6.0.
     * It is represented in units of 0.25 seconds and ranges from -2592000
     * to 2592000, both values inclusive (corresponding to a range of -180
     * to +180 degrees). Integer.MAX_VALUE is considered invalid value.
     */
    private int mBaseStationLongitude = INVALID_LAT_LONG;

    private int mSystemId = -1;
    private int mNetworkId = -1;

    /**
     * Empty constructor.
     * Initializes the BID, SID, NID and base station latitude and longitude
     * to invalid values.
     */
    public void __constructor__() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = INVALID_LAT_LONG;
        this.mBaseStationLongitude = INVALID_LAT_LONG;
        this.mSystemId = -1;
        this.mNetworkId = -1;
    }

    /**
     * Initialize the object from a bundle.
     */
    public void __constructor__(Bundle bundle) {
        this.mBaseStationId = bundle.getInt("baseStationId", mBaseStationId);
        this.mBaseStationLatitude = bundle.getInt("baseStationLatitude", mBaseStationLatitude);
        this.mBaseStationLongitude = bundle.getInt("baseStationLongitude", mBaseStationLongitude);
        this.mSystemId = bundle.getInt("systemId", mSystemId);
        this.mNetworkId = bundle.getInt("networkId", mNetworkId);
    }

    /**
     * @return cdma base station identification number, -1 if unknown
     */
    @Implementation
    public int getBaseStationId() {
        return this.mBaseStationId;
    }

    /**
     * @return cdma base station latitude, Integer.MAX_VALUE if unknown
     */
    @Implementation
    public int getBaseStationLatitude() {
        return this.mBaseStationLatitude;
    }

    /**
     * @return cdma base station longitude, Integer.MAX_VALUE if unknown
     */
    @Implementation
    public int getBaseStationLongitude() {
        return this.mBaseStationLongitude;
    }

    /**
     * @return cdma system identification number, -1 if unknown
     */
    @Implementation
    public int getSystemId() {
        return this.mSystemId;
    }

    /**
     * @return cdma network identification number, -1 if unknown
     */
    @Implementation
    public int getNetworkId() {
        return this.mNetworkId;
    }

    /**
     * Invalidate this object.  The cell location data is set to invalid values.
     */
    @Implementation
    public void setStateInvalid() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = INVALID_LAT_LONG;
        this.mBaseStationLongitude = INVALID_LAT_LONG;
        this.mSystemId = -1;
        this.mNetworkId = -1;
    }

    /**
     * Set the cell location data.
     */
    @Implementation
     public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude) {
         // The following values have to be written in the correct sequence
         this.mBaseStationId = baseStationId;
         this.mBaseStationLatitude = baseStationLatitude;   //values[2];
         this.mBaseStationLongitude = baseStationLongitude; //values[3];
    }

    /**
     * Set the cell location data.
     */
    @Implementation
     public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude, int systemId, int networkId) {
         // The following values have to be written in the correct sequence
         this.mBaseStationId = baseStationId;
         this.mBaseStationLatitude = baseStationLatitude;   //values[2];
         this.mBaseStationLongitude = baseStationLongitude; //values[3];
         this.mSystemId = systemId;
         this.mNetworkId = networkId;
    }

    @Override
    @Implementation
    public int hashCode() {
        return this.mBaseStationId ^ this.mBaseStationLatitude ^ this.mBaseStationLongitude
                ^ this.mSystemId ^ this.mNetworkId;
    }

    @Override
    @Implementation
    public boolean equals(Object o) {
        CdmaCellLocation s;

        try {
            s = (CdmaCellLocation)o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (o == null) {
            return false;
        }

        return (equalsHandlesNulls(this.mBaseStationId, s.getBaseStationId()) &&
                equalsHandlesNulls(this.mBaseStationLatitude, s.getBaseStationLatitude()) &&
                equalsHandlesNulls(this.mBaseStationLongitude, s.getBaseStationLongitude()) &&
                equalsHandlesNulls(this.mSystemId, s.getSystemId()) &&
                equalsHandlesNulls(this.mNetworkId, s.getNetworkId())
        );
    }

    @Override
    @Implementation
    public String toString() {
        return "[" + this.mBaseStationId + ","
                   + this.mBaseStationLatitude + ","
                   + this.mBaseStationLongitude + ","
                   + this.mSystemId + ","
                   + this.mNetworkId + "]";
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
     * Fill the cell location data into the intent notifier Bundle based on service state
     *
     * @param bundleToFill intent notifier Bundle
     */
    @Implementation
    public void fillInNotifierBundle(Bundle bundleToFill) {
        bundleToFill.putInt("baseStationId", this.mBaseStationId);
        bundleToFill.putInt("baseStationLatitude", this.mBaseStationLatitude);
        bundleToFill.putInt("baseStationLongitude", this.mBaseStationLongitude);
        bundleToFill.putInt("systemId", this.mSystemId);
        bundleToFill.putInt("networkId", this.mNetworkId);
    }

    /**
     * @hide
     */
    @Implementation
    public boolean isEmpty() {
        return (this.mBaseStationId == -1 &&
                this.mBaseStationLatitude == INVALID_LAT_LONG &&
                this.mBaseStationLongitude == INVALID_LAT_LONG &&
                this.mSystemId == -1 &&
                this.mNetworkId == -1);
    }
}

