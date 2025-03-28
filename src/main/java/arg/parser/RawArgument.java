package arg.parser;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Аргументы программы в строковом представлении
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawArgument {
    private String dataPath;
    private String indexedColumnId ;
    private String inputPath;
    private String outputPath;
}
