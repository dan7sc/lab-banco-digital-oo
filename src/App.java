import java.util.Scanner;

public abstract class App {

    private static void criarCliente(Banco banco, String nome, String cpf) {
        if (banco.isCliente(cpf)) {
            System.out.println("Já existe cliente com este cpf.");
            return;
        }
        Cliente cliente = new Cliente(cpf, nome);
        banco.setCliente(cliente);
    }

    public static void run() {
        Banco banco = new Banco("Bancaum");
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

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
                System.out.print("Informe nome: ");
                String nome = scanner.next();
                System.out.print("Informe cpf: ");
                String cpf = scanner.next();
                criarCliente(banco, nome, cpf);
            } else if (input.equals("c")) {
                System.out.println("Criar conta");
            } else if (input.equals("lu")) {
                System.out.println("Listar usuarios");
                System.out.println(banco.getClientes());
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