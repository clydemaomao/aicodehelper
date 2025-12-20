
package com.linqi.aicodehelper.ai.guardrail;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.guardrail.InputGuardrail;
import dev.langchain4j.guardrail.InputGuardrailResult;

import java.util.Set;

/**
 * safe input guardrail implementation
 */
public class SafeInputGuardRail implements InputGuardrail {

    private static final Set<String> sensitiveWords = Set.of("kill", "evil","fuck","terrorism","bomb");

    /**
     * inspect user input for sensitive words
     */
    @Override
    public InputGuardrailResult validate(UserMessage userMessage) {
        // change input to lower case for case-insensitive comparison
        String inputText = userMessage.singleText().toLowerCase();
        // using non-word characters to split words
        String[] words = inputText.split("\\W+");
        // go through each word and check if it's sensitive
        for (String word : words) {
            if (sensitiveWords.contains(word)) {
                return fatal("Sensitive word detected: " + word);
            }
        }
        return success();
    }
}