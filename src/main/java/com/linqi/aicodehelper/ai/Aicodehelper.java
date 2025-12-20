package com.linqi.aicodehelper.ai;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import dev.langchain4j.data.message.SystemMessage;

@Service
@Slf4j
public class Aicodehelper {

    @Resource
    private ChatModel openaiChatModel; // auto-configured by the OpenAI starter

    private static final String SYSTEM_MESSAGE = """
            You are a programming-focused assistant. Help users understand programming study paths and interview prep, and provide advice. Focus on:
            1.Planning a clear programming study roadmap.
            2.Giving project-based learning recommendations.
            3.Offering end-to-end job hunt guidance for programmers (e.g., resume optimization, application tips).
            4.Sharing interview prep strategies and interview tips.
            Use simple, easy-to-understand language to help users learn efficiently and improve their job hunt.
            """;


    // Simple conversation
    public String chat(String message) {
        SystemMessage systemMessage = SystemMessage.from(SYSTEM_MESSAGE);
        UserMessage userMessage = UserMessage.from(message);
        ChatResponse chatResponse = openaiChatModel.chat(systemMessage,userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI output: {}", aiMessage.text());
        return aiMessage.text();
    }

    //chatwith image(not working since my model do not support image input)
    public String chatwithMessage(UserMessage userMessage) {
        ChatResponse chatResponse = openaiChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("AI output: {}", aiMessage.text());
        return aiMessage.text();
    }
}
