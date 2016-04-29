package com.honaf.jpush;


import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by honaf on 16/2/29.
 * 极光推送
 */
public class JPushModule extends ReactContextBaseJavaModule
{
//    private MyReceiver myReceiver = null;
    public static ReactContext currentReactContext = null;
    public JPushModule(ReactApplicationContext reactContext) {
        super(reactContext);
        currentReactContext = reactContext;

//        MyReceiver.currentReactContext = reactContext;
    }
    @Override
    public String getName() {
        return "JPushModule";
    }

    @ReactMethod
    public void JPushInit(){
        JPushInterface.init(currentReactContext);
    }
    @ReactMethod
    public void JPushOpen() {
        Log.e("jpush_honaf==>", "jpushOpen开始");
//        myReceiver = new MyReceiver(currentReactContext);
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("cn.jpush.android.intent.REGISTRATION");
//        filter.addAction("cn.jpush.android.intent.UNREGISTRATION");
//        filter.addAction("cn.jpush.android.intent.MESSAGE_RECEIVED");
//        filter.addAction("cn.jpush.android.intent.NOTIFICATION_RECEIVED");
//        filter.addAction("cn.jpush.android.intent.NOTIFICATION_OPENED");
//        filter.addAction("cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK");
//        filter.addAction("cn.jpush.android.intent.CONNECTION");
//        filter.addCategory("com.pet");
//        currentReactContext.registerReceiver(myReceiver, filter);
//        JPushInterface.init(currentReactContext);
          JPushInterface.resumePush(currentReactContext);
        Log.e("jpush_honaf==>", "jpushOpen结束");
    }
    @ReactMethod
    public void JPushClose() {
//        if(myReceiver != null){
//            currentReactContext.unregisterReceiver(myReceiver);
//        }
        JPushInterface.stopPush(currentReactContext);
    }
    @ReactMethod
    public void JPushGetRegistrationId(){
        Log.e("jpush_honaf==>", "JPushGetRegistrationId开始");
        JPushInterface.getRegistrationID(currentReactContext);
        Log.e("jpush_honaf==>", "JPushGetRegistrationId结束");
    }

}
