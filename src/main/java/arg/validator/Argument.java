package arg.validator;


import lombok.*;

import java.io.File;



/**
 * Аргументы программы
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Argument {
    private File data;
    private int indexedColumnId ;
    private File input;
    private File output;

}
