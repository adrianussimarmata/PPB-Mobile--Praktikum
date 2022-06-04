package com.example.retrofitproject.POST.register_successful;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("id")
	private int id;

	@SerializedName("token")
	private String token;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"RegisterResponse{" + 
			"id = '" + id + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}