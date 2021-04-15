package com.vyira.vyirasuite.quizserver.events;

import com.vyira.vyirasuite.quizserver.models.History;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class HistoryEvent {
    HistoryEvent() {
    }

    public static void createHistory(String code, String eventType, String description) {
        History history = new History();
        history.setCode(code);
        history.setEventType(eventType);
        history.setDescription(description);
    }

    public static List<History> getHistory(String id) {
        List<History> historyList = new ArrayList<>();
        History history = new History("SAMPLE_ID",
                "SAMPLE_EVENT_TYPE",
                "SAMPLE_CODE",
                "SAMPLE_DESCRIPTION_DESCRIPTION SAMPLE_DESCRIPTION",
                LocalDateTime.now(),
                "SAMPLE_USER"
        );
        historyList.add(history);
        return historyList;
    }

    public static void deleteHistory(String historyId) {
        // TODO: Delete history event
    }
}
