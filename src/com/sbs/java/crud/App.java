package com.sbs.java.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbs.java.crud.dto.Article;
import com.sbs.java.crud.util.Util;

public class App {
	private static List<Article> articles = new ArrayList<Article>();

	private static int lastArticleId = 0;

	public void start() {
		
		

		System.out.println("==프로그램 시작==");

		makeTestData();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.printf("명령어 : ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue;
			}
			if (command.equals("system exit")) {
				break;
			}

			if (command.equals("article write")) {

				++lastArticleId;
				int hit = 0;
				
				System.out.printf("제목: ");
				String title = sc.nextLine();
				System.out.printf("내용: ");
				String body = sc.nextLine();

				String today = Util.getNowDateStr();

				Article article = new Article(lastArticleId, title, body, today, hit);
				articles.add(article);

				System.out.println(lastArticleId + "번 글이 생성 되었습니다.");
			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다");
					continue;
				}
				System.out.println("번호 / 제목 / 조회수");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.println(article.id + "   /   " + article.title + "   /   " + article.hit);
				}
			} else if (command.startsWith("article detail ")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시물은 존재하지 않습니다.");
					continue;
				}

				System.out.println("번호 : " + foundArticle.id);
				System.out.println("날짜 : " + foundArticle.date);
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);
				System.out.println("조회수 : " + ++foundArticle.hit);

			} else if (command.startsWith("article delete ")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);

				int foundId = -1;
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundId = i;
						break;
					}

				}
				if(foundId != -1) {
					articles.remove(foundId);
					System.out.println(id + "번 게시물이 삭제 되었습니다.");
					continue;
				}
				if(foundId == -1)
				{
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				

			} else if (command.startsWith("article modify ")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = null;
				String today = Util.getNowDateStr();
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.println(id + "번 게시물은 존재하지 않습니다.");
					continue;
				}
				
				System.out.printf("새 제목: ");
				String title = sc.nextLine();
				System.out.printf("새 내용: ");
				String body = sc.nextLine();

				foundArticle.title = title;
				foundArticle.body = body;
				foundArticle.date = today;

				System.out.println(id + "번 게시물이 수정 되었습니다.");

			} else {
				System.out.println(command + "은(는) 존재하지 않는 명령어 입니다.");
			}

		}

		sc.close();

		System.out.println("==프로그램 끝==");
	}

	private static void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다.");
		articles.add(new Article(++lastArticleId, "제목 1", "내용 1", Util.getNowDateStr(), 0));
		articles.add(new Article(++lastArticleId, "제목 2", "내용 2", Util.getNowDateStr(), 0));
		articles.add(new Article(++lastArticleId, "제목 3", "내용 3", Util.getNowDateStr(), 0));
	}
}
