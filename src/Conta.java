import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = true)
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	@Getter
	protected int agencia;
	@Getter
	protected int numero;
	@Getter
	protected double saldo;
	//@ToString.Exclude
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (saldo - valor < 0) {
			System.out.println("Saldo insuficiente.");
			return;
        }
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirInfosComuns() {
		System.out.printf("Titular: %s%n", this.cliente.getNome());
		System.out.printf("Agencia: %d%n", this.agencia);
		System.out.printf("Numero: %d%n", this.numero);
		System.out.printf("Saldo: %.2f%n", this.saldo);
	}
}
