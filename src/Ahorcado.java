import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String secretWord = "inteligencia";
        int maxAttempts = 10;
        int attempts = 0;
        boolean isCorrect = false;

        char[] wordGuessed = new char[secretWord.length()];

        for (int i = 0; i < wordGuessed.length; i++) {
            wordGuessed[i] = '_';
        }

        while (!isCorrect && attempts < maxAttempts) {
            System.out.println(
                    "Palabra a adivinar: " + String.valueOf(wordGuessed) + " (" + secretWord.length() + " letras)");
            System.out.print("Introduce una letra, por favor: ");
            char word = Character.toLowerCase(sc.next().charAt(0));

            boolean wordCorrect = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == word) {
                    wordGuessed[i] = word;
                    wordCorrect = true;
                }
            }

            if (!wordCorrect) {
                attempts++;
                System.out.println("Incorrecto, te quedan " + (maxAttempts - attempts) + " Intentos");
            }

            if (String.valueOf(wordGuessed).equals(secretWord)) {
                isCorrect = true;
                System.out.println("Felicidades has adivinado la palabra correctamente, la palabra es: " + secretWord);
            }
        }

        if (!isCorrect) {
            System.out.println("Perdiste");
        }

        sc.close();
    }
}
