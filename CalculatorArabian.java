package arabian; //название пакета, с которым мы работаем, в нем все файлы с которым мы работаем



import java.util.Scanner; //берем информацию от пользователя 

public class CalculatorArabian { // класс
    public static void main(String[] args) { //метод, вызывается при старте программы
        //2+3
        //V-VII
        Converter converter = new Converter();// обращение к другому файлу Converter
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        //Определяем арифметическое действие:
        int actionIndex=-1; // переменная, с большими значениями
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия, завершаем программу
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }
        //"2-4".split("-")-> {"2", "4"}
        String[] data = exp.split(regexActions[actionIndex]);
        //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

            //конвертируем арабские числа из строки в число
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);

            //выполняем с числами арифметическое действие
            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            //если числа были арабские, возвращаем результат в арабском числе
            System.out.println(result);

        }else{
            System.out.println("Числа должны быть в одном формате");
        }


    }
}
