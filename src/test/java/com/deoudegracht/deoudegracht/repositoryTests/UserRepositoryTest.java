package com.deoudegracht.deoudegracht.repositoryTests;

import com.deoudegracht.deoudegracht.DeOudegrachtApplication;


import com.deoudegracht.deoudegracht.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes={DeOudegrachtApplication.class})
public class UserRepositoryTest {
//    @Autowired
//    private UserRepositoryTest userRepositoryTest;
//    @Test
//    void testFindByUsername() {
//        //given
//        User user = new User("username", "password12345", "firstname", "lastname", "email", "not provided");
//
//        //when
//
//        //then
//    }

}
