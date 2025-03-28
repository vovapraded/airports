package arg.validator;


import arg.parser.RawArgument;
import exception.AppException;
import exception.ValidationException;

public class CommonValidator {

    private final PathValidator pathValidator;
    private final IndexValidator indexValidator;
    public CommonValidator() {
        this.indexValidator = new IndexValidator();
        this.pathValidator = new PathValidator();
    }

    /**
     * Преобразует RawArgument в Argument
     */
    public Argument validate(RawArgument rawArgument) throws AppException {
        Argument argument = new Argument();
        pathValidator.validate(rawArgument, argument);
        indexValidator.validate(rawArgument, argument);
        return argument;
    }
}
