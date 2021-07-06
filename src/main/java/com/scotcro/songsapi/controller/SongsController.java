package com.scotcro.songsapi.controller;

import java.util.concurrent.atomic.AtomicLong;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.scotcro.songsapi.domain.Song;
import com.scotcro.songsapi.service.SongService;

@RestController
public class SongsController {

	@Resource
	private SongService songService;

	@GetMapping(value = "/alive")
	public void alive() {
		System.out.println("Alive");
		return;
	}

	@PostMapping(value = "/songs", consumes = "application/json", produces = "application/json")
	public Song createSong(@RequestBody final Song song) {
		return songService.createSong(song);
	}

	@PutMapping(value = "/songs/{song-id}", consumes = "application/json", produces = "application/json")
	public Song updateSong(@PathVariable("song-id") final String songUuid, @RequestBody final Song song) {
		return songService.updateSong(songUuid, song);
	}

	@DeleteMapping(value = "/songs/{song-id}")
	public void deleteSong(@PathVariable("song-id") final String songUuid) {
		songService.deleteSong(songUuid);
	}

	@GetMapping(value = "/songs", produces = "application/json")
	public List<Song> getAllSongs() {
		return songService.getAllSongs();
	}

	@GetMapping(value = "/songs/{song-id}", produces = "application/json")
	public Song getSong(@PathVariable("song-id") final String songUuid) {
		return songService.getSong(songUuid);
	}
}