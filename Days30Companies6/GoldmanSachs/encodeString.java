package Days30Companies6.GoldmanSachs;

public class encodeString {

    String encode(String str) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length();) {

            ans.append(str.charAt(i));
            int count = 1;
            i++;
            while (i < str.length() && str.charAt(i - 1) == str.charAt(i)) {
                i++;
                count++;
            }
            ans.append(count);

        }

        return ans.toString();

    }
}
