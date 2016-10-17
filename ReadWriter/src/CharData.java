public class CharData implements Data<Character> {
    private char[] buffer = new char[]{'a','a','a','a','a'};


    @Override
    public void put(Character c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
        }
    }

    public String get() {
        StringBuilder sb = new StringBuilder();
        for (char c : buffer) {
            sb.append(c);
        }
        return sb.toString();
    }
}
