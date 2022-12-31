package com.coronavirus.tracker.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GitHUB", url = "${GIT_HUB_BASE_URL}")
public interface GitHubClient {

    @GetMapping("/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/{fileName}")
    String fetchCoronaVirusData(@PathVariable(value = "fileName") final String fileName);
}
