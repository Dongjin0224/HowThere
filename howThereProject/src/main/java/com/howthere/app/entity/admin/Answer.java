package com.howthere.app.entity.admin;

import com.howthere.app.auditing.Period;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_ANSWER")
@Getter @ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    private String answerContent;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Builder
    public Answer(Long id, @NotNull String answerContent, Question question) {
        this.id = id;
        this.answerContent = answerContent;
        this.question = question;
    }
}
