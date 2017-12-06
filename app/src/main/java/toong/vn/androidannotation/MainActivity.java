package toong.vn.androidannotation;

import android.Manifest;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                call();
            }
        }).start();

//        LocationManager a = null;
//        a.requestLocationUpdates("", 0, 1, new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        });

        a("b");
        a("c");

//        copyFile("", "");

//        setTitle(1);
    }

    private void a(final @NonNull String a){
        new Thread() {
            @Override
            public void run() {
                call2(a);
                new A().execute();
            }
        }.start();
    }

    static class A extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            call();
            return null;
        }
    }

    public  void setTitle(@StringRes int resId) {  }

    @UiThread
    public static void call() {
    }

    @MainThread
    public void call2(String a) {
        Toast.makeText(this, "abc"+a, Toast.LENGTH_SHORT).show();
    }

    @RequiresPermission(allOf = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public static final void copyFile(String dest, String source) {

    }
}
