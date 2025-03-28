package arg.parser;

import arg.ArgumentName;

public class ArgumentParser {
    /**
     * Преобразует массив строк в RawArgument
     *
     * @param args массив аргументов
     * @return RawArgument
     */
    public RawArgument parse(String[] args) {
        int i = 0;
        RawArgument rawArgument = new RawArgument();
        while (i < args.length - 1) {
            if (args[i].equals(ArgumentName.DATA.toCannedString())) {
                rawArgument.dataPath(args[i + 1]);
            } else if (args[i].equals(ArgumentName.INDEXED_COLUMN_ID.toCannedString())) {
                rawArgument.indexedColumnId(args[i + 1]);
            } else if (args[i].equals(ArgumentName.INPUT_FILE.toCannedString())) {
                rawArgument.inputPath(args[i + 1]);
            } else if (args[i].equals(ArgumentName.OUTPUT_FILE.toCannedString())) {
                rawArgument.outputPath(args[i + 1]);
            }else {
                i -= 1; // возможно пропустили названия аргумента из-за не корректного ввода
            }
            i += 2;
        }
        return rawArgument;
    }

}
