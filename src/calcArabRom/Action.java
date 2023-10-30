package calcArabRom;

class Action {
    int result;

    int act(int operand_1, int operand_2, String operator) {

        switch (operator) {
            case "-": {
                result = operand_1 - operand_2;
                return result;
            }
            case "+": {
                result = operand_1 + operand_2;
                return result;
            }
            case "*": {
                result = operand_1 * operand_2;
                return result;
            }
            case "/": {

                result = operand_1 / operand_2;
                return result;
            }
            default:
                throw new IllegalStateException("Недопустимый оператор: " + operator);
        }

    }

}


