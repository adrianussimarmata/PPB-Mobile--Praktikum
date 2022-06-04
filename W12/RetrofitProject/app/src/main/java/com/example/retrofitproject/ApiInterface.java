package com.example.retrofitproject;

import com.example.retrofitproject.GET.delayed_response.DelayedResponse;
import com.example.retrofitproject.GET.list_resource.ListResourceResponse;
import com.example.retrofitproject.GET.list_user.ListUserResponse;
import com.example.retrofitproject.GET.single_resource.SingleResourceResponse;
import com.example.retrofitproject.GET.single_resource_not_found.SingleResourceNotFoundResponse;
import com.example.retrofitproject.GET.single_user.SingleUserResponse;
import com.example.retrofitproject.GET.single_user_not_found.SingleUserNotFoundResponse;
import com.example.retrofitproject.PATCH.updatePatch.BodyUpdatePatch;
import com.example.retrofitproject.PATCH.updatePatch.UpdatePatchResponse;
import com.example.retrofitproject.POST.create.BodyCreate;
import com.example.retrofitproject.POST.create.CreateResponse;
import com.example.retrofitproject.POST.login_successful.BodyLogin;
import com.example.retrofitproject.POST.login_successful.LoginResponse;
import com.example.retrofitproject.POST.login_unsuccessful.BodyLoginUnsuccessful;
import com.example.retrofitproject.POST.login_unsuccessful.LoginUnsuccessfulResponse;
import com.example.retrofitproject.POST.register_successful.BodyRegister;
import com.example.retrofitproject.POST.register_successful.RegisterResponse;
import com.example.retrofitproject.POST.register_unsuccessful.BodyRegisterUnsuccessful;
import com.example.retrofitproject.POST.register_unsuccessful.RegisterUnsuccessfulResponse;
import com.example.retrofitproject.PUT.update.UpdateBody;
import com.example.retrofitproject.PUT.update.UpdateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {

    // GET List Users
    @GET("api/users?page=2")
    Call<ListUserResponse> getListUsers();

    // GET Single User
    @GET("api/users/2")
    Call<SingleUserResponse> getSingleUser();

    // GET Single User Not Found
    @GET("api/users/23")
    Call<SingleUserNotFoundResponse> getSingleUserNotFound();

    // GET List Resource
    @GET("api/unknown")
    Call<ListResourceResponse> getListResource();

    // GET Single Resource
    @GET("api/unknown/2")
    Call<SingleResourceResponse> getSingleResource();

    // GET Single Resource Not Found
    @GET("api/unknown/23")
    Call<SingleResourceNotFoundResponse> getSingleResourceNotFound();

    // GET Delayed Response
    @GET("api/users?delay=3")
    Call<DelayedResponse> getDelayedResponse();

    // POST Create
    @FormUrlEncoded
    @POST("api/users")
    Call<CreateResponse> getUserInformation(
            @Field("name") String name,
            @Field("job") String job
    );

    // POST Register Successful
    @POST("api/register")
    Call<RegisterResponse> postRegister(@Body BodyRegister bodyRegister);

    // POST Register Unsuccessful
    @POST("api/register")
    Call<RegisterUnsuccessfulResponse> postRegisterUnsuccessful(@Body BodyRegisterUnsuccessful bodyRegisterUnsuccessful);

    // POST Login Successful
    @POST("api/login")
    Call<LoginResponse> postLoginSuccessful(@Body BodyLogin bodyLogin);

    // POST Login Unsuccessful
    @POST("api/login")
    Call<LoginUnsuccessfulResponse> postLoginUnsuccessful(@Body BodyLoginUnsuccessful bodyLoginUnsuccessful);

    // PUT Update
    @PUT("api/users/2")
    Call<UpdateResponse> putUpdate(@Body UpdateBody updateBody);

    // PATCH Update
    @PATCH("api/users/2")
    Call<UpdatePatchResponse> patchUpdate(@Body BodyUpdatePatch bodyUpdatePatch);

    // DELETE
    @DELETE("api/users/2")
    Call<Void> deleteUser();

}
