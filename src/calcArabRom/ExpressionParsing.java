package calcArabRom;

class ExpressionParsing {

    String[] getOperands(String expression) {

        String[] listOperands = expression.split("[\\-+*/]");

        for (int i = 0; i < 2; i++) {
            listOperands[i] = listOperands[i].trim();
        }
        return listOperands;
    }

    String getOperator(String expression) {
        String operator = "";

        String[] operators = {"-", "+", "*", "/"};

        for (int i = 0; i < 4; i++) {
            if (expression.contains(operators[i])) {
                operator = operators[i];
                break;
            }

        }

        return operator;
    }
}

