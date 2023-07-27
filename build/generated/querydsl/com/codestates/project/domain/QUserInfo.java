package com.codestates.project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInfo extends EntityPathBase<UserInfo> {

    private static final long serialVersionUID = -2004910820L;

    public static final QUserInfo userInfo = new QUserInfo("userInfo");

    public final com.codestates.project.domain.baseentity.QBaseTimeEntity _super = new com.codestates.project.domain.baseentity.QBaseTimeEntity(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final ListPath<UserLoanHistory, QUserLoanHistory> userLoanHistories = this.<UserLoanHistory, QUserLoanHistory>createList("userLoanHistories", UserLoanHistory.class, QUserLoanHistory.class, PathInits.DIRECT2);

    public QUserInfo(String variable) {
        super(UserInfo.class, forVariable(variable));
    }

    public QUserInfo(Path<? extends UserInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserInfo(PathMetadata metadata) {
        super(UserInfo.class, metadata);
    }

}

