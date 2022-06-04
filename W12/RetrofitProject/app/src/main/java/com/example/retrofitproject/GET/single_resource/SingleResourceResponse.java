package com.example.retrofitproject.GET.single_resource;

import com.google.gson.annotations.SerializedName;

public class SingleResourceResponse{

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
			"SingleResourceResponse{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}