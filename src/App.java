import java.util.Objects;
import java.util.Scanner;

public abstract class App {

    public static void run() {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while(true) {
            menu.show();
            String input = scanner.next();

            if (input.equals("d")) {
                System.out.println("Depositar");
            } else if (input.equals("s")) {
                System.out.println("Sacar");
            } else if (input.equals("e")) {
                System.out.println("Extrato");
            } else if (input.equals("u")) {
                System.out.println("Criar usuario");
            } else if (input.equals("c")) {
                System.out.println("Criar conta");
            } else if (input.equals("lu")) {
                System.out.println("Listar usuarios");
            } else if (input.equals("lc")) {
                System.out.println("Listar contas");
            } else if (input.equals("q")) {
                System.out.println("Sair");
                break;
            } else {
                System.out.println("Operação inválida, por favor selecione novamente a operação desejada.");
            }

        }
    }
}