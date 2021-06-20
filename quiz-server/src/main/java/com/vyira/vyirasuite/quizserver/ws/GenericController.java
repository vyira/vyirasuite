package com.vyira.vyirasuite.quizserver.ws;

import com.vyira.vyirasuite.quizserver.enums.DBCollections;
import com.vyira.vyirasuite.quizserver.models.History;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class GenericController {
    MongoOperations mongoOperations;

    @Autowired
    public GenericController(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("api/${api.version}/test")
    public String successTestResponse() {
        return "Success";
    }

    @GetMapping("/test")
    public ResponseEntity<Object> request() {
        return getObjectResponseEntity();
    }

    @GetMapping("/${api.version}/test")
    public ResponseEntity<Object> testRequest() {
        return getObjectResponseEntity();
    }

    @GetMapping("/get/test")
    public ResponseEntity<Object> getTestHistory() {
        try {
            History history = new History();
            history.setCode("1000");
            history.setEventType("GET_HISTORY");
            history.setCreateDate(LocalDateTime.now());
            history.setDescription("API Called for getTestHistory");
            log.error(history.toString());
            return ResponseEntity.accepted().body(mongoOperations.save(history, DBCollections.HISTORY_EVENT));
        } catch (Exception e) {
            log.error("Error Occurred", e);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private ResponseEntity<Object> getObjectResponseEntity() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("content-type", java.util.Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
        map.put("X-Correlation", java.util.Collections.singletonList(RandomStringUtils.randomAlphabetic(32)));
        HttpHeaders header = new HttpHeaders();
        header.addAll(map);
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", "Awatansa");
        bodyMap.put("dob", new Date());
        bodyMap.put("location", new String[]{"Longitude", "Latitude"});
        return ResponseEntity.ok().headers(header).body(bodyMap);
    }
}
