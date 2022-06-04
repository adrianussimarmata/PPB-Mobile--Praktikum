package com.example.retrofitproject.PUT.update;

import com.google.gson.annotations.SerializedName;

public class UpdateBody{

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setJob(String job){
		this.job = job;
	}

	public String getJob(){
		return job;
	}

	@Override
 	public String toString(){
		return 
			"UpdateBody{" + 
			"name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			"}";
		}
}