package com.honaf.jpush.optimize;

import android.os.Bundle;

import com.facebook.react.ReactPackage;

import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by wen on 16/4/20.
 */
public class AbsRnInfo {

    @Nullable
    public Bundle getLaunchOptions() {
        return null;
    }

    public String getMainComponentName() {
        return null;
    }

    public String getJSMainModuleName() {
        return null;
    }

    @Nullable
    public String getJSBundleFile() {
        return null;
    }

    public boolean getUseDeveloperSupport() {
        return true;
    }

    public List<ReactPackage> getPackages() {
        return null;
    }

    public String getBundleAssetName() {
        return null;
    }
    
}
