package com.example.admin.w3d3desingpat;


import com.example.admin.w3d3desingpat.model.Batman;
import com.example.admin.w3d3desingpat.model.RelatedTopic;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by admin on 11/1/2016.
 */

public class BatmanRetrofit {

    private static final String BASE_URL = "https://api.duckduckgo.com/";

    public static void main(String[] args) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();


        Retrofit retrofit = BatmanRetrofitFactory.Factory.create();

        BatmanService batmanService = retrofit.create(BatmanService.class);
        Call<Batman> call = batmanService.retrievCharacters("batman characters");
        try {
            Batman batman = call.execute().body();
            for (RelatedTopic relatedTopic : batman.getRelatedTopics()){
                System.out.println(relatedTopic);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
