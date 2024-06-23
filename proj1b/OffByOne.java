import java.util.List;

public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        List<Integer> offsides = List.of(1, -1, 31, -31, 33, -33);
        return offsides.contains(x - y);
    }

}
