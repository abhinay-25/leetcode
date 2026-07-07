class Solution {
    public long sumAndMultiply(int n) {

        String num = String.valueOf(n);
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {

            if (num.charAt(i) != '0') {
                str.append(num.charAt(i));
            }
        }

        long product = 0;

        for (int i = 0; i < str.length(); i++) {
            product += (str.charAt(i) - '0');
        }

        if (str.length() == 0) {
            return 0;
        }

        return product * Long.parseLong(str.toString());
    }
}