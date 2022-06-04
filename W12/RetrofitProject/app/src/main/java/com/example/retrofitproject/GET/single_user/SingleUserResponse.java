package com.example.retrofitproject.GET.single_user;

import com.google.gson.annotations.SerializedName;

public class SingleUserResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("support")
	private Support support;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setSupport(Support support){
		this.support = support;
	}

	public Support getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"SingleUserResponse{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}