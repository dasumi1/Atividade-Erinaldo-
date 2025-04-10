package Lista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorRodizio {
    private List<Rodizio> veiculos = new ArrayList<>();

    public void carregarDados(String nomeArquivo, String filtro, boolean porTipo) throws IOException {
        veiculos.clear();
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

        String linha;
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.split(";");
            if (partes.length == 3) {
                String placa = partes[0].trim();
                String dia = partes[1].trim();
                String horario = partes[2].trim();

                if ((porTipo && placa.endsWith(filtro)) ||
                        (!porTipo && normalizarDia(dia).equals(normalizarDia(filtro)))) {
                    veiculos.add(new Rodizio(placa, dia, horario));
                }
            }
        }
        br.close();
    }

    private String normalizarDia(String dia) {
        return dia.toLowerCase().replaceAll("-feira", "").trim();
    }

    public List<Rodizio> getVeiculos() {
        return new ArrayList<>(veiculos);
    }
}
