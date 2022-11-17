public class Porta {

    private String nomePorta;
    private Sala proximaSala;
    private Boolean portaAberta; // false-FECHADA || true-ABERTA

    // METODO CONSTRUTOR DA CLASSE
    public Porta() {
    }

    public Porta CriarPorta(String NomePorta, Sala ProxSala,Boolean Aberta){
        Porta p = new Porta();
        p.nomePorta = NomePorta;
        p.proximaSala = ProxSala;
        p.portaAberta = Aberta;
        return p;
    }

    public String getNomePorta() {
        return nomePorta;
    }

    public void setNomePorta(String nomePorta) {
        this.nomePorta = nomePorta;
    }

    public Sala getProximaSala() {
        return proximaSala;
    }

    public void setProximaSala(Sala proximaSala) {
        this.proximaSala = proximaSala;
    }

    public Boolean getPortaAberta() {
        return portaAberta;
    }

    public void setPortaAberta(Boolean portaAberta) {
        this.portaAberta = portaAberta;
    }

    @Override
    public String toString() {
        String AbertaFechada;
        if(this.portaAberta == true){
            AbertaFechada = "Aberta";
        }else{
            AbertaFechada = "Trancada";
        }
        return nomePorta + " - " + AbertaFechada + "(" + "Porta para " + proximaSala.getNomeSala() + ")";
    }
}
