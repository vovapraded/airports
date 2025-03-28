package arg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ArgumentName {
    DATA,
    INDEXED_COLUMN_ID,
    INPUT_FILE,
    OUTPUT_FILE;

    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", "-");
    }
    public String toCannedString() {
        return "--" + toString();
    }
}
