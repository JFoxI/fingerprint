package ee.jaanusrebane.fingerprint.util;

/**
 * @author Jaanus Rebane
 */
public class EncodeMapper {

    public static String encodeText(String input) throws Exception {
        char[] chars = input.toCharArray();
        StringBuilder result = new StringBuilder("\u00A0");
        for (char ch: chars) {
            if (ch == 'a') {
                result.append('\u0001');
            } else if (ch == 'b') {
                result.append('\u0002');
            } else if (ch == 'c') {
                result.append('\u0003');
            } else if (ch == 'd') {
                result.append('\u0004');
            } else if (ch == 'e') {
                result.append('\u0005');
            } else if (ch == 'f') {
                result.append('\u0006');
            } else if (ch == 'g') {
                result.append('\u0007');
            } else if (ch == 'h') {
                result.append('\u0008');
            } else if (ch == 'i') {
                result.append('\u0009');
            } else if (ch == 'j') {
                result.append('\u000B');
            } else if (ch == 'k') {
                result.append('\u000C');
            } else if (ch == 'l') {
                result.append('\u000E');
            } else if (ch == 'm') {
                result.append('\u000F');
            } else if (ch == 'n') {
                result.append('\u0010');
            } else if (ch == 'o') {
                result.append('\u0011');
            } else if (ch == 'p') {
                result.append('\u0012');
            } else if (ch == 'q') {
                result.append('\u0013');
            } else if (ch == 'r') {
                result.append('\u0014');
            } else if (ch == 's') {
                result.append('\u0015');
            } else if (ch == 't') {
                result.append('\u0016');
            } else if (ch == 'u') {
                result.append('\u0017');
            } else if (ch == 'v') {
                result.append('\u0018');
            } else if (ch == 'w') {
                result.append('\u0019');
            } else if (ch == 'x') {
                result.append('\u001A');
            } else if (ch == 'y') {
                result.append('\u001B');
            } else if (ch == 'z') {
                result.append('\u001C');
            } else {
                throw new Exception("Bad input");
            }
        }
        return result.toString();
    }

    public static String decodeText(String input) {
        char[] chars = input.toCharArray();
        StringBuilder result = new StringBuilder("\u00A0");
        for (char ch: chars) {
            if (ch == '\u0001') {
                result.append('a');
            } else if (ch == '\u0002') {
                result.append('b');
            } else if (ch == '\u0003') {
                result.append('c');
            } else if (ch == '\u0004') {
                result.append('d');
            } else if (ch == '\u0005') {
                result.append('e');
            } else if (ch == '\u0006') {
                result.append('f');
            } else if (ch == '\u0007') {
                result.append('g');
            } else if (ch == '\u0008') {
                result.append('h');
            } else if (ch == '\u0009') {
                result.append('i');
            } else if (ch == '\u000B') {
                result.append('j');
            } else if (ch == '\u000C') {
                result.append('k');
            } else if (ch == '\u000E') {
                result.append('l');
            } else if (ch == '\u000F') {
                result.append('m');
            } else if (ch == '\u0010') {
                result.append('n');
            } else if (ch == '\u0011') {
                result.append('o');
            } else if (ch == '\u0012') {
                result.append('p');
            } else if (ch == '\u0013') {
                result.append('q');
            } else if (ch == '\u0014') {
                result.append('r');
            } else if (ch == '\u0015') {
                result.append('s');
            } else if (ch == '\u0016') {
                result.append('t');
            } else if (ch == '\u0017') {
                result.append('u');
            } else if (ch == '\u0018') {
                result.append('v');
            } else if (ch == '\u0019') {
                result.append('w');
            } else if (ch == '\u001A') {
                result.append('x');
            } else if (ch == '\u001B') {
                result.append('y');
            } else if (ch == '\u001C') {
                result.append('z');
            }
        }
        return result.toString();
    }

    public static String decodeModifiedText( String input ) {
        if (input.endsWith("=")) {
            input = input.substring(0, input.length() - 1);
        }
        input = input.replaceAll("%01", "a");
        input = input.replaceAll("%02", "b");
        input = input.replaceAll("%03", "c");
        input = input.replaceAll("%04", "d");
        input = input.replaceAll("%05", "e");
        input = input.replaceAll("%06", "f");
        input = input.replaceAll("%07", "g");
        input = input.replaceAll("%08", "h");
        input = input.replaceAll("%09", "i");
        input = input.replaceAll("%0B", "j");
        input = input.replaceAll("%0C", "k");
        input = input.replaceAll("%0E", "l");
        input = input.replaceAll("%0F", "m");
        input = input.replaceAll("%10", "n");
        input = input.replaceAll("%11", "o");
        input = input.replaceAll("%12", "p");
        input = input.replaceAll("%13", "q");
        input = input.replaceAll("%14", "r");
        input = input.replaceAll("%15", "s");
        input = input.replaceAll("%16", "t");
        input = input.replaceAll("%17", "u");
        input = input.replaceAll("%18", "v");
        input = input.replaceAll("%19", "w");
        input = input.replaceAll("%1A", "x");
        input = input.replaceAll("%1B", "y");
        input = input.replaceAll("%1C", "z");
        return input;
    }
}
