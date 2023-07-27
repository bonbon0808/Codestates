package com.codestates.project.domain.baseentity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 모든 엔티티의 생성일시와 수정일시를 관리하기 위한 추상 클래스인 BaseTimeEntity입니다.
 * JPA Auditing을 이용하여 자동으로 생성일시와 수정일시를 관리합니다.
 *
 * @MappedSuperclass: 이 클래스를 상속하는 엔티티 클래스들이 해당 클래스의 매핑 정보를 상속받도록 지정합니다.
 * 즉, 이 클래스는 테이블과 직접 매핑되지 않으며, 다른 엔티티들의 공통 매핑 정보를 정의하는 용도로 사용됩니다.
 * 따라서 이 클래스에 선언된 필드들은 엔티티 클래스들이 상속받아 사용할 수 있습니다.
 *
 * @EntityListeners(AuditingEntityListener.class): 이 클래스에 대해 JPA Auditing을 활성화합니다.
 * JPA Auditing은 생성일시와 수정일시를 자동으로 관리하는 기능을 제공합니다.
 * 따라서 이 클래스에 선언된 필드들은 JPA Auditing을 통해 자동으로 값이 설정됩니다.
 * AuditingEntityListener는 이벤트 리스너로, 엔티티의 저장/변경 이벤트가 발생할 때 자동으로 처리하는 역할을 합니다.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    /**
     * 엔티티가 생성되어 저장될 때 자동으로 생성일시를 기록하기 위한 필드입니다.
     * @Column 어노테이션의 updatable 속성을 false로 지정하여 수정 시간이 자동으로 업데이트되지 않도록 설정합니다.
     * @LastModifiedDate 어노테이션과 함께 사용되며, 수정일시를 자동으로 기록합니다.
     */
    @LastModifiedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    /**
     * 엔티티가 생성되어 저장되거나 업데이트될 때 자동으로 수정일시를 기록하기 위한 필드입니다.
     * @CreatedDate 어노테이션과 함께 사용되며, 생성일시를 자동으로 기록합니다.
     */
    @CreatedDate
    private LocalDateTime modifiedDate;

    /**
     * 생성일시를 반환합니다.
     * @return LocalDateTime 생성일시
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * 수정일시를 반환합니다.
     * @return LocalDateTime 수정일시
     */
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
