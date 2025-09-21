import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.text.WrappedPlainView;

public class task1 {
    public static void main(String[] args) {
        System.out.println("Задание 1: Виселица");
        System.out.println("Обратите внимание! слова загадываются на английском языке и все со строчной буквы");
        final String[] ArrayForWord = {"bunny", "vinaigrette", "binoculars", "lamp", "limo", "steak", "borodino", "pentium", "ventilator", "winner"};
        Random rn = new Random();
        boolean PresenceLetter = false;
        boolean ExitGame = false;

        while(!ExitGame) {
            String WordForGame = ArrayForWord[rn.nextInt(9)];
            char[] ArrayWord = new char[WordForGame.length()];
            int CntQuessedLetter = WordForGame.length();
            int CntLive = 5;
            Scanner input = new Scanner(System.in);

            for (int i = 0; i < WordForGame.length(); ++i) {
                ArrayWord[i] = '_';
                System.out.print(ArrayWord[i]);
            }
            System.out.println();

            while(CntLive > 0 || CntQuessedLetter > 0) {

                System.out.println("Осталось жизней: " + CntLive);

                try {
                    System.out.print("Введите букву: ");
                    String LetterString = input.nextLine();
                    char Letter = LetterString.charAt(0);

                    PresenceLetter = false;
                    for (int i = 0; i < WordForGame.length(); ++i) {

                        if (Letter == (char) WordForGame.charAt(i)) {
                            System.out.println("Есть такая буква!");
                            if (ArrayWord[i] == '_') {
                                CntQuessedLetter -= 1;
                                ArrayWord[i] = Letter;
                                PresenceLetter = true;
                                continue;
                            }
                            else {
                                System.out.println("Вы уже указывали эту букву!");
                                PresenceLetter = true;
                                continue;
                            }
                        }

                        if (WordForGame.length() == (i + 1) && PresenceLetter == false) {
                            System.out.println("Нет буквы!");
                            CntLive -= 1;
                        }
                    }

                    for (int i = 0; i < WordForGame.length(); ++i) {
                        System.out.print(ArrayWord[i]); 
                    }
                    System.out.println();
                    
                }
            

            catch(InputMismatchException ex) {
                System.out.println("Некорректное значение!");
            }

            if(CntLive <= 0) {
                System.out.println("Вы проиграли");
                System.out.println("Загаданное слово: " + WordForGame);
                break;
            }

            if(CntQuessedLetter == 0) {
                System.out.println("Поздравляем! вы отгадали слово");
                break;
            }

       
            }

            System.out.println("Начать новую игру? 0 - Да, Другое целое число - Нет");
            int Exit = input.nextInt();
            if (Exit == 0)
                ExitGame = false;
            else
                ExitGame = true;

    }

}

}