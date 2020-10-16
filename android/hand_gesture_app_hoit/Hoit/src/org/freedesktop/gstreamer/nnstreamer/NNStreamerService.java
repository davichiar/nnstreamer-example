package org.freedesktop.gstreamer.nnstreamer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class NNStreamerService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        // Service Start
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Service Call
        Toast.makeText(getApplicationContext(), "시작", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // Service Destroy
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "종료", Toast.LENGTH_SHORT).show();
    }
}
