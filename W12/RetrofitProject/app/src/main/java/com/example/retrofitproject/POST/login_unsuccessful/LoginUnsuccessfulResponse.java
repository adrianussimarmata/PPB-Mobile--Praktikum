package com.example.retrofitproject.POST.login_unsuccessful;

import com.google.gson.annotations.SerializedName;

public class LoginUnsuccessfulResponse{

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
			"LoginUnsuccessfulResponse{" + 
			"error = '" + error + '\'' + 
			"}";
		}
}