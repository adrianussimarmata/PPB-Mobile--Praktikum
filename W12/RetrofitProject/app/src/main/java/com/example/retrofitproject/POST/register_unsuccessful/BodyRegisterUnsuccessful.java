package com.example.retrofitproject.POST.register_unsuccessful;

import com.google.gson.annotations.SerializedName;

public class BodyRegisterUnsuccessful{

	@SerializedName("email")
	private String email;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"BodyRegisterUnsuccessful{" + 
			"email = '" + email + '\'' + 
			"}";
		}
}