public class PhoneValidator {
    private boolean validateConsecutiveIdenticalDigits(String[] digits) {
        String past = "";
        for (String digit : digits) {
            if (past.equals(digit)) {
                return false;
            }
            past = digit;
        }
        return true;
    }

    private boolean validateSumParDigits(String[] digits) {
        int sum = 0;
        for (String digit : digits) {
            sum += Integer.parseInt(digit);
        }

        return sum % 2 == 0;
    }

    private boolean validateLastDigitCannotBeTheSameAsTheFirst(String[] digits) {
        final String first = digits[0];
        final String last = digits[digits.length - 1];

        return !first.equals(last);
    }

    public boolean validate(String value) {
        final String[] digits = value.split("");
        return validateConsecutiveIdenticalDigits(digits) && validateSumParDigits(digits) && validateLastDigitCannotBeTheSameAsTheFirst(digits);
    }
}
