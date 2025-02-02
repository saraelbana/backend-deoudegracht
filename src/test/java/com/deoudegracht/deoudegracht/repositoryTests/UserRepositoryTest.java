package com.deoudegracht.deoudegracht.repositoryTests;

import com.deoudegracht.deoudegracht.DeOudegrachtApplication;


import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes={DeOudegrachtApplication.class})
public class UserRepositoryTest {

}
