package input;

import data.Data;
import input.request.RequestNumberProcessor;
import input.request.RequestProcessor;
import input.request.RequestStringProcessor;
import output.OutputProcessor;
import output.Result;

import java.io.*;
import java.util.List;

public class InputProcessor {
    private RequestProcessor requestProcessor;
    private final OutputProcessor outputProcessor;

    public InputProcessor(OutputProcessor outputProcessor) {
        this.outputProcessor = outputProcessor;
    }

    public void processFile(File input,  Data data) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(input));
        ) {
            initRequestProcessor(data);
            String line;
            while ((line = reader.readLine()) != null) {
                var startTime = System.currentTimeMillis();
                List<Integer> resultList = requestProcessor.processRequest(line);
                var result = new Result(line, resultList, (int) (System.currentTimeMillis()-startTime));
                outputProcessor.processResult(result);
            }
        }
    }

    private  void initRequestProcessor(Data data) {
        if (isDouble(data.data().keySet().iterator().next())){
            requestProcessor = new RequestNumberProcessor(data.data());
        }else {
            requestProcessor = new RequestStringProcessor(data.data());
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }


}
