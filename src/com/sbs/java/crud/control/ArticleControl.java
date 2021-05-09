package com.sbs.java.crud.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbs.java.crud.dto.Article;
import com.sbs.java.crud.util.Util;

public class ArticleControl {

	private static List<Article> articles = new ArrayList<Article>();
	private static int lastArticleId = 0;
	
	public Scanner sc;
	public String command;
	
	public ArticleControl() {
		this(null);
	}

	public ArticleControl(Scanner sc) {
		this.sc = sc;
	}

	public void ArticleWrite() {
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
	}

	public void ArticleList() {
		if (articles.size() == 0) {
			System.out.println("게시물이 없습니다");
			return;
		}
		System.out.println("번호 / 제목 / 조회수");
		for (int i = articles.size() - 1; i >= 0; i--) {
			Article article = articles.get(i);

			System.out.println(article.id + "   /   " + article.title + "   /   " + article.hit);
		}
	}

	public void ArticleDetail() {
		ArticleSearch article = new ArticleSearch(articles);

		Article foundArticle = article.getArticle(command);

		if (foundArticle == null) {
			return;
		}

		System.out.println("번호 : " + foundArticle.id);
		System.out.println("날짜 : " + foundArticle.date);
		System.out.println("제목 : " + foundArticle.title);
		System.out.println("내용 : " + foundArticle.body);
		System.out.println("조회수 : " + ++foundArticle.hit);

	}
	
	public void ArticleDelete() {
		ArticleSearch article = new ArticleSearch(articles);

		Article foundArticle = article.getArticle(command);
		if (article.id != -1) {
			articles.remove(article.id);
			System.out.println(foundArticle.id + "번 게시물이 삭제 되었습니다.");
		}
	}
	
	public void ArticleModify() {
		ArticleSearch article = new ArticleSearch(articles);

		Article foundArticle = article.getArticle(command);

		if (foundArticle == null) {
			return;
		}

		System.out.printf("새 제목: ");
		foundArticle.title = sc.nextLine();
		System.out.printf("새 내용: ");
		foundArticle.body = sc.nextLine();
		foundArticle.date = Util.getNowDateStr();

		System.out.println(foundArticle.id + "번 게시물이 수정 되었습니다.");
	}
	
	public void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다.");
		articles.add(new Article(++lastArticleId, "제목 1", "내용 1", Util.getNowDateStr(), 0));
		articles.add(new Article(++lastArticleId, "제목 2", "내용 2", Util.getNowDateStr(), 0));
		articles.add(new Article(++lastArticleId, "제목 3", "내용 3", Util.getNowDateStr(), 0));
	}
}
