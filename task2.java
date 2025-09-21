import java.util.InputMismatchException;
import java.util.Scanner;

class task2 {
    public static void main(String[] args) {
        System.out.println("Задание №2. Курс валют");

        //заданные валюты
        final float USD = 83.59f;
        final float EUR = 98.88f;
        final float JPY = 0.565f;
        final float GBP = 113.28f;
        final float AUD = 55.14f;

        while(true) {

            try {
                //Ввод суммы
                Scanner input = new Scanner(System.in);
                System.out.print("Введите сумму в рублях (для указания дробной части используйте запятую): ");
                float RUB = input.nextFloat();

                System.out.println("В какую валюту конвертировать?");
                System.out.println("0 - USD, 1 - EUR, 2 - JPN, 3 - GBP, 4 - AUD");
                int currency = input.nextInt();

                switch(currency) {
                    case 0: {
                        System.out.println("В рублях: " + RUB);
                        System.out.println("В долларах: " + RUB / USD);
                        break;
                    }
                    case 1: {
                        System.out.println("В рублях: " + RUB);
                        System.out.println("В евро: " + RUB / EUR);
                        break;
                    }
                    case 2: {
                        System.out.println("В рублях: " + RUB);
                        System.out.println("В юанях: " + RUB / JPY);
                        break;
                    }
                    case 3: {
                        System.out.println("В рублях: " + RUB);
                        System.out.println("В фунтах" + RUB / GBP);
                        break;
                    }
                    case 4: {
                        System.out.println("В рублях: " + RUB);
                        System.out.println("В австралийских долларах: " + RUB / USD);
                        break;
                    }
                    default:
                        System.out.println("Нет указанной валюты");
                }


                System.out.println("Выйти из программы?");
                System.out.println("0 - Да, Другое целое число - Нет");
                int exit = input.nextInt();

                if (exit == 0)
                    break;
            }

            catch (InputMismatchException ex) {
                System.out.println("Ошибка! введено некорректное значение.");
            }

        }
    }
}