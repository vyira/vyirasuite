package com.vyira.vyirasuite.quizserver.ws;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/${api.version}/")
@RequiredArgsConstructor
public class GenericController {

    private final DiscoveryClient discoveryClient;

    /**
     * Generic API to talk with UI-component
     *
     * @return String
     */
    @GetMapping("/polling/")
    public String polling() {
        return "Success";
    }


    /**
     * Eureka Client Registry
     *
     * @param applicationName Defined in application.yml
     * @return List of ServiceInstance - Eureka
     */
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    // TODO: Create bunch of Generic Controller
}
