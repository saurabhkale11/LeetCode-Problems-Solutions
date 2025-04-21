public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + currentLine.size() + word.length() > maxWidth) {
                result.add(justifyLine(currentLine, currentLength, maxWidth));
                currentLine = new ArrayList<>();
                currentLength = 0;
            }
            currentLine.add(word);
            currentLength += word.length();
        }

        result.add(leftJustify(currentLine, maxWidth));
        return result;
    }

    private String justifyLine(List<String> line, int lineLength, int maxWidth) {
        if (line.size() == 1) {
            return line.get(0) + " ".repeat(maxWidth - lineLength);
        }

        int totalSpaces = maxWidth - lineLength;
        int spaceBetweenWords = totalSpaces / (line.size() - 1);
        int extraSpaces = totalSpaces % (line.size() - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));
            if (i < line.size() - 1) {
                int spacesToAdd = spaceBetweenWords + (i < extraSpaces ? 1 : 0);
                sb.append(" ".repeat(spacesToAdd));
            }
        }
        return sb.toString();
    }

    private String leftJustify(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (String word : line) {
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" ".repeat(maxWidth - sb.length()));
        return sb.toString();
    }
}
