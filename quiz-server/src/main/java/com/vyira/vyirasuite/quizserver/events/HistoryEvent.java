package com.vyira.vyirasuite.quizserver.events;

import com.mongodb.client.result.DeleteResult;
import com.vyira.vyirasuite.quizserver.models.History;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Slf4j
public class HistoryEvent {
    static MongoOperations mongoOperations;

    HistoryEvent() {
    }

    public static void logHistory(String code, String eventType, String description) {
        try {
            History history = new History
                    .HistoryBuilder()
                    .setCode(code)
                    .setDescription(description)
                    .setEventType(eventType)
                    .setCreateDate(LocalDateTime.now())
                    .setCreatedBy("SAMPLE_USER")
                    .build();
            History result = mongoOperations.save(history);
            log.info(String.format("History Saved Successfully: %s", history.getId()));
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
    }

    public static List<History> getHistory(String historyId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(historyId));
        return mongoOperations.find(query, History.class);
    }

    public static void deleteHistory(String historyId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(historyId));
        DeleteResult deleteResult = mongoOperations.remove(query, History.class);
        if (deleteResult.wasAcknowledged()) {
            log.info(String.format("History Deleted : %x", deleteResult.getDeletedCount()));
        }
    }
}
