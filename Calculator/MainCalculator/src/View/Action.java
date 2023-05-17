package View;

public class Action {
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            System.out.println("Input:");
            System.out.println("throws Exception //т.к. значение не может быть null");
            System.exit(0);
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    static public boolean Arab(String value) {
        try {
            RoumNumbers.valueOf(value);
            return true;
        } catch (IllegalArgumentException x) {
            System.out.println("Input:");
            System.out.println("throws Exception //т.к. вы ввели не число, либо разные системы исчисления");
            System.exit(0);
            return false;
        }
    }
}
