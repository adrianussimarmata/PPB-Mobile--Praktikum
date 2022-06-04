package com.example.retrofitproject.POST.register_unsuccessful;

import com.google.gson.annotations.SerializedName;

public class RegisterUnsuccessfulResponse{

	@SerializedName("error")
	private String error;

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"RegisterUnsuccessfulResponse{" + 
			"error = '" + error + '\'' + 
			"}";
		}
}