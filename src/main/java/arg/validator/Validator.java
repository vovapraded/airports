package arg.validator;


import arg.parser.RawArgument;
import exception.ValidationException;

public interface Validator {
    void validate(RawArgument rawArgument, Argument argument) throws ValidationException;
}
