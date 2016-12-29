package com.wyc.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.wyc.entity.Film;
import com.wyc.mapper.FilmMapper;

@Service
public class FilmService {
	 @Autowired
	 FilmMapper filmMapper;
	 private ApplicationContext applicationContext;
	 
	 public void setFilmMapper(FilmMapper filmMapper) {
	        this.filmMapper = filmMapper;
	    }
	
	 public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        this.applicationContext=applicationContext;
	    }
	 
	public int InsertFilm(Film film){
		int rownum = filmMapper.Insert(film);
		return rownum;
	}

}
