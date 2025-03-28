
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

import arg.parser.ArgumentParser;
import arg.parser.RawArgument;
import arg.validator.Argument;
import arg.validator.CommonValidator;

import data.Data;
import data.DataProcessor;

import lombok.experimental.UtilityClass;
import output.Output;
import output.OutputProcessor;
import request.RequestLinesProcessor;

/**
 * Основной класс программы
 */
@UtilityClass
public class Main {

    public static void main(String[] args){
        try {
            long startTime = System.currentTimeMillis();

            ArgumentParser parser = new ArgumentParser();
            CommonValidator commonValidator = new CommonValidator();
            DataProcessor dataProcessor = new DataProcessor();

            RawArgument rawArgument = parser.parse(args);
            Argument argument = commonValidator.validate(rawArgument);

            Data data = dataProcessor.readCsv(argument.data(), argument.indexedColumnId());
            long endTime = System.currentTimeMillis();


            OutputProcessor outputProcessor = new OutputProcessor(argument.output(), new Output((int) (endTime-startTime),new ArrayList<>() ));
            RequestLinesProcessor requestLinesProcessor = new RequestLinesProcessor();

            requestLinesProcessor.processLines(argument.input(), data, outputProcessor);


            outputProcessor.saveInFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

}
