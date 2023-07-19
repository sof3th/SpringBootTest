package com.jpaexam.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpaexam.entity.Profile;

public interface ProfileRepository extends CrudRepository<Profile, String> {

}
