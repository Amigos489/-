import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

class task3 {
    public static void main(String[] args)
    {
        boolean ExitProgram = false;

        while (!ExitProgram) {
            try {
                System.out.println("Задание №3. Генератор паролей");
                System.out.println("Укажите длину пароля: (8 - 12)");
                Scanner input = new Scanner(System.in);
                int SizePassord = input.nextInt();
                if (SizePassord > 12) {
                    SizePassord = 12;
                }
                if (SizePassord < 8) {
                    SizePassord = 8;
                }

                Random rn = new Random();
                String password = "";

                int cntNum = rn.nextInt(3 - 1 + 1) + 1;
                int cntSpecialSymvol = rn.nextInt(8 - 4 + 1) + 4;
                

                for (int i = 0; i < SizePassord; ++i) {
                    if (cntSpecialSymvol == i) {
                        password += (char) (rn.nextInt(38 - 33 + 1) + 33);
                        continue;
                    }

                    if (cntNum == i) {
                        password += rn.nextInt(10);
                        continue;
                    }

                    int TypeSymvol = rn.nextInt(2);
                    switch(TypeSymvol)
                    {
                        case 0: {
                            char BigLetter = (char) (rn.nextInt(90 - 65 + 1) + 65);
                            password += BigLetter;
                            break;
                        }
                        case 1: {
                            char LitleLetter = (char) (rn.nextInt(122 - 97 + 1) + 97);
                            password += LitleLetter;
                            break;
                        }
                    }

                }

                System.out.println("Сгенерированный пароль: " + password);
                System.out.println("Повторить генерацию? 0 - Да, Другое целое число - Нет");
                int Exit = input.nextInt();
                if (Exit == 0)
                    ExitProgram = false;
                else
                    ExitProgram = true;

                
                

            }

            catch(InputMismatchException ex) {
                System.out.println("Ошибка! введено некорректное значение.");
            }


        }
    
}
}
