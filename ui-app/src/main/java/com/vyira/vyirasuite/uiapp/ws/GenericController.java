package com.vyira.vyirasuite.uiapp.ws;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class GenericController {
    private final Logger Log = LoggerFactory.getLogger(GenericController.class);

    @RequestMapping("/")
    public ModelAndView getIndex() {
        Log.debug("Root Page Requested");
        return new ModelAndView("index.html");
    }

    @ResponseBody
    @RequestMapping("/api/${api.version}/pageDetails")
    public Map<String, String> getPageDetails(@RequestParam(value = "pageTitle", defaultValue = "true") boolean pageTitle,
                                              @RequestParam(value = "pageDescription", defaultValue = "true") boolean pageDescription) throws InterruptedException {
        log.info(String.format("pageTitle: %s, pageDescription: %s", pageTitle, pageDescription));

        TimeUnit.SECONDS.sleep(2L);
        Map<String, String> pageDetails = new HashMap<>();
        if (pageTitle && pageDescription) {
            pageDetails.put("pageTitle", "Welcome To Vyira Details");
            pageDetails.put("pageDescription", "Lorem ipsum title description");
            return pageDetails;
        }
        return pageDetails;
    }

    @ResponseBody
    @RequestMapping("/api/${api.version}/test")
    public HttpEntity<Map<String, List<String>>> performTest() {
        HttpHeaders headers = new HttpHeaders();
        byte[] arr = new byte[32];
        new Random().nextBytes(arr);
        headers.set("status", String.valueOf(HttpStatus.ACCEPTED));
        headers.set("code-type", "JAVA_11.0.9+1");
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("Awatansa");
        list.add("Vishwakarma");
        list.add("Usha");
        list.add("Awackash");
        map.put("data", list);
        return new HttpEntity<>(map, headers);
    }
}