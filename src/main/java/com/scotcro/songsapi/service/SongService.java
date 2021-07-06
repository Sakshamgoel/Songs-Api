package com.scotcro.songsapi.service;

import org.springframework.stereotype.Service;

import com.scotcro.songsapi.component.SongValidator;
import com.scotcro.songsapi.domain.Song;
import com.scotcro.songsapi.repository.SongRepository;

import javax.annotation.Resource;

import java.lang.IllegalArgumentException;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Service
public class SongService {

	@Resource
	private SongRepository songRepo;

	@Resource
	private SongValidator songValidator;

	public Song createSong(final Song song) {
		songValidator.validate(song);

		final var saved = songRepo.saveSong(song);
		return saved;

	}

	public Song updateSong(final String songUuid, final Song song) {
		songValidator.validate(song);

		if(StringUtils.isBlank(songUuid)) {
			throw new IllegalArgumentException("Song Uuid is invalid.\n");
		}

		final var optOfSong = songRepo.findById(songUuid);

		if(optOfSong.isEmpty()) {
			throw new RuntimeException("Unable to find song with the uuid: " + songUuid);
		}

		final var victim = optOfSong.get();

		victim.setArtistName(song.getArtistName());
		victim.setTitle(song.getTitle());
		victim.setDuration(song.getDuration());
		victim.setYearPublished(song.getYearPublished());

		final var saved = songRepo.saveSong(victim);
		
		return saved;
	}

	public void deleteSong(String songUuid) {
		if(StringUtils.isBlank(songUuid)) {
			throw new IllegalArgumentException("Song Uuid is blank.\n");
		}
		songRepo.delete(songUuid);
	}

	public List<Song> getAllSongs() {
		return songRepo.getAllSongs();
	}

	public Song getSong(String songUuid) {
		if(StringUtils.isBlank(songUuid)) {
			throw new IllegalArgumentException("Song Uuid is blank.\n");
		}
		return songRepo.findById(songUuid).orElse(null);
	}
}