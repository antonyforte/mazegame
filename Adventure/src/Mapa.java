import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    ArrayList<Sala> sala = new ArrayList<>();
    private Jogador player1;

    // METODO CONSTRUTOR DA CLASSE
    public Mapa(){
        for(int i = 0 ; i < 21 ; i++){
            Sala NovaSala = new Sala();
            sala.add(NovaSala);
        }

    }
    // METODO PARA GERAR UMA QUANTIDADE DE OURO ALEATORIA EM SALAS ALEATORIAS
    protected void GerarOuro(Mapa mapa){

        //GERAR UM NUMERO ALEATORIO PARA A QUANTIDADE DE OURO QUE TERA NO MAPA
        int QuantidadeOuro = GerarNumeroALeatorio(20,1);

        //ADICIONAR OS OUROS EM SALAS ALEATORIAS
        for(int i = 0 ; i < QuantidadeOuro ; i++){

            int SalaAleatoria = GerarNumeroALeatorio(19,1);

            Ouro NovoOuro = new Ouro();
            NovoOuro.setNomePeca("Ouro"+i);
            mapa.sala.get(SalaAleatoria).AdicionarPeca(NovoOuro);
        }

    }


    protected void GerarDiamante(Mapa mapa){

        //GERAR UM NUMERO ALEATORIO PARA A QUANTIDADE DE DIAMANTES QUE TERA NO MAPA
        int QuantidadeDiamante = GerarNumeroALeatorio(20,1);

        //ADICIONAR OS DIAMANTES EM SALAS ALEATORIAS
        for(int i = 0 ; i < QuantidadeDiamante ; i++){

            int SalaAleatoria = GerarNumeroALeatorio(19,1);

            Diamante NovoDiamante = new Diamante();
            NovoDiamante.setNomePeca("Diamante"+i);
            mapa.sala.get(SalaAleatoria).AdicionarPeca(NovoDiamante);
        }

    }

    protected void GerarPocaoMagica(Mapa mapa){

        //GERAR UM NUMERO ALEATORIO PARA A QUANTIDADE DE POCAO QUE TERA NO MAPA
        int QuantidadePocaoMagica = GerarNumeroALeatorio(20,1);

        //ADICIONAR AS POCOES EM SALAS ALEATORIAS
        for(int i = 0 ; i < QuantidadePocaoMagica ; i++){

            int SalaAleatoria = GerarNumeroALeatorio(19,1);

            PocaoMagica NovoPocaoMagica = new PocaoMagica();
            NovoPocaoMagica.setNomeItem("PocaoMagica"+i);
            mapa.sala.get(SalaAleatoria).AdicionarItem(NovoPocaoMagica);
        }

    }
    //METODO PRIVADO APENAS PARA CONSERTAR UM POSSIVEL BUG DO JOGO(TER MENOS MACHADOS DO QUE TROLLS ASSIM O JOGADOR NUNCA PODERA COLETAR TODAS AS PEÇAS)
    private int QuantidadeTrolls(Mapa mapa){
        int quantidadeTrolls = 0;
        for(int i = 0 ; i < 21 ; i ++){
            quantidadeTrolls += mapa.sala.get(i).getTrollsSala().size();
        }
        return quantidadeTrolls;
    }

    protected void GerarMachado(Mapa mapa){
        int QuantidadeMachado;

        //GERAR UM NUMERO ALEATORIO PARA A QUANTIDADE DE MACHADOS QUE TERA NO MAPA DESDE QUE ESSE NUMERO NAO SEJA MENOR QUE O NUMERO DE TROLLS
            while (true) {
                QuantidadeMachado = GerarNumeroALeatorio(50, 1);
                if(QuantidadeMachado >= QuantidadeTrolls(mapa)){
                    break;
                }

            }
        //ADICIONAR OS MACHADOS EM SALAS ALEATORIAS
        for(int i = 0 ; i < QuantidadeMachado ; i++){

            int SalaAleatoria = GerarNumeroALeatorio(19,1);

            Machado NovoMachado = new Machado();
            NovoMachado.setNomeItem("Machado"+i);
            mapa.sala.get(SalaAleatoria).AdicionarItem(NovoMachado);
        }

    }

    protected void GerarChaves2(Mapa mapa){

        mapa.sala.get(0).AdicionarPeca(extracted("ChavePorta2"));


        mapa.sala.get(1).AdicionarPeca(extracted("ChavePorta1"));


        mapa.sala.get(5).AdicionarPeca(extracted("ChavePorta3"));

        mapa.sala.get(2).AdicionarPeca(extracted("ChavePorta8"));

        mapa.sala.get(6).AdicionarPeca(extracted("ChavePorta7"));

        mapa.sala.get(11).AdicionarPeca(extracted("ChavePorta14"));

        mapa.sala.get(10).AdicionarPeca(extracted("ChavePorta13"));

        mapa.sala.get(1).AdicionarPeca(extracted("ChavePorta18"));

        mapa.sala.get(5).AdicionarPeca(extracted("ChavePorta19"));

        mapa.sala.get(10).AdicionarPeca(extracted("ChavePorta20"));

        mapa.sala.get(18).AdicionarPeca(extracted("ChavePorta16"));

        mapa.sala.get(13).AdicionarPeca(extracted("ChavePorta17"));

        mapa.sala.get(2).AdicionarPeca( extracted("ChavePorta12"));

        mapa.sala.get(16).AdicionarPeca( extracted("ChavePorta7"));

        mapa.sala.get(4).AdicionarPeca(  extracted("ChavePorta11"));

        mapa.sala.get(11).AdicionarPeca(extracted("ChavePorta10"));

        mapa.sala.get(8).AdicionarPeca( extracted("ChavePorta4"));

        mapa.sala.get(12).AdicionarPeca(extracted("ChavePorta15"));

        mapa.sala.get(12).AdicionarPeca(extracted("ChavePorta21"));


        mapa.sala.get(7).AdicionarPeca(extracted("ChavePorta6"));

        mapa.sala.get(19).AdicionarPeca(extracted("ChavePorta5"));
    }

    private Chave extracted(String ChavePorta) {
        Chave NovaChave = new Chave();
        NovaChave.setNomePeca(ChavePorta);
        return NovaChave;
    }
    protected void info_Sala(Mapa mapa,Comandos c,int sala){
        c.view(mapa,sala);
    }

    protected void GerarTrolls(Mapa mapa){
        int QuantidadeTrolls = GerarNumeroALeatorio(20,1);
        int cont = 0;

        while(cont < QuantidadeTrolls){
            int SalaAleatoria = GerarNumeroALeatorio(19,1);

            for(int i = 0; i < mapa.sala.get(SalaAleatoria).getPecasSala().size();i++){
                if(mapa.sala.get(SalaAleatoria).getPecasSala().get(i).getNomePeca().contains("Ouro")){
                    Trolls NovoTroll = new Trolls();
                    NovoTroll.setNomeTroll("Troll"+cont);
                    mapa.sala.get(SalaAleatoria).getTrollsSala().add(NovoTroll);
                    cont++;
                    break;
                }
            }
        }
    }

    private void TrollPegaMachado(Sala sala,Trolls troll){
        int indexMachado = 0;
        for(int i = 0 ; i < sala.getItensSala().size(); i++){
            if(sala.getItensSala().get(i).getClass().getName().equals("Machado")){
                indexMachado = i;
                break;
            }
        }
        Machado machadoTroll = new Machado();
        machadoTroll = (Machado) sala.getItensSala().get(indexMachado);
        sala.getItensSala().remove(indexMachado);
        troll.setMachadoTroll(machadoTroll);
    }
    protected void LocomocaoTrolls(Mapa mapa){
        for(int i = 0 ;i < 20 ; i++){
                for(int j = 0 ; j < mapa.sala.get(i).getTrollsSala().size() ; j++){
                    // EXISTE 33% DE CHANCE DE UM TROLL DECIDIR SE MOVER
                    int ChanceDoTrollSeMover = GerarNumeroALeatorio(3,1);
                    if(ChanceDoTrollSeMover == 1) {
                        int PortaQueOTrollIra = GerarNumeroALeatorio(mapa.sala.get(i).getPortas().size() - 1, 0);
                        //ALEM DISSO , EXISTE 100%,50%,33%(DEPENDENDO DA SALA) DE CHANCE DO TROLL CONSEGUIR SE MOVER, POIS A PORTA QUE ELE ESCOLHEU PODE ESTAR TRANCADA(TROLLS SAO BURROS :D)
                        if(mapa.sala.get(i).getPortas().get(PortaQueOTrollIra).getPortaAberta() == true) {
                            Trolls troll = new Trolls();
                            troll = mapa.sala.get(i).getTrollsSala().get(j);
                            mapa.sala.get(i).getTrollsSala().remove(j);
                            //METODO CONTAINS NAO FUNCIONAVA ENTAO TIVE Q FAZER DESSE MODO PARA VERIFICAR SE A SALA QUE O TROLL IRA TEM MACHADO
                            Machado Newe = new Machado();
                            for(int l = 0 ; l < mapa.sala.get(mapa.sala.indexOf(mapa.sala.get(i).getPortas().get(PortaQueOTrollIra).getProximaSala())).getItensSala().size();l++){
                                if(mapa.sala.get(mapa.sala.indexOf(mapa.sala.get(i).getPortas().get(PortaQueOTrollIra).getProximaSala())).getItensSala().get(l).getClass().getName().equals("Machado"))
                                    Newe = (Machado) mapa.sala.get(mapa.sala.indexOf(mapa.sala.get(i).getPortas().get(PortaQueOTrollIra).getProximaSala())).getItensSala().get(l);
                            }
                            if(mapa.sala.get(mapa.sala.indexOf(mapa.sala.get(i).getPortas().get(PortaQueOTrollIra).getProximaSala())).getItensSala().contains(Newe) && troll.getMachadoTroll() == null){
                                TrollPegaMachado(mapa.sala.get(mapa.sala.indexOf(mapa.sala.get(i).getPortas().get(PortaQueOTrollIra).getProximaSala())),troll);
                            }
                            mapa.sala.get(mapa.sala.indexOf(mapa.sala.get(i).getPortas().get(PortaQueOTrollIra).getProximaSala())).getTrollsSala().add(troll);
                        }
                    }
                }
        }
    }
    //ESSE METODO É CHAMADO TODA VEZ QUE O JOGADOR USA O COMANDO MOVETO PARA UMA PEÇA DE OURO OU DIAMANTE
    protected void TrollLancaMachado(Mapa mapa, Jogador jogador){
        int contador = 0;
        int indexPocao = 0;
        boolean TrollComMachado = false;
        int indexTrollMachado = -1;
        for(int i = 0; i < mapa.sala.get(jogador.getSalaAtual()).getTrollsSala().size();i++){
            if(mapa.sala.get(jogador.getSalaAtual()).getTrollsSala().get(i).getMachadoTroll() != null){
                TrollComMachado = true;
                indexTrollMachado = i;
                break;
            }
        }
        if((jogador.getOndeEstou().getClass().getName().equals("Ouro") || jogador.getOndeEstou().getClass().getName().equals("Diamante")) && (!mapa.sala.get(jogador.getSalaAtual()).getTrollsSala().isEmpty())&& TrollComMachado == true) {
           System.out.println("(ノಠ益ಠ)ノ彡┻━┻ OH NAO, UM TROLL TE ATACOU");
            mapa.sala.get(jogador.getSalaAtual()).getTrollsSala().get(indexTrollMachado).setMachadoTroll(null);
            for (int i = 0; i < jogador.getJogadorInventarioPecas().size(); i++) {
                if (jogador.getJogadorInventarioPecas().get(i).getClass().getName().equals("PocaoMagica")) {
                    contador++;
                    indexPocao = i;
                    break;
                }
            }

            if (contador == 0) {
                for (int i = 0; i < jogador.getJogadorInventarioPecas().size(); i++) {
                    if (jogador.getJogadorInventarioPecas().get(i).getClass().getName().equals("Ouro")) {
                        Ouro ouro = new Ouro();
                        ouro = (Ouro) jogador.getJogadorInventarioPecas().get(i);
                        jogador.getJogadorInventarioPecas().remove(ouro);
                        mapa.sala.get(jogador.getSalaAtual()).getPecasSala().add(ouro);

                    }
                }
                System.out.println("'(ᗒᗣᗕ)՞ VOCE PERDEU TODAS SUAS PEÇAS DE OURO PRO TROLL");
            }else{
                System.out.println("(─‿‿─) PORÉM VOCÊ TEM UMA POÇÃO MAGICA EM SEU INVENTARIO, ELA FOI DESTRUIDA JUNTO COM O MACHADO QUE O TROLL LHE TACOU");
                jogador.getJogadorInventario().remove(indexPocao);
            }
        }
    }

    // METODO PARA GERAR O NOME DAS SALAS DO MAPA
    protected void GerarNomeSalas(Mapa mapa){
        for(int i = 0 ; i < 20 ; i++){
            mapa.sala.get(i).setNomeSala("Sala"+i);
        }
        mapa.sala.get(20).setNomeSala("Saída");
    }
    //METODO PARA GERAR AS PORTAS DA SALA DO MAPA DE ACORDO COM O MAPA NO DOCUMENTO

    public void GerarPortas(Mapa mapa){
        //"SALA A SER CRIADA A PORTA".CRIARPORTA("NOME DA PORTA","SALA EM QUE SE CONECTA","SE ESTA ABERTA OU FECHADA")
        mapa.sala.get(0).CriarPorta("Porta1",mapa.sala.get(5),false);
        mapa.sala.get(5).CriarPorta("Porta1",mapa.sala.get(0),false);

        mapa.sala.get(0).CriarPorta("Porta2",mapa.sala.get(1),false);
        mapa.sala.get(1).CriarPorta("Porta2",mapa.sala.get(0),false);

        mapa.sala.get(1).CriarPorta("Porta3",mapa.sala.get(2),false);
        mapa.sala.get(2).CriarPorta("Porta3",mapa.sala.get(1),false);

        mapa.sala.get(2).CriarPorta("Porta4",mapa.sala.get(7),false);
        mapa.sala.get(7).CriarPorta("Porta4",mapa.sala.get(2),false);

        mapa.sala.get(3).CriarPorta("Porta5",mapa.sala.get(20),false);

        mapa.sala.get(3).CriarPorta("Porta6",mapa.sala.get(4),false);
        mapa.sala.get(4).CriarPorta("Porta6",mapa.sala.get(3),false);

        mapa.sala.get(4).CriarPorta("Porta7",mapa.sala.get(9),false);
        mapa.sala.get(9).CriarPorta("Porta7",mapa.sala.get(4),false);

        mapa.sala.get(5).CriarPorta("Porta8",mapa.sala.get(6),false);
        mapa.sala.get(6).CriarPorta("Porta8",mapa.sala.get(5),false);

        mapa.sala.get(6).CriarPorta("Porta9",mapa.sala.get(11),false);
        mapa.sala.get(11).CriarPorta("Porta9",mapa.sala.get(6),false);

        mapa.sala.get(7).CriarPorta("Porta10",mapa.sala.get(12),false);
        mapa.sala.get(12).CriarPorta("Porta10",mapa.sala.get(7),false);

        mapa.sala.get(8).CriarPorta("Porta11",mapa.sala.get(9),false);
        mapa.sala.get(9).CriarPorta("Porta11",mapa.sala.get(8),false);

        mapa.sala.get(9).CriarPorta("Porta12",mapa.sala.get(14),false);
        mapa.sala.get(14).CriarPorta("Porta12",mapa.sala.get(9),false);

        mapa.sala.get(10).CriarPorta("Porta13",mapa.sala.get(15),false);
        mapa.sala.get(15).CriarPorta("Porta13",mapa.sala.get(10),false);

        mapa.sala.get(10).CriarPorta("Porta14",mapa.sala.get(11),false);
        mapa.sala.get(11).CriarPorta("Porta14",mapa.sala.get(10),false);

        mapa.sala.get(11).CriarPorta("Porta15",mapa.sala.get(12),false);
        mapa.sala.get(12).CriarPorta("Porta15",mapa.sala.get(11),false);

        mapa.sala.get(13).CriarPorta("Porta16",mapa.sala.get(18),false);
        mapa.sala.get(18).CriarPorta("Porta16",mapa.sala.get(13),false);

        mapa.sala.get(13).CriarPorta("Porta17",mapa.sala.get(14),false);
        mapa.sala.get(14).CriarPorta("Porta17",mapa.sala.get(13),false);

        mapa.sala.get(15).CriarPorta("Porta18",mapa.sala.get(16),false);
        mapa.sala.get(16).CriarPorta("Porta18",mapa.sala.get(15),false);

        mapa.sala.get(16).CriarPorta("Porta19",mapa.sala.get(17),false);
        mapa.sala.get(17).CriarPorta("Porta19",mapa.sala.get(16),false);

        mapa.sala.get(17).CriarPorta("Porta20",mapa.sala.get(18),false);
        mapa.sala.get(18).CriarPorta("Porta20",mapa.sala.get(17),false);

        mapa.sala.get(14).CriarPorta("Porta21",mapa.sala.get(19),false);
        mapa.sala.get(19).CriarPorta("Porta21",mapa.sala.get(14),false);
    }
    public int GerarNumeroALeatorio(int max,int min) {
        Random Aleatorio = new Random();
        int NumAleatorio = Aleatorio.nextInt((max - min) + 1) + min;
        return NumAleatorio;
    }

}
