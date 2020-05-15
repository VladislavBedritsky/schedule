package org.kek.backend.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.dao.UserDao;
import org.kek.backend.model.User;
import org.kek.backend.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations={"classpath*:test.xml"})
public class UserServiceImplTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserDao userDao;

    public UserServiceImplTest() {
        userService = new UserServiceImpl();
    }

    @Test
    public void saveUser() {
        userService.saveUser(new User());
        Mockito.verify(userDao).saveUser(isA(User.class));
    }

    @Test
    public void findAll() {
        userService.findAll();
        Mockito.verify(userDao).findAll();
    }

    @Test
    public void findUserById() {

        Mockito.when(userDao.findUserById("qqq")).thenReturn(
                new User()
        );

        Assert.assertNotNull(userService.findUserById("qqq"));
    }

    @Test
    public void updateUsername() {
        String id = "cityId";

        Mockito.doAnswer((Answer) invocation -> {
            String arg0 = invocation.getArgument(0);
            User user = new User();
            user.setId(arg0);
            return user;
        }).when(userDao).findUserById(any(String.class));

        userService.updateUsername(id, new User());
        Mockito.verify(userDao).findUserById(isA(String.class));
        Mockito.verify(userDao).updateUser(isA(User.class));
    }

    @Test
    public void removeUserById() {
        String id = "cityId";

        Mockito.doAnswer((Answer) invocation -> {
            String arg0 = invocation.getArgument(0);
            User user = new User();
            user.setId(arg0);
            return user;
        }).when(userDao).findUserById(any(String.class));

        userService.removeUserById(id);
        Mockito.verify(userDao).findUserById(isA(String.class));
        Mockito.verify(userDao).removeUser(isA(User.class));
    }
}