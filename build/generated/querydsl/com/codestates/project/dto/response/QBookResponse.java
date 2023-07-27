package com.codestates.project.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.codestates.project.dto.response.QBookResponse is a Querydsl Projection type for BookResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBookResponse extends ConstructorExpression<BookResponse> {

    private static final long serialVersionUID = 749648097L;

    public QBookResponse(com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<com.codestates.project.domain.BookCategory> category, com.querydsl.core.types.Expression<String> author, com.querydsl.core.types.Expression<String> publisher) {
        super(BookResponse.class, new Class<?>[]{String.class, com.codestates.project.domain.BookCategory.class, String.class, String.class}, title, category, author, publisher);
    }

}

