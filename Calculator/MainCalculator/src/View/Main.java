package View;

public class Main {
    public static void main(String[] args) {
        System.out.println("Output:");

        Number number = new Number();

        number.createStr();

        Programm programm1 = new Programm();
        Programm programm2 = new Programm();

        // Сплитуем (храним изначальное уравнение)
        programm1.expSplit(number.getStr());
        // Делаем переменную строку (тут храним две введенные переменные)
        programm2.textSort(programm1.getExp());
        // Проверка "Римские или арабские"
        programm2.roumAndArab(programm2.getExp());
        // Проверяем является ли подходящим число
        programm2.dressCodeNumbers(programm2.getNumbers());
        // Считаем
        programm1.eqation(programm1.getExp(), programm2.getNumbers());
        // Вывод результата
        System.out.println("Input:");
        programm1.results(programm1.getResult(), programm2.getTypeNumber());


    }
}