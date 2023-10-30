package calcArabRom;

/*
ТЕСТОВАЯ ЗАДАЧА “КАЛЬКУЛЯТОР”
Описание:

Создай консольное приложение “Калькулятор”. Приложение должно читать из консоли введенные
пользователем строки, числа, арифметические операции проводимые между ними и выводить в
консоль результат их выполнения.
+Реализуй класс Main с методом public static String calc(String input).
+Метод должен принимать строку с арифметическим выражением между двумя числами и
возвращать строку с результатом их выполнения.
+Ты можешь добавлять свои импорты, классы и методы. Добавленные классы не должны иметь
модификаторы доступа (public или другие)



Требования:

  + Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с
     +  двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотри пример)!
     +  Решения, в которых каждое число и арифметическая операция передаются с новой строки
        считаются неверными.
  + Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…)
        числами.
  + Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
        На выходе числа не ограничиваются по величине и могут быть любыми.
  + Калькулятор умеет работать только с целыми числами.
  + Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
        при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение
        и прекратить свою работу.
  + При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно,
        при вводе арабских - ответ ожидается арабскими.
  + При вводе пользователем неподходящих чисел приложение выбрасывает исключение и
        завершает свою работу.
  + При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических
        операций, приложение выбрасывает исключение и завершает свою работу.
  + Результатом операции деления является целое число, остаток отбрасывается.
  + Результатом работы калькулятора с арабскими числами могут быть отрицательные числа
        и ноль.
  + Результатом работы калькулятора с римскими числами могут быть только
        положительные числа, если результат работы меньше единицы, выбрасывается исключение

Пример работы программы:
Input:

1 + 2
Output:

3
Input:

VI / III
Output:

II
Input:

I - II
Output:

throws Exception //т.к. в римской системе нет отрицательных чисел
Input:

I + 1
Output:

throws Exception //т.к. используются одновременно разные системы счисления
Input:

1
Output:

throws Exception //т.к. строка не является математической операцией
Input:

1 + 2 + 3
Output:

throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)

 */


public class Main {


    public static String calc(String input) throws Exception {
        String[] listOperands;
        String operator;

        int operand_1;
        int operand_2;

        int answerArabic;

        String answerRoman;
        String out;

        Check check = new Check();

        check.checkFormat(input);   // Проверка валидности ввода выражения: 2 операнда и между ними
                                    // 1 из возможных операторов.

        ExpressionParsing expressionParsing = new ExpressionParsing();
        listOperands = expressionParsing.getOperands(input);  // Получаем список двух членов выражения.

        operator = expressionParsing.getOperator(input);  // Получаем оператор выражения.

        Action action = new Action();

        if (check.checkArabic(listOperands)) {  //  Проверка на принадлежность к арабской системе.
            operand_1 = Integer.parseInt(listOperands[0]);
            operand_2 = Integer.parseInt(listOperands[1]);

            if (check.CheckOutOfRange(operand_1, operand_2)) {  //  Проверка на принадлежность к диапазону 1-10.
                throw new Exception("Операнд НЕ в диапазоне 1 - 10.");
            }


            answerArabic = action.act(operand_1, operand_2, operator);  //  Вычисляем результат выражения из арабских.
            out = String.valueOf(answerArabic);

        } else {
            if (check.checkRoman(listOperands)) {  //  Проверка на принадлежность к римской системе.

                Translate translate = new Translate();
                operand_1 = translate.romanToArabic(listOperands[0]);
                operand_2 = translate.romanToArabic(listOperands[1]);


                answerArabic = action.act(operand_1, operand_2, operator);
                answerRoman = translate.arabicToRoman(answerArabic);
                out = answerRoman;


            } else {
                throw new Exception("Используются одновременно разные системы счисления");
            }

        }
        return out;
    }


    public static void main(String[] args) throws Exception {

        Input in = new Input();
        String expression = in.getExpression();

        System.out.println(calc(expression));

    }

}
