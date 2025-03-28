package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class OutputProcessor {
    private final File outputFile;
    private final Output output;

    public OutputProcessor(File outputFile, Output output) {
        this.outputFile = outputFile;
        this.output = output;
    }

    public void processResult(Result result) {
        output.result().add(result);
    }

    public void saveInFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.writeValue(outputFile, output);
    }
}
