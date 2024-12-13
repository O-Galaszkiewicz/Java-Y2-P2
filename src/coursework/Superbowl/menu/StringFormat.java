package coursework.Superbowl.menu;

public class StringFormat {

    public int calculateMaxLength(String... strings) {

        int maxLength = 0;

        for (String str : strings) {

            if (str.length() > maxLength) {
                maxLength = str.length();
            }

        }

        return maxLength;

    }

    public String formatWithPadding(String str, int totalWidth) {

        return String.format("%-" + totalWidth + "s", str);

    }

    public String generateMenuSplit(int length) {

        return "+" + "-".repeat(length + 2) + "+";

    }

}
