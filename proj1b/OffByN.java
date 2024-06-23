public class OffByN implements CharacterComparator {

    private final int n;

    public OffByN(int offside) {
        n = offside;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == n || x - y == -n;
    }

}
