package com.sdardew.board.repository;

import com.sdardew.board.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  private static User user;
  private static User user2;

  @BeforeAll
  static void beforeAll() {
    user = new User();
    user.setName("user");
    user.setHobby("movie");
    user.setAge(20);
    user.setCreateAt(LocalDateTime.now());

    user2 = new User();
    user2.setName("user2");
    user2.setHobby("cooking");
    user2.setAge(22);
    user2.setCreateAt(LocalDateTime.now());
  }

  @Test
  @DisplayName("user 테이블 테스트")
  void testInsert() {
    userRepository.save(user);
    List<User> all = userRepository.findAll();
    assertThat(all.size()).isEqualTo(1);
  }
}