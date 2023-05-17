package View;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Programm implements Scan{
    private List<String> exp = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private int result;
    private String typeNumber;
    public String getTypeNumber() {
        return typeNumber;
    }
    public List<String> getExp() {
        return exp;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getResult() {
        return result;
    }

    // Сплитуем
    public  List<String> expSplit(String text) {
        String trimText = text.trim();
        exp.addAll(Arrays.asList(trimText.split(" ")));
        return exp;
    }
    // Делаем переменную строку
    public List<String> textSort(List<String> text){
        if (text.size() == 3){
            for (int item = 0; item < text.size(); item++) {
                exp.add(text.get(item));
                item++;
            }
        }else{
            System.out.println("Input:");
            System.out.println("throws Exception //т.к. Вы ввели не допустимое выражение");
            System.exit(0);
        }
        return exp;
    }
    // Проверка - римские или арабские

    public void roumAndArab(List <String> exp){
        Action action = new Action();
        if (action.isNumeric(exp.get(0)) && action.isNumeric(exp.get(1))){
            for (int item = 0; item < exp.size(); item++) {
                    numbers.add(Integer.parseInt(exp.get(item)));
            }
            typeNumber = "Arab";
        }
        else if (Action.Arab(exp.get(0)) && Action.Arab(exp.get(1))){
            numbers.add(RoumNumbers.valueOf(exp.get(0)).getNum());
            numbers.add(RoumNumbers.valueOf(exp.get(1)).getNum());
            typeNumber = "Roume";
        }
    }
    // Проверяем является ли подходящим число
    public List<Integer> dressCodeNumbers(List<Integer> numbers){
        for (int item: numbers) {
            if (item < 1 || item > 10){
                System.out.println("Input:");
                System.out.println("throws Exception //т.к. по условию задания числа могут быть только от 1 до 10");
                System.exit(0);
            }
        }
        return numbers;
    }
    // Считаем
    public int eqation(List<String> operand, List<Integer> numbers) {
            switch (operand.get(1)) {
            case "+":
                result = numbers.get(0) + numbers.get(1);
                return result;
            case "-":
                result = numbers.get(0) - numbers.get(1);
                return result;
            case "/":
                result = numbers.get(0) / numbers.get(1);
                return result;
            case "*":
                result = numbers.get(0) * numbers.get(1);
                return result;
            default:
                System.out.println("Input:");
                System.out.println("throws Exception //т.к. введен не верный арифметический оператор");
                System.exit(0);
        }
        return result;
    }
    // Выводим
    public void results(int result, String typeNumber){
        if (typeNumber.equals("Arab")){
            System.out.println(result);
        }
        else if (result > 0){
            String[] str = Integer.toString(result).split("");
            if (str.length == 1){
                RoumNumbers roumNumbers = RoumNumbers.findByKey(result);
                System.out.println(roumNumbers);
            }
            else if(str.length == 2){
                RoumNumbers roumNumbers1 = RoumNumbers.findByKey(Integer.parseInt(str[0]) * 10);
                if (Integer.parseInt(str[1]) != 0) {
                    RoumNumbers roumNumbers2 = RoumNumbers.findByKey(Integer.parseInt(str[1]));
                    typeNumber = roumNumbers1.name();
                    typeNumber += roumNumbers2.name();
                    System.out.println(typeNumber);
                }
                else {
                    System.out.println(roumNumbers1);
                }


            }else if(str.length == 3){
                System.out.println("D");
            }
        }
        else {
            System.out.println("Input:");
            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел, либо нуля");
        }
    }
}
