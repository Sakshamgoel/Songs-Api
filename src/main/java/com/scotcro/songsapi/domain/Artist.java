package com.scotcro.songsapi.domain;

import java.util.List;


public class Artist {

	private String id;
	private String name;
	private Integer lastPublished;
	private Integer birthDate;
	private List<Song> songs;

	public void setId(String idIn) {
		this.id = idIn;
	}

	public void setName(String nameIn) {
		this.name = nameIn;
	}	

	public void setLastPublished(Integer lastPublishedIn) {
		this.lastPublished = lastPublishedIn;
	}	

	public void setBirthDate(Integer birthDateIn) {
		this.birthDate = birthDateIn;
	}	

	public void setSongs(List<Song> songsIn) {
		this.songs = songsIn;
	}	

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}	

	public Integer getLastPublished() {
		return this.lastPublished;
	}	

	public Integer getBirthDate() {
		return this.birthDate;
	}	

	public List<Song> getSongs() {
		return this.songs;
	}	
}