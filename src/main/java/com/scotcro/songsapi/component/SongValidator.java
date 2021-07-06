package com.scotcro.songsapi.component;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scotcro.songsapi.domain.Song;

import static com.google.common.base.Preconditions.checkArgument;

@Component
public class SongValidator {

	@Resource
	private Validator validator;

	public void validate(final Song song) {
		checkArgument(song != null, "you must provide a valid song.\n");
		checkArgument(validator.isNotBlankAndNoLongerThan(song.getTitle(), 100), "A song title must be provided that is not more than 100 characters");
		checkArgument(validator.ifProvidedIsNoLongerThan(song.getArtistName(), 100), "If an Artist Name is provided, the length should not be more than 100 characters");
		checkArgument(validator.ifProvidedIsBetween(song.getYearPublished(), 1600, 2021), "A valid year must be between 1600 and 2021");
	}
}