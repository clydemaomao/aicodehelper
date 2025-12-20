package com.linqi.aicodehelper.ai;
import org.springframework.context.annotation.Configuration;

import com.linqi.aicodehelper.ai.AicodehelperService.Report;
import com.linqi.aicodehelper.ai.tools.Interview;

import org.springframework.context.annotation.Bean;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import jakarta.annotation.Resource;

@Configuration
public class AicodehelperServiceFactory {
    

    @Resource
    private ChatModel openaiChatModel; // auto-configured by the OpenAI starter

    @Resource
    private StreamingChatModel openaiStreamingChatModel;

    @Resource
    private McpToolProvider mcpToolProvider;

    





    @Bean
    public AicodehelperService aicodehelperService() {
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        AicodehelperService aicodehelperService = AiServices.builder(AicodehelperService.class)
                                                            .chatModel(openaiChatModel)
                                                            .chatMemory(chatMemory)
                                                            .chatMemoryProvider(memoryId ->
                                                            MessageWindowChatMemory.withMaxMessages(10)) // Every user has independent memory
                                                            .tools(new Interview())
                                                            //.toolProvider(mcpToolProvider)  //MCP tool provider
                                                            //.contentRetriever(contentRetriever)  //RAG content retriever
                                                            .build();
        

        return aicodehelperService;
    }







}



