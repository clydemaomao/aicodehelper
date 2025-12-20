package com.linqi.aicodehelper.ai;

import java.util.List;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import reactor.core.publisher.Flux;

public interface AicodehelperService {
    @SystemMessage(fromResource = "system_prompt.txt")
    String chat(String userMessage);

    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport(String userMessage);

    // Study report
    record Report(String name, List<String> suggestionList) {
    }

    // streaming response
    Flux<String> chatStream(@MemoryId int memoryId, @UserMessage String userMessage);

}

