package com.devicespringboot.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/*
 * use for track the changes of table (createDate, createBy)
 * declare in abstract entity
 * 
 */
public class JpaAuditing implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("anonymous");
	}

}
