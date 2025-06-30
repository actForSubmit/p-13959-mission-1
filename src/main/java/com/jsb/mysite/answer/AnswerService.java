package com.jsb.mysite.answer;

import com.jsb.mysite.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {

  private final AnswerRepository answerRepository;

  public void create(Question question, String content) {
    Answer answer = new Answer(content, question);
    answerRepository.save(answer);
  }
}
