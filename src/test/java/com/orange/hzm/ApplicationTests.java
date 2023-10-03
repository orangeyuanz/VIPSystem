package com.orange.hzm;

import com.orange.hzm.mapper.UserMapper;
import com.orange.hzm.pojo.entity.User;
import com.orange.hzm.utils.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Test
    public void UserMapper() {
        System.out.println("===========================");
        System.out.println(LocalDateTime.now());
        System.out.println("===========================");
    }

}
