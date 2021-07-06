package com.scotcro.songsapi.domain;

public class Song {

	private String id;
	private String title;
	private Integer duration;
	private Integer yearPublished;
	private String artistName;
	private String artistId;

	public void setId(String idIn) {
		this.id = idIn;
	}

	public void setTitle(String titleIn) {
		this.title = titleIn;
	}

	public void setDuration(Integer durationIn) {
		this.duration = durationIn;
	}

	public void setYearPublished(Integer yearPublishedIn) {
		this.yearPublished = yearPublishedIn;
	}

	public void setArtistName(String artistNameIn) {
		this.artistName = artistNameIn;
	}

	public void setArtistId(String artistIdIn) {
		this.artistId = artistIdIn;
	}

	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public Integer getYearPublished() {
		return this.yearPublished;
	}

	public String getArtistName() {
		return this.artistName;
	}

	public String getArtistId() {
		return this.artistId;
	}
}