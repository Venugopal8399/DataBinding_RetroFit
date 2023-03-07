package com.example.databindingretrofit;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    // API's endpoints
    @GET("/users")
    Call<List<UserDetails>> getUsersList();

}