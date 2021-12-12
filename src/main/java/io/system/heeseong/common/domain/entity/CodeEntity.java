package io.system.heeseong.common.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "code")
public class CodeEntity extends TimeEntity {

    @Id @Column(name = "code_idx")
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