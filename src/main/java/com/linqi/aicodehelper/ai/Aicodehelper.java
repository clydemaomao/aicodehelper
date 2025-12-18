package com.linqi.aicodehelper.ai;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Aicodehelper {

    @Resource
    private ChatModel openaiChatModel; // auto-configured by the OpenAI starter


    // Simple conversation
    public String chat(String message) {
        UserMessage userMessage = UserMessage.from(message);
        ChatResponse chatResponse = openaiChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI output: {}", aiMessage.text());
        return aiMessage.text();
    }

    //
    public String chatwithMessage(UserMessage userMessage) {
        ChatResponse chatResponse = openaiChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI output: {}", aiMessage.text());
        return aiMessage.text();
    }
}
