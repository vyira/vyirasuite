package com.vyira.vyirasuite.quizserver.models;

import com.vyira.vyirasuite.quizserver.enums.DBCollections;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document(value = DBCollections.HISTORY_EVENT)
public class History implements Serializable {

    private static final long serialVersionUID = 456306624001166709L;
    @Id
    String id;
    String eventType;
    String code;
    String description;
    String entityType;
    String entityId;

    @CreatedDate
    LocalDateTime createDate;
    @CreatedBy
    String createdBy;

    public static class HistoryBuilder {
        String code;
        String description;
        String eventType;
        LocalDateTime createDate;
        String createdBy;

        public HistoryBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public HistoryBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public HistoryBuilder setEventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public HistoryBuilder setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public HistoryBuilder setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public History build() {
            History history = new History();
            history.setCode(this.code);
            history.setEventType(this.eventType);
            history.setDescription(this.description);
            history.setCreateDate(this.createDate);
            history.setCreatedBy(this.createdBy);
            return history;
        }
    }
}
