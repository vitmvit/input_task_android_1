import java.util.Arrays;
/***********************************************************************************************************************
 Написать функцию, которая на вход принимает номер лотерейного билета и возвращает булевское значение, выигрышный билет
 или нет.

 Входные параметры:
        - Функция должна принимать в качестве входного параметра номер (число)
        лотерейного билета, количество цифр которого чётное от 2 до 8.
 Условия:
        - Выигрышным считается билет, сумма цифр левой половины номера которого
        равна сумме цифр правой половины.
 Возвращаемый результат:
        - только булевское значение: true – в случае, если билет выиграл; false – если не
        выиграл.
***********************************************************************************************************************/
public class Main {

    public static void main(String[] args) {
        int[] ticketArray = {833, 90909, 54, 1212121212};
        for (int number : ticketArray) {
            System.out.println(checkLotteryTicket(number));
        }
    }

    public static boolean checkLotteryTicket(Integer number) {
        int[] ticketNumber = number.toString().chars().map(Character::getNumericValue).toArray();
        if (ticketNumber.length % 2 == 0 && ticketNumber.length >= 2 && ticketNumber.length <= 8) {
            int sumFirst = Arrays.stream(ticketNumber).limit(ticketNumber.length / 2).sum();
            int sumSecond = Arrays.stream(ticketNumber).skip(ticketNumber.length / 2).sum();
            return sumFirst == sumSecond;
        }
        return false;
    }
}