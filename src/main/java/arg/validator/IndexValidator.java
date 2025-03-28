package arg.validator;

import arg.parser.RawArgument;
import exception.ValidationException;

public class IndexValidator implements Validator {
    @Override
    public void validate(RawArgument rawArgument, Argument argument) throws ValidationException {
        try {
            int indexedColumnId = Integer.parseInt(rawArgument.indexedColumnId());
            argument.indexedColumnId(indexedColumnId);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid indexed column id: " + rawArgument.indexedColumnId());
        }
    }
}
