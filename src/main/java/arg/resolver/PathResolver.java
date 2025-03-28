package arg.resolver;

import exception.UnexpectedException;
import exception.ValidationException;

import java.io.File;
import java.io.IOException;

public class PathResolver  {

    public File resolvePath(String path) throws ValidationException {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return file;
        } else {
            throw new ValidationException("File not found: " + path);
        }
    }

    public File resolveOrCreate(String path) throws ValidationException, UnexpectedException {
        File file = new File(path);
        try {
            if (file.exists()) {
                return file;
            } else {
                // Создаём родительские директории, если нужно
                File parent = file.getParentFile();
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }

                // Пытаемся создать файл
                if (file.createNewFile()) {
                    return file;
                } else {
                    throw new UnexpectedException("The consistency of the file's existence is broken: " + path);
                }
            }
        } catch (IOException e) {
            throw  new ValidationException("Ошибка при создании файла: " + e.getMessage());
        }
    }
}
