package al.infnet.edu.br.petfriends_almoxarifado.domain;

import lombok.Value;

@Value
public class Localizacao {

    private String corredor;
    private String prateleira;
    private String secao;

    public Localizacao(String corredor, String prateleira, String secao) {
        this.corredor = corredor;
        this.prateleira = prateleira;
        this.secao = secao;
    }
}
