package com.sbs.java.crud;

import java.util.Scanner;

import com.sbs.java.crud.control.ArticleControl;

public class App {
	public void start() {

		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		ArticleControl articleControl = new ArticleControl(sc);

		articleControl.makeTestData();

		while (true) {
			System.out.printf("명령어 : ");
			String command = sc.nextLine().trim();
			articleControl.command = command;

			if (command.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue;
			} else if (command.equals("system exit")) {
				break;
			} else if (command.equals("article write")) {
				articleControl.ArticleWrite();
				continue;
			} else if (command.equals("article list")) {
				articleControl.ArticleList();
				continue;
			} else if (command.startsWith("article detail ")) {
				articleControl.ArticleDetail();
				continue;
			} else if (command.startsWith("article delete ")) {
				articleControl.ArticleDelete();
				continue;
			} else if (command.startsWith("article modify ")) {
				articleControl.ArticleModify();
				continue;
			} else {
				System.out.println(command + "은(는) 존재하지 않는 명령어 입니다.");
			}
		}

		sc.close();

		System.out.println("==프로그램 끝==");
	}
}
