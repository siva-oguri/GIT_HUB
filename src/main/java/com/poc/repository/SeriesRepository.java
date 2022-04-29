package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.model.Series;

@Repository
public interface SeriesRepository<Image> extends JpaRepository<Series, String>{

}
