import java.util.ArrayList;

public class Sala {

    private String nomeSala;
    private ArrayList<Porta> portas = new ArrayList<>();

    private ArrayList<Itens> itensSala = new ArrayList<>();
    private ArrayList<Pecas> PecasSala = new ArrayList<>();
    private ArrayList<Trolls> trollsSala = new ArrayList<>();

    // METODO CONSTRUTOR DA CLASSE
    public Sala(){
    }

    public ArrayList<Porta> getPortas() {
        return portas;
    }

    public void setPortas(ArrayList<Porta> portas) {
        this.portas = portas;
    }

    // METODO GET PARA O ATRIBUTO NOME
    public String getNomeSala() {
        return nomeSala;
    }

    public ArrayList<Itens> getItensSala() {
        return itensSala;
    }

    public void setItensSala(ArrayList<Itens> itensSala) {
        this.itensSala = itensSala;
    }

    // METODO SET PARA O ATRIBUTO NOME
    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    // METODO PARA CRIAR UMA PORTA PARA UMA SALA
    public void CriarPorta(String NomePorta,Sala ProximaSala,Boolean Aberta){
        Porta NovaPorta = new Porta();
        NovaPorta = NovaPorta.CriarPorta(NomePorta,ProximaSala,Aberta);
        portas.add(NovaPorta);
    }

    public void AdicionarItem(Itens item){
        Itens NovoItem = new Itens();
        NovoItem = item;
        itensSala.add(NovoItem);
    }

    public void AdicionarPeca(Pecas peca){
        Pecas NovaPeca = new Pecas();
        NovaPeca = peca;
        PecasSala.add(NovaPeca);
    }

    public ArrayList<Pecas> getPecasSala() {
        return PecasSala;
    }

    public void setPecasSala(ArrayList<Pecas> pecasSala) {
        PecasSala = pecasSala;
    }

    public ArrayList<Trolls> getTrollsSala() {
        return trollsSala;
    }

    public void setTrollsSala(ArrayList<Trolls> trollsSala) {
        this.trollsSala = trollsSala;
    }
}
