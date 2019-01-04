public class plasOne {
    public int[] plusOne(int[] digits) {
        int tag = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9)
                tag = 1;
        }
        if (tag == 1) {
            int jin = 1;
            int[] res = new int[digits.length];
            for (int i = digits.length - 1; i > -1; i--) {
                res[i] = (digits[i] + jin) % 10;
                jin = (digits[i] + jin) / 10;
            }
            return res;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
    }
}
