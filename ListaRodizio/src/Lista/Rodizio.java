package Lista;

public class Rodizio {
    private String placaVeiculo;
    private String diaSemanaRestricao;
    private String horario;

    public Rodizio(String placaVeiculo, String diaSemanaRestricao, String horario) {
        this.placaVeiculo = placaVeiculo;
        this.diaSemanaRestricao = diaSemanaRestricao;
        this.horario = horario;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String getDiaSemanaRestricao() {
        return diaSemanaRestricao;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "Placa: " + placaVeiculo + "\n" +
                "Dia da Semana: " + diaSemanaRestricao + "\n" +
                "Horário: " + horario + "\n";
    }
}
