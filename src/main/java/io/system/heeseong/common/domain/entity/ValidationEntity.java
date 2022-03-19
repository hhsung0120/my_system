package io.system.heeseong.common.domain.entity;

import io.system.heeseong.common.domain.model.Validation;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "validation")
public class ValidationEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String check;

    @Column(nullable = false)
    private String use_yn;

    public ValidationEntity() {
    }

    public Validation entityToValueObject() {
        return Validation.entityToValueObject()
                .idx(idx)
                .check(check)
                .use_yn(use_yn)
                .build();
    }

    @Override
    public String toString() {
        return "ValidationEntity{" +
                "idx=" + idx +
                ", check='" + check + '\'' +
                ", use_yn='" + use_yn + '\'' +
                '}';
    }
}