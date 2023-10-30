package calcArabRom;

class Translate {

    int arabicNum;
    String answerRoman;

    String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] dec = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};


    int romanToArabic(String roman) throws Exception {  // Проверка на принадлежность диапазону I - X и валидность
                                                        // представления римскими чисел от 1 до 10.

        for (int i = 1; i < 11; i++) {
            if (roman.equals(units[i])) {
                arabicNum = i;
                return arabicNum;
            }

        }
        throw new Exception("Операнд не в диапазоне I - X, либо недопустимое римское.");

    }


    String arabicToRoman(int answer) throws Exception {
        if (answer <= 0) {
            throw new Exception("В римской системе нет отрицательных чисел и нуля");
        }

        int d = answer / 10;
        int u = answer % 10;

        // Итоговая строка будет состоять из конкатенации двух строк:
        // dec[d] представляет десятки, units[u] представляет единицы.
        answerRoman = dec[d] + units[u];
        return answerRoman;
    }

}
