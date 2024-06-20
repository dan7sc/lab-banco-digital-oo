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

    private static void criarConta(Banco banco, Integer tipo, String cpf) {
        if (tipo < 0 || tipo > 1) {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        if (!banco.isCliente(cpf)) {
            System.out.println("Não existe cliente com este cpf.");
            return;
        }

        Conta conta;
        Cliente cliente = banco.getCliente(cpf);

        if (tipo == 0) {
            conta = new ContaCorrente(cliente);
        } else {
            conta = new ContaPoupanca(cliente);
        }
        cliente.setConta(conta);
        System.out.println(cliente.getContas());
        banco.setConta(conta);
    }

    private static void depositar(Banco banco, String cpf, Integer numeroConta, double valor) {
        if (!banco.isCliente(cpf)) {
            System.out.println("Não existe cliente com este cpf.");
            return;
        }

        Cliente cliente = banco.getCliente(cpf);
        Conta clienteConta = cliente.getConta(numeroConta);

        if (clienteConta == null) {
            System.out.println("Conta não existe.");
            return;
        }
        clienteConta.depositar(valor);
    }

    public static void run() {
        Banco banco = new Banco("Bancaum");
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            menu.show();
            String input = scanner.next();

            if (input.equals("d")) {
                System.out.print("Informe cpf: ");
                String cpf = scanner.next();
                System.out.print("Informe numero da conta: ");
                String numeroConta = scanner.next();
                System.out.print("Informe valor a depositar: ");
                String valor = scanner.next();
                depositar(banco, cpf, Integer.parseInt(numeroConta), Double.parseDouble(valor));
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
                System.out.print("Informe cpf: ");
                String cpf = scanner.next();
                System.out.print("Informe o tipo de conta [0-Corrente, 1-Poupanca]: ");
                String tipo = scanner.next();
                criarConta(banco, Integer.parseInt(tipo), cpf);
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