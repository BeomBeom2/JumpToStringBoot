package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private LocalDateTime createDate;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;


    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // CascadeType.REMOVE =  answer 이 사라지면 자동으로 question 도 사라짐.
    //CascadeType.PERSIST 는 트랜잭션안에서  원본이 저장될 때 자동 저장
    private List<Answer> answers = new ArrayList<>(); // ANSWER_ID_LIST 같은 칼럼은 생기지 않는다.

    public Answer addAnswer(String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(this);
        answer.setCreateDate(LocalDateTime.now());
        answers.add(answer);

        return answer;
    }
}