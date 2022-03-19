package io.system.heeseong.common.domain.entity;

import io.system.heeseong.common.domain.model.Code;
import io.system.heeseong.user.domain.model.Menu;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "code")
public class CodeEntity extends TimeEntity {

    @Id
    @Column(name = "code_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String codeGroup;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String use_yn;

    public CodeEntity() {
    }

    public Code entityToValueObject() {
        return Code.entityToValueObject()
                .codeGroup(codeGroup)
                .code(code)
                .message(message)
                .useYn(use_yn)
                .build();
    }

    @Override
    public String toString() {
        return "CodeEntity{" +
                "idx=" + idx +
                ", codeGroup='" + codeGroup + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", use_yn='" + use_yn + '\'' +
                '}';
    }
}