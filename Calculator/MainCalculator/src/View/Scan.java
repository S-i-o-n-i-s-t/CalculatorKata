package View;

import java.util.Scanner;

public interface Scan {
    default String text(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }
}
