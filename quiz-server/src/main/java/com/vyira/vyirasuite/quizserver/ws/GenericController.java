package com.vyira.vyirasuite.quizserver.ws;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
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

import java.util.Arrays;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class GenericController {

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("api/${api.version}/test")
    public String successTestResponse() {
        return "Success";
    }

    @GetMapping("/test")
    public ResponseEntity<Object> request(){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("content-type", Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        map.put("X-Correlation", Arrays.asList(RandomStringUtils.randomAlphabetic(32)));
        HttpHeaders header = new HttpHeaders();
        header.addAll(map);
        return new ResponseEntity<Object>(map,HttpStatus.ACCEPTED);
    }
}
