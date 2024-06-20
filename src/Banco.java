import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString(includeFieldNames=true)
public class Banco {

	private String nome;
	private Map<Integer, Conta> contas;
	private Map<String, Cliente> clientes;

	public Banco(String nome) {
		this.nome = nome;
		this.clientes = new HashMap<>();
		this.contas = new HashMap<>();
	}

	public Cliente getCliente(String cpf) {
		return clientes.get(cpf);
	}

	public void setCliente(Cliente cliente) {
		clientes.put(cliente.getCpf(), cliente);
	}

	public void setConta(Conta conta) {
		contas.put(conta.getNumero(), conta);
	}

	public boolean isCliente(String cpf) {
		return clientes.get(cpf) != null;
	}

	public boolean isConta(Integer numero) {
		return contas.get(numero) != null;
	}

}
