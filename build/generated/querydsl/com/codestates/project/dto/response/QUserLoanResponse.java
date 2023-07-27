package com.codestates.project.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.codestates.project.dto.response.QUserLoanResponse is a Querydsl Projection type for UserLoanResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserLoanResponse extends ConstructorExpression<UserLoanResponse> {

    private static final long serialVersionUID = -664203309L;

    public QUserLoanResponse(com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<com.codestates.project.domain.UserLoanStatus> status, com.querydsl.core.types.Expression<java.time.LocalDate> loanDate, com.querydsl.core.types.Expression<java.time.LocalDate> returnedDate) {
        super(UserLoanResponse.class, new Class<?>[]{String.class, com.codestates.project.domain.UserLoanStatus.class, java.time.LocalDate.class, java.time.LocalDate.class}, title, status, loanDate, returnedDate);
    }

}

