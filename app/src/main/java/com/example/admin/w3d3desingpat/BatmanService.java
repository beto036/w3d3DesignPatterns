package com.example.admin.w3d3desingpat;


import com.example.admin.w3d3desingpat.model.Batman;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 11/1/2016.
 */

public interface BatmanService{
    @GET("?format=json")
    Call<Batman> retrievCharacters(@Query("q") String q);
}
