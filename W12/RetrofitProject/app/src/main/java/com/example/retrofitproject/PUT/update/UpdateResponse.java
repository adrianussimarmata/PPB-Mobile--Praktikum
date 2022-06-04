package com.example.retrofitproject.PUT.update;

import com.google.gson.annotations.SerializedName;

public class UpdateResponse{

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	@SerializedName("updatedAt")
	private String updatedAt;

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

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	@Override
 	public String toString(){
		return 
			"UpdateResponse{" + 
			"name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}