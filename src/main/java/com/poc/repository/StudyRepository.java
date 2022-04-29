package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.model.Study;

@Repository
public interface StudyRepository<Image> extends JpaRepository<Study, String>{

}
