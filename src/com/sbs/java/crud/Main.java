package com.sbs.java.crud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		List<Article> articles = new ArrayList<>();

		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;
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

				int id = lastArticleId + 1;
				lastArticleId = id;
				System.out.printf("제목: ");
				String title = sc.nextLine();
				System.out.printf("내용: ");
				String body = sc.nextLine();

//				articles.add(new Article(id,title,body));
				Date adate= new Date();
				String date = adate.toString();
				
				Article article = new Article(id, title, body,date);
				articles.add(article);
				
				

				System.out.printf("%d번 글이 생성 되었습니다.\n", id);
			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다");
					continue;
				}
				System.out.println("번호 / 제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.println(article.id + "   /   " + article.title);
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

			} else if (command.startsWith("article delete ")) {
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				
				boolean articleIs=true;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if (article.id == id) {
						System.out.println(id +"번 게시물이 삭제 되었습니다.");
						articleIs = false;
						articles.remove(i);
						break;
					}else {
						articleIs=true;
					}
				}
				if(articleIs) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
				}


			} else {
				System.out.println(command + "은(는) 존재하지 않는 명령어 입니다.");
			}

		}

		sc.close();

		System.out.println("==프로그램 끝==");
	}
}

class Article {
	int id;
	String title;
	String body;
	String date;
	
	public Article() {
		this(0, null, null, null);
	}

	public Article(int id, String title, String body,String date) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;		
	}

}
