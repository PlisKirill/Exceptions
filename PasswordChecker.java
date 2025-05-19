public class PasswordChecker {

    private int minLength = 0;
    private int maxRepeats = 0;

    public void setMinLength(int minLength) {
        if (minLength <= 0){
            throw new IllegalArgumentException("Недопустимое значение!");
        } else this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0){
            throw new IllegalArgumentException("Недопустимое значение!");
        } else this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLength == 0 || maxRepeats == 0) {
            throw new IllegalStateException("Не все параметны заданы!");
        }
        if (password.length() >= minLength) {
            int count = 1;
            for (int i = 1; i < password.length(); i++) {
                if (password.charAt(i) == password.charAt(i - 1)) {
                    count ++;
                    if (count > maxRepeats) {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}
