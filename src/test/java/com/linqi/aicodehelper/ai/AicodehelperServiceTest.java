
package com.linqi.aicodehelper.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;

import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.UserMessage;
import static org.assertj.core.api.Assertions.assertThat;
import com.linqi.aicodehelper.ai.AicodehelperService;

@SpringBootTest
class AicodehelperServiceTest {

    @Resource
    private AicodehelperService aiCodeHelperService;

    @Resource
    private Aicodehelper aiCodeHelper;

    @Test
    void chat() {
        String reply = aiCodeHelperService.chat("Hello,My name is LInqi,im a developer and I need your help");
        System.out.println("Service: " + reply);
    }

    @Test
    void chatWithMemory() {
        String result = aiCodeHelperService.chat("Hi, my name is Linqi, im a developer");
        System.out.println(result);
        result = aiCodeHelperService.chat("Hi,who am I?");
        System.out.println(result);
    }

    @Test
    void chatForReport() {
        String userMessage = "Hi, please help me to analyze my study habits and give me suggestions to improve my study efficiency. Here is my study data for the past month: I studied an average of 3 hours per day, mainly focusing on programming and data structures. I often get distracted by social media and have difficulty maintaining concentration for long periods. I also tend to procrastinate on assignments and leave them until the last minute. Based on this information, please provide me with a detailed report on my study habits and actionable suggestions for improvement.";
        AicodehelperService.Report report = aiCodeHelperService.chatForReport(userMessage);
        System.out.println("your report: " + report);
    }

     @Test
    void chatWithTools() {
        String result = aiCodeHelperService.chat("what questions are commonly asked in a java developer interview?");
        System.out.println(result);
    }


}
