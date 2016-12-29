package com.wyc.mapper;

import org.springframework.stereotype.Component;

import com.wyc.entity.Film;

@Component
public interface FilmMapper {

	public int Insert(Film film);
}
