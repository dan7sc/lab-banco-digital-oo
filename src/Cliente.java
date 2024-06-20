import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true)
public class Cliente extends PessoaFisica {

	@ToString.Exclude
	private Map<Integer, Conta> contas;

	public Cliente(String cpf, String nome) {
		super(cpf, nome);
		contas = new HashMap<>();
	}

	public void setConta(Conta conta) {
		contas.put(conta.numero, conta);
	}
}
