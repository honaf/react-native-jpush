package com.honaf.jpush.optimize;

import android.os.Bundle;

import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by wen on 16/4/20.
 */
public class RnInfo extends AbsRnInfo {

    private String mModuleName;
    private Bundle mLaunchOptions;

    public RnInfo(String moduleName) {
        this.mModuleName = moduleName;
    }

    public RnInfo(String moduleName, Bundle launchOptions) {
        this.mModuleName = moduleName;
        this.mLaunchOptions = launchOptions;
    }

    @Nullable
    @Override
    public Bundle getLaunchOptions() {
        return mLaunchOptions;
    }

    @Override
    public String getMainComponentName() {
        return mModuleName;
    }

    @Override
    public String getJSMainModuleName() {
        return "Pet";
    }

    @Nullable
    @Override
    public String getJSBundleFile() {
        return "index.jsbundle";
    }

    @Override
    public boolean getUseDeveloperSupport() {
        return true;
    }

    @Override
    public List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(new MainReactPackage());
    }

    @Override
    public String getBundleAssetName() {
        return super.getBundleAssetName();
    }
}
