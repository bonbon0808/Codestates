package com.codestates.project.repository;

import com.codestates.project.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookRepository 인터페이스는 도서(Book) 엔티티에 대한 데이터베이스 접근을 담당하는 JPA Repository입니다.
 * JpaRepository를 상속받음으로써 기본적인 CRUD(Create, Read, Update, Delete) 기능을 제공합니다.
 * 또한 DslBookRepository 인터페이스를 함께 상속받아 Querydsl을 사용한 복잡한 동적 쿼리를 작성할 수 있습니다.
 */
public interface BookRepository extends JpaRepository<Book, Long>, DslBookRepository {
}
