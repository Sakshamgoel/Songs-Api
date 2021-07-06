package com.scotcro.songsapi.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Validator {

	public boolean isNotBlankAndNoLongerThan(final String candidate, final Integer maxLength) {
		return StringUtils.isBlank(candidate) && StringUtils.length(candidate) <= maxLength;
	}

	public boolean ifProvidedIsNoLongerThan(final String candidate, final Integer maxLength) {
		return StringUtils.isBlank(candidate) || StringUtils.length(candidate) <= maxLength;
	}

	public boolean ifProvidedIsBetween(final Integer year, Integer min, Integer max) {
		return year == null || (year >= min && year <= max);
	}
}