package extra;

import java.util.stream.IntStream;

public class Mirror {

    public StringBuilder stringMirror(String text) {
        StringBuilder mirrored = new StringBuilder();
        for (int i = text.length(); i > 0; i--) {
            mirrored.append(text.charAt(i - 1));

        }

        return mirrored;
    }

}
