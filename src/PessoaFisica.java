import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)
@AllArgsConstructor
public class PessoaFisica {

    private String cpf;
    private String nome;

}
