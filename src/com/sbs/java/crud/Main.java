package com.sbs.java.crud;

import java.util.ArrayList;
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

				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.printf("%d번 글이 생성 되었습니다.\n", id);
			} else if (command.equals("article list")) {
				System.out.println("번호 / 제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.println(article.id + "   /   " + article.title);
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

	public Article() {
		this(0, null, null);
	}

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

}
