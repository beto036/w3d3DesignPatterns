package com.example.admin.w3d3desingpat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.w3d3desingpat.model.Batman;
import com.example.admin.w3d3desingpat.model.RelatedTopic;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private TextView textView;
    private MySingleton mySingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.aMainTxt);

    }

    public void doMagic(View view) {
        mySingleton = MySingleton.getIntance();
        textView.setText(mySingleton.getDate().toString());

        Retrofit retrofit = BatmanRetrofitFactory.Factory.create();

        BatmanService batmanService = retrofit.create(BatmanService.class);
        Call<Batman> call = batmanService.retrievCharacters("batman characters");

        if(doSomething()) {
            call.enqueue(new Callback<Batman>() {
                @Override
                public void onResponse(Call<Batman> call, Response<Batman> response) {
                    Batman batman = response.body();
                    for (RelatedTopic relatedTopic : batman.getRelatedTopics()) {
                        Log.d(TAG, "onResponse: " + relatedTopic);
                    }
                }

                @Override
                public void onFailure(Call<Batman> call, Throwable t) {

                }
            });
        }else{
            Toast.makeText(this, "Check your WI-FI connection", Toast.LENGTH_LONG).show();
        }
    }

    public boolean doSomething() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.d(TAG, "checkInternet: " + "Connected to WIFI");
                return true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                Log.d(TAG, "checkInternet: " + "Connected to Mobile data");
                return true;
            }
        } else {
            Log.d(TAG, "checkInternet: " + "Not connected");
            return false;
        }
        return false;
    }

}
