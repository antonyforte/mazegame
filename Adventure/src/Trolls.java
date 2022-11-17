public class Trolls {

    private String nomeTroll;
    private Itens machadoTroll;

    public Trolls() {
        setMachadoTroll(null);

    }

    public String getNomeTroll() {
        return nomeTroll;
    }

    public void setNomeTroll(String nomeTroll) {
        this.nomeTroll = nomeTroll;
    }

    public Itens getMachadoTroll() {
        return machadoTroll;
    }

    public void setMachadoTroll(Itens machadoTroll) {
        this.machadoTroll = machadoTroll;
    }

    @Override
    public String toString() {
        if (machadoTroll != null) {
            return nomeTroll + "(Com Machado)";
        } else {
            return nomeTroll + "(Sem Machado)";
        }
    }
}
