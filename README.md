# AI Code Helper - LangChain4j Practice Project

> Build an AI coding mentor in Java + Vue. Learn by shipping real features.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-6DB33F?logo=springboot&logoColor=white)
![Vue.js](https://img.shields.io/badge/Vue.js-3.3.4-42b883?logo=vuedotjs&logoColor=white)
![LangChain4j](https://img.shields.io/badge/LangChain4j-1.9.1-0b7285?logo=chainlink&logoColor=white)
![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)

AI app development is quickly becoming a must-have skill. The main goal for thnis project is only for my personal demonstration and study purpose.

Instead of theory walls, I assemble a focused product and learn the core patterns through practice. Ship something useful and build portfolio experience along the way.

## Preview

[Watch the demo](docs/demo.mp4)
<img width="2559" height="1267" alt="image" src="https://github.com/user-attachments/assets/da9114e2-0b54-469b-af38-09d988642c2a" />



This project touches chat memory, structured outputs, tool calls, RAG and MCP scaffolding, guardrails, and logging-friendly workflows from zero to one.

## Project Overview

### Positioning
- Learning mentor: clear study roadmaps and tailored guidance.
- Interview coach: resume tips, interview tactics, and question breakdowns.
- Coding helper: fast answers with examples and explanations.

## Technology

### AI Services
- LangChain4j integration via Spring Boot auto-configuration.
- Short-term conversation memory with a message window.
- REST chat endpoint today, streaming ready when you add SSE.

### Safety
- Input guardrail example for basic sensitive-word filtering.

### Tooling
- Interview question search tool powered by Jsoup.
- RAG and MCP configs included as optional scaffolding (commented out by default).

## Quick Start

### Requirements
- Java 21+
- Node.js 16+
- Maven 3.6+
- API keys for real models (see application.yml)

### Run It

1. Backend

```
# clone the repo
git clone <repository-url>
cd aicodehelper

# configure API keys
# edit src/main/resources/application.yml

# start backend (macOS/Linux)
./mvnw spring-boot:run

# start backend (Windows)
.\\mvnw.cmd spring-boot:run
```

2. Frontend

```
cd frontend
npm install
npm run dev
```

3. Open the app

- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api

## Architecture

```
[Vue UI]
   |
   v
[Spring Boot REST API] ---> [LangChain4j Service]
                               |  \
                               |   +--> [Interview Tool (Jsoup)]
                               |
                               +--> [Chat Model (OpenAI compatible)]

(Optional)
[RAG Config]   [MCP Config]
```

## Core Modules
- `src/main/java/com/linqi/aicodehelper/api/ChatController.java`: REST chat endpoint.
- `src/main/java/com/linqi/aicodehelper/ai/AicodehelperService.java`: service contract for AI chat.
- `src/main/java/com/linqi/aicodehelper/ai/AicodehelperServiceFactory.java`: wiring for model, memory, and tools.
- `src/main/java/com/linqi/aicodehelper/ai/tools/Interview.java`: interview question search tool.
- `src/main/java/com/linqi/aicodehelper/ai/guardrail/SafeInputGuardRail.java`: input guardrail example.
- `src/main/java/com/linqi/aicodehelper/ai/rag/RagConfig.java`: optional RAG scaffold.
- `src/main/java/com/linqi/aicodehelper/ai/mco/McpConfig.java`: optional MCP scaffold.

## Thanks
- BiliBili Youtuber: yupi
- LangChain4j
- Spring Boot
- Vue and Vite
- Jsoup
