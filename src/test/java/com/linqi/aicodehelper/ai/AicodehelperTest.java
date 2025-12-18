// src/test/java/com/linqi/aicodehelper/ai/AicodehelperChatIntegrationTest.java
package com.linqi.aicodehelper.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AicodehelperChatIntegrationTest {

    @Autowired
    private Aicodehelper aiCodeHelper;

    @Test
    void chat() {
        String reply = aiCodeHelper.chat("你好，我是测试请求");
        assertThat(reply).isNotBlank();
        System.out.println("AI reply: " + reply);
    }
}
