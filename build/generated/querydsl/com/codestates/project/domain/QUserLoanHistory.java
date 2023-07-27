package com.codestates.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserLoanHistory is a Querydsl query type for UserLoanHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserLoanHistory extends EntityPathBase<UserLoanHistory> {

    private static final long serialVersionUID = 174291286L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserLoanHistory userLoanHistory = new QUserLoanHistory("userLoanHistory");

    public final com.codestates.project.domain.baseentity.QBaseTimeEntity _super = new com.codestates.project.domain.baseentity.QBaseTimeEntity(this);

    public final QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> loanDate = createDate("loanDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final DatePath<java.time.LocalDate> returnedDate = createDate("returnedDate", java.time.LocalDate.class);

    public final EnumPath<UserLoanStatus> status = createEnum("status", UserLoanStatus.class);

    public final QUserInfo user;

    public QUserLoanHistory(String variable) {
        this(UserLoanHistory.class, forVariable(variable), INITS);
    }

    public QUserLoanHistory(Path<? extends UserLoanHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserLoanHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserLoanHistory(PathMetadata metadata, PathInits inits) {
        this(UserLoanHistory.class, metadata, inits);
    }

    public QUserLoanHistory(Class<? extends UserLoanHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new QBook(forProperty("book")) : null;
        this.user = inits.isInitialized("user") ? new QUserInfo(forProperty("user")) : null;
    }

}

