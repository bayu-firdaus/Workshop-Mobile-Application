package com.ofeq.AplikasiRetrovolley.retrofit;

import com.ofeq.AplikasiRetrovolley.Request;
import com.ofeq.AplikasiRetrovolley.User;
import com.ofeq.AplikasiRetrovolley.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MethodHTTP {

    //get all user
    @GET("VOLLEY/User_Registration.php")
    Call<UserResponse> getUser();

    //get specific using username and password
    @GET("VOLLEY/Login.php")
    Call<UserResponse> login(@Query("email") String email, @Query("password") String password);

    //get specific using id
    @GET("VOLLEY/User.php")
    Call<UserResponse> getUserByID(@Query("id") int id);

    //submit user registration
    @POST("VOLLEY/User_Registration.php")
    Call<Request> sendUser(@Body User user);

    //update user
    @POST("VOLLEY/User.php")
    Call<Request> updateUser(@Body User user);

    @DELETE("VOLLEY/User.php")
    Call<Request> deleteUser(@Query("id") int id);
}
