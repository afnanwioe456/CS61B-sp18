public class OffByN implements CharacterComparator{

    int n;

    OffByN(int offside){
        n = offside;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == n || x - y == -n;
    }

}
