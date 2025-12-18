// src/test/java/com/linqi/aicodehelper/ai/AicodehelperChatIntegrationTest.java
package com.linqi.aicodehelper.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;

import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.ImageContent;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AicodehelperChatIntegrationTest {

    @Autowired
    private Aicodehelper aiCodeHelper;


    //Simple conversation 
    @Test
    void chat() {
        String reply = aiCodeHelper.chat("Hello,My name is LInqi");
        assertThat(reply).isNotBlank();
        System.out.println("AI reply: " + reply);
    }


    //chat with ImageContent(not working since my model do not support image input)
    @Test
    void chatWithUserMessage() {
        UserMessage userMessage = UserMessage.from(
            TextContent.from("describe the Image"),
            ImageContent.from("https://www.codefather.cn/logo.png",ImageContent.DetailLevel.AUTO)
        );
        aiCodeHelper.chatwithMessage(userMessage);
    }
}
