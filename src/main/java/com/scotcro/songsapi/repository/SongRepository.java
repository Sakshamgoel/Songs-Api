package com.scotcro.songsapi.repository;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

import java.util.UUID;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.scotcro.songsapi.domain.Song;

@Component
public class SongRepository {

	final static Map<String, Song> catalog = new HashMap<String, Song>();

	public Song saveSong(final Song song) {

		if(StringUtils.isBlank(song.getId())) {
			song.setId(UUID.randomUUID().toString());
		}

		catalog.put(song.getId(), song);
		return song;
	}

	public Optional<Song> findById(String songUuid) {
		final var found = catalog.get(songUuid);

		return found == null ? Optional.empty() : Optional.of(found);
	}

	public void delete(String songUuid) {
		catalog.remove(songUuid);
	}

	public List<Song> getAllSongs() {

		return catalog.values().stream().collect(Collectors.toList());
	}

}