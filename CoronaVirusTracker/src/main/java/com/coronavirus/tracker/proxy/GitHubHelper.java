package com.coronavirus.tracker.proxy;

import com.coronavirus.tracker.model.Constants;
import com.coronavirus.tracker.model.CoronaDataDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubHelper {

    @Autowired
    private GitHubClient gitHubClient;

    @Value("${covid.cases.file.name}")
    private String fileName;

    public List<CoronaDataDto> fetchCoronaVirusData() throws IOException {
        final String response = gitHubClient.fetchCoronaVirusData(fileName);
        final StringReader input = new StringReader(response);
        final Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(input);
        final List<CoronaDataDto> dataDto = new ArrayList<>();
        for(final CSVRecord record : records) {
            final CoronaDataDto data = new CoronaDataDto();
            data.setCountryName(record.get(Constants.COUNTRY));
            data.setTotalCount(record.get(record.size()-1));
            final Long today = Long.valueOf(data.getTotalCount());
            final Long dayBefore = Long.valueOf(record.get(record.size()-2));
            data.setDailyCount(String.valueOf(today-dayBefore));
            dataDto.add(data);
        }

        return dataDto;
    }
}
