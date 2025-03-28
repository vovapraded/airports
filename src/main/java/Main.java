
import java.io.IOException;
import java.util.ArrayList;

import arg.parser.ArgumentParser;
import arg.parser.RawArgument;
import arg.validator.Argument;
import arg.validator.CommonValidator;

import data.Data;
import data.DataProcessor;

import input.InputProcessor;
import lombok.experimental.UtilityClass;
import output.Output;
import output.OutputProcessor;

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
            InputProcessor inputProcessor = new InputProcessor(outputProcessor);

            inputProcessor.processFile(argument.input(),  data);
            outputProcessor.saveInFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

}
