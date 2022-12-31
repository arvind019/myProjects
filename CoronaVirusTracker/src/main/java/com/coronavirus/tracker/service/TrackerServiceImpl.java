package com.coronavirus.tracker.service;

import com.coronavirus.tracker.model.Constants;
import com.coronavirus.tracker.model.CoronaDataDto;
import com.coronavirus.tracker.proxy.GitHubHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TrackerServiceImpl implements ITrackerService {

    @Autowired
    private GitHubHelper gitHubHelper;

    private List<CoronaDataDto> allDailyCasesData = new ArrayList<>();

    @PostConstruct
    private void prepareCoronaVirusData() throws IOException {
        List<CoronaDataDto> data = gitHubHelper.fetchCoronaVirusData();
        Map<String, List<CoronaDataDto>> dataMapCountry = data.stream()
                .collect(Collectors.groupingBy(CoronaDataDto::getCountryName));
        dataMapCountry.forEach((name, list) ->
        {
            CoronaDataDto dto = new CoronaDataDto();
            dto.setCountryName(name);
            final Long[] count = {0L,0L};
            list.forEach(entity -> {
                count[0] =+ Long.parseLong(entity.getDailyCount());
                count[1] =+ Long.parseLong(entity.getTotalCount());
            });
            dto.setDailyCount(String.valueOf(count[0]));
            dto.setTotalCount(String.valueOf(count[1]));
            allDailyCasesData.add(dto);
        });
    }

    @Override
    public String getCoronaVirusData(final Model model) {
        final Long totalCases = allDailyCasesData.stream()
                .mapToLong(entity -> Long.parseLong(entity.getTotalCount())).sum();
        final Long totalDailyCount = allDailyCasesData.stream()
                .mapToLong(entity -> Long.parseLong(entity.getDailyCount())).sum();
        model.addAttribute(Constants.TOTAL_DAILY_COUNT, totalDailyCount);
        model.addAttribute(Constants.TOTAL_CASES, totalCases);
        model.addAttribute(Constants.DAILY_CASES, allDailyCasesData);
        return Constants.HOME_HTML_FILE_NAME;
    }
}
