package com.sbs.java.crud.control;

import java.util.List;

import com.sbs.java.crud.dto.Article;

public class ArticleSearch {
	List<Article> foundArticle;

	public ArticleSearch(List<Article> foundArticle) {
		this.foundArticle = foundArticle;
	}

	Article getArticle(String command) {
		String[] commandBits = command.split(" ");
		int id = Integer.parseInt(commandBits[2]);

		for (int i = 0; i < foundArticle.size(); i++) {
			Article article = foundArticle.get(i);

			if (article.id == id) {
				return article;
			}
			
		}
		return null;

	}
}
