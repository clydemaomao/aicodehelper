package com.linqi.aicodehelper.ai.mco;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.http.HttpMcpTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Value("${bigmodel.api-key}")
    private String apiKey;

    @Bean
    public McpToolProvider mcpToolProvider() {
        // communication transport
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("https://open.bigmodel.cn/api/mcp/web_search/sse?Authorization=" + apiKey)
                .logRequests(true) // optional: log requests for debugging
                .logResponses(true)
                .build();
        // create mcp client
        McpClient mcpClient = new DefaultMcpClient.Builder()
                .key("yupiMcpClient")
                .transport(transport)
                .build();
        // getting McpToolProvider
        McpToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(mcpClient)
                .build();
        return toolProvider;
    }
}