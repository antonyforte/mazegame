import java.util.ArrayList;

public class Jogador {

    private String Nome;
    ArrayList<Itens> jogadorInventario = new ArrayList<>();
    ArrayList<Pecas> jogadorInventarioPecas = new ArrayList<>(); // INVENTARIO ILIMITADO PARA CHAVES, OUROS E DIAMANTES
    private int SalaAtual;
    private Object OndeEstou;

    public Jogador() {
        SalaAtual = 0;
        String Corredor = "CORREDOR";
        OndeEstou = Corredor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public ArrayList<Itens> getJogadorInventario() {
        return jogadorInventario;
    }

    public void setJogadorInventario(ArrayList<Itens> jogadorInventario) {
        this.jogadorInventario = jogadorInventario;
    }

    public ArrayList<Pecas> getJogadorInventarioPecas() {
        return jogadorInventarioPecas;
    }

    public void setJogadorInventarioPecas(ArrayList<Pecas> jogadorInventarioPecas) {
        this.jogadorInventarioPecas = jogadorInventarioPecas;
    }

    public int getSalaAtual() {
        return SalaAtual;
    }

    public void setSalaAtual(int salaAtual) {
        SalaAtual = salaAtual;
    }

    public Object getOndeEstou() {
        return OndeEstou;
    }

    public void setOndeEstou(Object ondeEstou) {
        OndeEstou = ondeEstou;
    }
}
