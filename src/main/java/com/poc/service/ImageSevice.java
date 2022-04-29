package com.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.model.Image;
import com.poc.model.Series;
@Service
public interface ImageSevice {
 public Image createImage(List<Series> list);
 public Image updateImage(String Id, Image details);
}
