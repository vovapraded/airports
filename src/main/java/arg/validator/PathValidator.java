package arg.validator;


import java.util.List;

import arg.ArgumentName;
import arg.parser.RawArgument;

import arg.resolver.PathResolver;
import exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.vfs2.FileObject;

@RequiredArgsConstructor
public class PathValidator implements Validator {
    private final PathResolver pathResolver = new PathResolver();

    /**
     * Валидирует аргумент path и устанавливает его в argument
     */
    @Override
    public void validate(RawArgument rawArgument, Argument argument) throws ValidationException {
        String dataPath = rawArgument.dataPath();
        String inputPath = rawArgument.inputPath();
        String outputPath = rawArgument.outputPath();

        argument.data(pathResolver.resolvePath(dataPath));
        argument.input(pathResolver.resolvePath(inputPath));
        argument.output(pathResolver.resolveOrCreate(outputPath));
    }

}
