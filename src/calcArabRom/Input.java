package calcArabRom;

/*
Ввод выражения из консоли и удаление ведущих и заключающих пробелов.
 */

import java.util.Scanner;

class Input {
    String getExpression() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = in.nextLine();
        in.close();

        return expression.trim();

    }

}
