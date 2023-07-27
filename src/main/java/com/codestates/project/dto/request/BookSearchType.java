package com.codestates.project.dto.request;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.codestates.project.domain.QBook;

import java.util.function.Function;

/**
 * 도서 검색 시 사용되는 검색 조건을 나타내는 열거형 클래스인 BookSearchType입니다.
 * TITLE, AUTHOR, PUBLISHER 세 가지 검색 조건이 있으며, 각각 해당하는 필드에 대해 검색 조건을 생성하는 기능을 제공합니다.
 * QBook 클래스를 활용하여 검색 조건을 표현합니다.
 */
public enum BookSearchType {

    /**
     * 도서 제목으로 검색하는 검색 조건입니다.
     * QBook의 title 필드를 대상으로 해당 문자열을 포함하는지 검사하는 검색 조건을 생성합니다.
     */
    TITLE(QBook.book.title::contains),

    /**
     * 도서 작가로 검색하는 검색 조건입니다.
     * QBook의 author 필드를 대상으로 해당 문자열을 포함하는지 검사하는 검색 조건을 생성합니다.
     */
    AUTHOR(QBook.book.author::contains),

    /**
     * 도서 출판사로 검색하는 검색 조건입니다.
     * QBook의 publisher 필드를 대상으로 해당 문자열을 포함하는지 검사하는 검색 조건을 생성합니다.
     */
    PUBLISHER(QBook.book.publisher::contains);

    private final Function<String, BooleanExpression> expression;

    /**
     * BookSearchType의 생성자입니다.
     * @param expression 검색 조건을 생성하는 Function 객체
     */
    BookSearchType(Function<String, BooleanExpression> expression) {
        this.expression = expression;
    }

    /**
     * 주어진 문자열에 해당하는 검색 조건을 생성합니다.
     * @param value 검색할 문자열
     * @return BooleanExpression 도서 검색 조건을 나타내는 BooleanExpression 객체
     */
    public BooleanExpression getCondition(String value) {
        return expression.apply(value);
    }
}
