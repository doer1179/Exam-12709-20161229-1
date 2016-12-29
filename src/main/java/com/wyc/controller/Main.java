package com.wyc.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wyc.entity.Film;
import com.wyc.event.ApplicationContextStart;
import com.wyc.service.FilmService;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "ApplicationContext.xml" });
		ac.start();
		Insert(ac);
		ac.stop();
	}

	static void Insert(ApplicationContext ac) {
		FilmService filmService = (FilmService) ac.getBean("filmService");
		Film film = new Film();
		
		System.out.print("请输入电影标题（Title）（按回车键继续）：");
		try {
			film.setTitle(in.next());
		} catch (Exception e) {
			System.out.println("请输入合法的电影名称（字符串）");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
			Insert(ac);
		}
		System.out.print("请输入电影描述（Description）（按回车键继续）：");
		try {
			film.setDescription(in.next());
		} catch (Exception e) {
			System.out.println("请输入合法的电影描述（字符串）");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
			Insert(ac);
		}

		System.out.print("请输入语言ID（Language_id）（按回车键继续）：");
		try {
			int i = in.nextInt();
			if (i >= 1 && i <= 6) {
				film.setLanguage_id(i);
				int count = filmService.InsertFilm(film);

				if (count == 1) {
					System.out.println("新增电影成功！");
				} else {
					System.out.println("新增电影失败！");
					Insert(ac);
				}
			} else {
				System.out.println("请输入合法的语种ID（数字1-6）");
				System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
				Insert(ac);
			}
		} catch (Exception e) {
			System.out.println("请输入合法的语种ID（数字1-6）");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
			Insert(ac);
		}

	}
	
}

