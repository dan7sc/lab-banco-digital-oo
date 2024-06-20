import java.util.Scanner;

public abstract class App {

    private static void criarCliente(Banco banco, Scanner scanner) {
        System.out.print("Informe cpf: ");
        String cpf = scanner.next();
        if (banco.isCliente(cpf)) {
            System.out.println("Já existe cliente com este cpf.");
            return;
        }

        System.out.print("Informe nome: ");
        String nome = scanner.next();

        Cliente cliente = new Cliente(cpf, nome);
        banco.setCliente(cliente);
    }

    private static void criarConta(Banco banco, Scanner scanner) {
        System.out.print("Informe cpf: ");
        String cpf = scanner.next();
        if (!banco.isCliente(cpf)) {
            System.out.println("Não existe cliente com este cpf.");
            return;
        }

        System.out.print("Informe o tipo de conta [0-Corrente, 1-Poupanca]: ");
        int tipoConta = Integer.parseInt(scanner.next());
        if (tipoConta < 0 || tipoConta > 1) {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        Conta conta;
        Cliente cliente = banco.getCliente(cpf);
        if (tipoConta == 0) {
            conta = new ContaCorrente(cliente);
        } else {
            conta = new ContaPoupanca(cliente);
        }
        cliente.setConta(conta);
        banco.setConta(conta);
    }

    private static void depositar(Banco banco, Scanner scanner) {
        System.out.print("Informe cpf: ");
        String cpf = scanner.next();
        if (!banco.isCliente(cpf)) {
            System.out.println("Não existe cliente com este cpf.");
            return;
        }
        Cliente cliente = banco.getCliente(cpf);

        System.out.print("Informe numero da conta: ");
        Integer numeroConta = Integer.parseInt(scanner.next());
        Conta conta = cliente.getConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não existe.");
            return;
        }

        System.out.print("Informe valor a depositar: ");
        double valor = Double.parseDouble(scanner.next());
        conta.depositar(valor);
    }

    private static void sacar(Banco banco, Scanner scanner) {
        System.out.print("Informe cpf: ");
        String cpf = scanner.next();
        if (!banco.isCliente(cpf)) {
            System.out.println("Não existe cliente com este cpf.");
            return;
        }
        Cliente cliente = banco.getCliente(cpf);

        System.out.print("Informe numero da conta: ");
        Integer numeroConta = Integer.parseInt(scanner.next());
        Conta conta = cliente.getConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não existe.");
            return;
        }

        System.out.print("Informe valor a sacar: ");
        double valor = Double.parseDouble(scanner.next());
        conta.sacar(valor);
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("Bancaum");
        Menu menu = new Menu();

        while(true) {
            menu.show();
            String input = scanner.next();

            if (input.equals("d")) {
                depositar(banco, scanner);
            } else if (input.equals("s")) {
                sacar(banco, scanner);
            } else if (input.equals("e")) {
                System.out.println("Extrato");
            } else if (input.equals("u")) {
                criarCliente(banco, scanner);
            } else if (input.equals("c")) {
                criarConta(banco, scanner);
            } else if (input.equals("lu")) {
                System.out.println("Listar usuarios");
                System.out.println(banco.getClientes());
            } else if (input.equals("lc")) {
                System.out.println("Listar contas");
                System.out.println(banco.getContas());
            } else if (input.equals("q")) {
                System.out.println("Sair");
                break;
            } else {
                System.out.println("Operação inválida, por favor selecione novamente a operação desejada.");
            }
        }
        scanner.close();
    }
}