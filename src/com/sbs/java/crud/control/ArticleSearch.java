package com.sbs.java.crud.control;

import java.util.List;

import com.sbs.java.crud.dto.Article;

public class ArticleSearch {
	public List<Article> foundArticle;
	public int id = -1;

	public ArticleSearch(List<Article> foundArticle) {
		this.foundArticle = foundArticle;
	}

	public Article getArticle(String command) {
		String[] commandBits = command.split(" ");
		int id = Integer.parseInt(commandBits[2]);

		for (int i = 0; i < foundArticle.size(); i++) {
			Article article = foundArticle.get(i);

			if (article.id == id) {
				this.id = i;
				return article;
			}
		}
		System.out.println(id + "번 게시물은 존재하지 않습니다.");
		return null;
	}
}
