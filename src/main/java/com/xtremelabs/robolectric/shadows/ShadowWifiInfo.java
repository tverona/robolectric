package com.xtremelabs.robolectric.shadows;

import android.net.wifi.WifiInfo;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

@Implements(WifiInfo.class)
public class ShadowWifiInfo {

    private String macAddress;
    private String BSSID;
    private String SSID;
    
    @Implementation
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String newMacAddress) {
        macAddress = newMacAddress;
    }

    @Implementation
    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String newBSSID) {
        BSSID = newBSSID;
    }

    @Implementation
    public String getSSID() {
        return SSID;
    }

    public void setSSID(String newSSID) {
        SSID = newSSID;
    }
}
