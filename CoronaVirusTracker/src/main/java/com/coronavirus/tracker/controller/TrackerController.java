package com.coronavirus.tracker.controller;

import com.coronavirus.tracker.service.ITrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("coronavirus/tracker")
public class TrackerController {

    @Autowired
    private ITrackerService trackerService;

    @GetMapping("/")
    public String getCoronaVirusData(final Model model) {
        return trackerService.getCoronaVirusData(model);
    }
}
