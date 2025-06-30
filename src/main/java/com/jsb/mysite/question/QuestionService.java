package com.jsb.mysite.question;

import com.jsb.mysite.DataNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

  public List<Question> getList() {
    return questionRepository.findAll();
  }

  public Question getQuestion(int id) {
    Optional<Question> question = questionRepository.findById(id);
    if (question.isPresent()) {
      return question.get();
    } else {
      throw new DataNotFoundException("question not found");
    }
  }

  public void create(String subject, String content) {
    questionRepository.save(new Question(subject, content));
  }
}
