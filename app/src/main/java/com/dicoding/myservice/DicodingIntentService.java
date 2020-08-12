package com.dicoding.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class DicodingIntentService extends IntentService {
    public static String EXTRA_DURATION ="extra duration";
    public static final  String TAG = "DicodingIntentService";
    public DicodingIntentService(){
        super("DicodingIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent()");
        if (intent != null) {
        int duration = intent.getIntExtra(EXTRA_DURATION, 0);
        try {
            Thread.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        }
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}