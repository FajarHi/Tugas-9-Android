package com.dicoding.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class OriginService extends Service {
    public static final String ORIGIN_SERVICE = "OriginService";


    public OriginService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(ORIGIN_SERVICE,"OriginService di jalankan");
        ProcessAsync mProcessAsync = new ProcessAsync();
        mProcessAsync.execute();
        return START_STICKY;
    }

    private class ProcessAsync extends AsyncTask<Void, Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        protected  void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            Log.d( ORIGIN_SERVICE, "StopService");
            stopSelf();
        }
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(ORIGIN_SERVICE, "onDestroy()");
    }
}
