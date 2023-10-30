package calcArabRom;


class Check {

    // Проверка на соответствие формату введённого выражения.
    boolean checkFormat(String expression) throws Exception {
        String[] listFormat = expression.split("\\w+\\s*[\\-+*/]\\s*\\w+");

        if (listFormat.length != 0) {
            throw new Exception("Выражение не соответствует формату ввода.");
        } else {
            return true;
        }

    }


    //Проверка является ли символ строки цифрой.
    boolean checkArabic(String[] listOperands) {

        for (int operandNum = 0; operandNum < 2; operandNum++) {

            for (int i = 0; i < listOperands[operandNum].length(); i++) {
                char currentChar = listOperands[operandNum].charAt(i);
                if (currentChar > 47 && currentChar < 58) {
                } else {
                    return false;
                }

            }

        }
        return true;

    }


    //Проверка является ли символ строки римской цифрой.
    boolean checkRoman(String[] listOperands) {
        for (int operandNum = 0; operandNum < 2; operandNum++) {

            for (int i = 0; i < listOperands[operandNum].length(); i++) {
                char currentChar = listOperands[operandNum].charAt(i);
                if (currentChar == 'I' || currentChar == 'V' || currentChar == 'X') {

                } else {
                    return false;
                }
            }

        }
        return true;
    }


    // Проверка допустимого диапазона вводимых значений.
    boolean CheckOutOfRange(int op1, int op2) {

        return (op1 < 1 || op1 > 10) || (op2 < 1 || op2 > 10);

    }

}
