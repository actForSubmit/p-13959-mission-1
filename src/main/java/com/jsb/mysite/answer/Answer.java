package com.jsb.mysite.answer;

import com.jsb.mysite.question.Question;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime createDate;

  @ManyToOne
  private Question question;

  public Answer(String content, Question question) {
    this.content = content;
    this.createDate = LocalDateTime.now();
    this.question = question;
  }
}
