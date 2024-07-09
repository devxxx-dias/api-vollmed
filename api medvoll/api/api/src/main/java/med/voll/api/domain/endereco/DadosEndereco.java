package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
//        @Pattern(regexp = "//d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String numero,
        String complemento

) {
}


//        "endereco": {
//        "logradouro": "rua 1",
//        "bairro": "bairro",
//        "cep": "123456789",
//        "cidade": "Brasilia",
//        "uf": "DF",
//        "numero": "1",
//        "complemento": "complemento"
//        }
//        }