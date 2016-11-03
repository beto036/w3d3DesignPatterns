package com.example.admin.w3d3desingpat;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 11/2/2016.
 */

public class BatmanRetrofitFactory {
    private static final String BASE_URL = "https://api.duckduckgo.com/";

    public static class Factory{
        public static Retrofit create() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

}
