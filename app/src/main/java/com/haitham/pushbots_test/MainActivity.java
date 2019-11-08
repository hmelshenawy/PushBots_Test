package com.haitham.pushbots_test;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    String baseURL = "http://api.pushbots.com/2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        final restAPI restAPI = retrofit.create(restAPI.class);

        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {

                if (task.isSuccessful()) {

                    String token = task.getResult().getToken();

                    System.out.println(TAG + " current token is: " + token);

                    System.out.println("task id is: " + task.getResult().getId());

                    Call<Token> call = restAPI.postToken(new Token(token));

                    call.enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {

                            System.out.println("response:: " + response.body().token);
                            Log.d(TAG, "response:: " + response.body().token);

                        }

                        @Override
                        public void onFailure(Call<Token> call, Throwable t) {

                            System.out.println("throwable:: " + t.getMessage());

                        }
                    });
                }
            }
        });
    }
}
