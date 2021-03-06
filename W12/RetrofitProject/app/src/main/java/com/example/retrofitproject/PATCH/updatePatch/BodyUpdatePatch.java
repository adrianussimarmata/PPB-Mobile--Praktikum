package com.example.retrofitproject.PATCH.updatePatch;

import com.google.gson.annotations.SerializedName;

public class BodyUpdatePatch{

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
			"BodyUpdatePatch{" + 
			"name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			"}";
		}
}