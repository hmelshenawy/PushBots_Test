package com.haitham.pushbots_test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface restAPI {

    @Headers({"x-pushbots-appid: 5d258e58b7941208c73fcfb7", "Content-Type: application/json"})
    @POST("subscriptions")
    Call<Token> postToken(@Body Token token);

}
