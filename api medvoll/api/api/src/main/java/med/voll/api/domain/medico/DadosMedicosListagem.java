package med.voll.api.domain.medico;

public record DadosMedicosListagem(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public  DadosMedicosListagem(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getEspecialidade());
    }
}