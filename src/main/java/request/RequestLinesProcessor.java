package request;

import data.Data;
import output.OutputProcessor;
import output.Result;
import request.line.RequestLineNumberProcessor;
import request.line.RequestLineProcessor;
import request.line.RequestLineStringProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RequestLinesProcessor {
    private RequestLineProcessor requestLineProcessor;

    public void processLines(File inputFile, Data data, OutputProcessor outputProcessor) throws IOException {
        initRequestProcessor(data);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var startTime = System.currentTimeMillis();
                List<Integer> resultList = requestLineProcessor.processRequest(line);
                var result = new Result(line, resultList, (int) (System.currentTimeMillis() - startTime));
                outputProcessor.processResult(result);
            }
        }
    }

    private void initRequestProcessor(Data data) {
        String firstKey = data.data().keySet().iterator().next();
        if (isDouble(firstKey)) {
            requestLineProcessor = new RequestLineNumberProcessor(data.data());
        } else {
            requestLineProcessor = new RequestLineStringProcessor(data.data());
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
