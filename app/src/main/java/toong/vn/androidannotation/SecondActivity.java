package toong.vn.androidannotation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.AnyThread;
import android.support.annotation.MainThread;
import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    @MainThread
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getData();
    }

    @AnyThread
    private void getData() {
        new Thread(new Runnable() {
            @WorkerThread // MUST DEFINE THREAD HERE
            @Override
            public void run() {
                updateUI(); // annotation error here
            }
        }).start();
    }

    @MainThread
    void updateUI() {

    }

    class A extends AsyncTask<Void, Void, Void> {
        @WorkerThread // MUST DEFINE THREAD HERE
        @Override
        protected Void doInBackground(Void... voids) {
            updateUI(); // annotation error here
            return null;
        }
    }
}
