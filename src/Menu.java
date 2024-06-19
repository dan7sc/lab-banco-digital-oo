public class Menu implements IMenu {
    private String menu = """
                ============= MENU =============
                [d]   Depositar
                [s]   Sacar
                [e]   Extrato
                [u]   Criar usuario
                [c]   Criar conta
                [lu]  Listar usuarios
                [lc]  Listar contas
                [q]   Sair
                =>\s""";

    @Override
    public void show() {
        System.out.print(menu);
    }
}
