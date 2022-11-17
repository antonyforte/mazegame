//

public class Comandos {


    //COMANDO PARA VISUALIZAR O QUE TEM NA SALA
    public void view(Mapa mapa, int SalaAtual) {
        System.out.println("SALA " + SalaAtual);
        for (int i = 0; i < mapa.sala.get(SalaAtual).getPortas().size(); i++) {
            System.out.println(mapa.sala.get(SalaAtual).getPortas().get(i).toString());
        }
        for (int i = 0; i < mapa.sala.get(SalaAtual).getPecasSala().size(); i++) {
            System.out.println(mapa.sala.get(SalaAtual).getPecasSala().get(i).getNomePeca());
        }
        for (int i = 0; i < mapa.sala.get(SalaAtual).getItensSala().size(); i++) {
            System.out.println(mapa.sala.get(SalaAtual).getItensSala().get(i).toString());
        }
        for (int i = 0; i < mapa.sala.get(SalaAtual).getTrollsSala().size(); i++) {
            System.out.println(mapa.sala.get(SalaAtual).getTrollsSala().get(i).toString());
        }
    }

    // COMANDO PARA SE MOVER PARA ITENS, PORTAS, PECAS, ETC...
    public void moveTo(Mapa mapa, int SalaAtual, Jogador jogador, String ParaOnde) {
        for (int i = 0; i < mapa.sala.get(SalaAtual).getPortas().size(); i++) {
            if (mapa.sala.get(SalaAtual).getPortas().get(i).getNomePorta().equals(ParaOnde)) {
                jogador.setOndeEstou(mapa.sala.get(SalaAtual).getPortas().get(i));
                System.out.println("(づ｡◕‿‿◕)づ...Indo");
                return;
            }
        }
        for (int i = 0; i < mapa.sala.get(SalaAtual).getPecasSala().size(); i++) {
            if (mapa.sala.get(SalaAtual).getPecasSala().get(i).getNomePeca().equals(ParaOnde)) {
                jogador.setOndeEstou(mapa.sala.get(SalaAtual).getPecasSala().get(i));
                System.out.println("(づ｡◕‿‿◕)づ...Indo");
                mapa.TrollLancaMachado(mapa,jogador);
                return;
            }
        }
        for (int i = 0; i < mapa.sala.get(SalaAtual).getItensSala().size(); i++) {
            if (mapa.sala.get(SalaAtual).getItensSala().get(i).getNomeItem().equals(ParaOnde)) {
                jogador.setOndeEstou(mapa.sala.get(SalaAtual).getItensSala().get(i));
                System.out.println("(づ｡◕‿‿◕)づ...Indo");
                return;
            }
        }
        for (int i = 0; i < mapa.sala.get(SalaAtual).getTrollsSala().size(); i++) {
            if (mapa.sala.get(SalaAtual).getTrollsSala().get(i).getNomeTroll().equals(ParaOnde)) {
                jogador.setOndeEstou(mapa.sala.get(SalaAtual).getTrollsSala().get(i));
                System.out.println("(づ｡◕‿‿◕)づ...Indo");
                return;
            }
        }
        System.out.println("Não tem isso ai pra você chegar :D");
    }


    //COMANDO PARA CITAR AS ACOES POSSIVEIS NO MOMENTO
    public void viewActions(Mapa mapa, Jogador jogador) {
        Object ObjetoAcao = new Object();
        ObjetoAcao = jogador.getOndeEstou();

        if (ObjetoAcao.getClass().getSuperclass().getName().equals("Itens") || ObjetoAcao.getClass().getSuperclass().getName().equals("Pecas")) {
            System.out.println("pickUp");
        } else if (ObjetoAcao.getClass().getName().equals("Porta")) {
            if (mapa.sala.get(jogador.getSalaAtual()).getPortas().get(mapa.sala.get(jogador.getSalaAtual()).getPortas().indexOf(jogador.getOndeEstou())).getPortaAberta()) {
                System.out.println("exit");
                System.out.println("lockDoor");
            } else {
                System.out.println("openDoor");
            }

        } else if (ObjetoAcao.getClass().getName().equals("Trols")) {
            System.out.println("throwAxe " + jogador.getOndeEstou().toString());
        }
    }

    //COMANDO PARA ABRIR UMA PORTA
    public void openDoor(Mapa mapa, Jogador jogador) {
        int Contador = 0;
        //CONDICAO SE VERIFICA SE O JOGADOR ESTA EM UMA PORTA
        if (jogador.getOndeEstou().getClass().getName().equals("Porta")){
            //CONDICAO QUE VERIFICA SE A PORTA ESTA FECHADA
            if (mapa.sala.get(jogador.getSalaAtual()).getPortas().get(mapa.sala.get(jogador.getSalaAtual()).getPortas().indexOf(jogador.getOndeEstou())).getPortaAberta() == false) {
                for (int i = 0; i < jogador.getJogadorInventarioPecas().size(); i++) {
                    //CONDICAO QUE VERIFICA SE O JOGADOR TEM EM SEU INVENTARIO A CHAVE DA PORTA ONDE ELE ESTA
                    if (jogador.getJogadorInventarioPecas().get(i).getNomePeca().contains(jogador.getOndeEstou().toString().substring(0,6))) {
                        //SETA A PORTA ATUAL COMO TRUE(OU SEJA, COLOCA A PORTA COMO ABERTA)
                        mapa.sala.get(jogador.getSalaAtual()).getPortas().get(mapa.sala.get(jogador.getSalaAtual()).getPortas().indexOf(jogador.getOndeEstou())).setPortaAberta(true);
                        //CODIGO ABAIXO SETA A PORTA DO OUTRO LADO DA SALA COMO TRUE TAMBEM(É O PROBLEMA DO MEU CODIGO ONDE É GERADO 2 PORTAS IGUAIS QUE LIGAM AS DUAS SALAS)
                        int index = 0;
                        int indexporta = 0;
                        int indexportaProx = 0;
                        for(int j = 0 ; j < mapa.sala.get(jogador.getSalaAtual()).getPortas().size();j++){
                            if(mapa.sala.get(jogador.getSalaAtual()).getPortas().get(j).equals(jogador.getOndeEstou())){
                                indexporta = j;
                                break;
                            }
                        }
                        for(int j = 0 ; j < mapa.sala.size();j++){
                            if(mapa.sala.get(j).equals(mapa.sala.get(jogador.getSalaAtual()).getPortas().get(indexporta).getProximaSala())){
                                index = j;
                                break;
                            }
                        }
                        for(int j = 0 ; j < mapa.sala.get(index).getPortas().size();j++){
                            if(mapa.sala.get(index).getPortas().get(j).getNomePorta().equals(((Porta) jogador.getOndeEstou()).getNomePorta())){
                                indexportaProx = j;
                                break;
                            }
                        }
                        //ABRIR A PORTA DA PROXIMA SALA DA PORTA EM QUE ESTOU
                        mapa.sala.get(index).getPortas().get(indexportaProx).setPortaAberta(true);
                        Contador++;
                        System.out.println("PORTA ABERTA COM SUCESSO :D");
                        break;
                    }
                }if(Contador==0){
                    System.out.println("VOCE NAO TEM A CHAVE DA PORTA T.T");
                }
            } else {
                System.out.println("A PORTA JA ESTA ABERTA >.<");
            }
        }else{
            System.out.println("VOCE NAO ESTA EM UMA PORTA '-'");
        }
    }
    //METODO PARA TRANCAR UMA PORTA, FUNCIONA DA MESMA MANEIRA QUE O OPENDOOR POREM REQUER UMA POCAO MAGICA PARA TRANCAR A PORTA, E AO USAR A POCAO MAGICA ELA SERA DESTRUIDA
    public void lockDoor(Mapa mapa, Jogador jogador){
        int Contador = 0;
        if(jogador.getOndeEstou().getClass().getName().equals("Porta")){
            if(mapa.sala.get(jogador.getSalaAtual()).getPortas().get(mapa.sala.get(jogador.getSalaAtual()).getPortas().indexOf(jogador.getOndeEstou())).getPortaAberta() == true){
                for(int i = 0 ; i < jogador.getJogadorInventario().size(); i++){
                    if(jogador.getJogadorInventario().get(i).getClass().getName().equals("PocaoMagica")){
                        jogador.getJogadorInventario().remove(i);
                        mapa.sala.get(jogador.getSalaAtual()).getPortas().get(mapa.sala.get(jogador.getSalaAtual()).getPortas().indexOf(jogador.getOndeEstou())).setPortaAberta(false);

                        int index = 0;
                        int indexporta = 0;
                        int indexportaProx = 0;
                        for(int j = 0 ; j < mapa.sala.get(jogador.getSalaAtual()).getPortas().size();j++){
                            if(mapa.sala.get(jogador.getSalaAtual()).getPortas().get(j).equals(jogador.getOndeEstou())){
                                indexporta = j;
                                break;
                            }
                        }
                        for(int j = 0 ; j < mapa.sala.size();j++){
                            if(mapa.sala.get(j).equals(mapa.sala.get(jogador.getSalaAtual()).getPortas().get(indexporta).getProximaSala())){
                                index = j;
                                break;
                            }
                        }
                        for(int j = 0 ; j < mapa.sala.get(index).getPortas().size();j++){
                            if(mapa.sala.get(index).getPortas().get(j).getNomePorta().equals(((Porta) jogador.getOndeEstou()).getNomePorta())){
                                indexportaProx = j;
                                break;
                            }
                        }
                        mapa.sala.get(index).getPortas().get(indexportaProx).setPortaAberta(false);
                        System.out.println("PORTA TRANCADA COM SUCESSO :D");
                        Contador++;
                        break;
                    }
                }if(Contador == 0){
                    System.out.println("VOCE NAO TEM POCOES MAGICAS PARA PODER TRANCAR A PORTA U.U");
                }

            }else{
                System.out.println("A PORTA JA ESTA TRANCADA >.<");
            }

        }else{
            System.out.println("VOCE NAO ESTA EM UMA PORTA '-'");
        }
    }

    //METODO QUE PEGA UM ITEM OU PECA REMOVE DA SALA E ADICIONA AO INVENTARIO DO JOGADOR
    public void pickUp(Mapa mapa,Jogador jogador){
        if(jogador.getOndeEstou().getClass().getSuperclass().getName().equals("Itens")|| jogador.getOndeEstou().getClass().getSuperclass().getName().equals("Pecas")) {
            if (jogador.getJogadorInventario().size() >= 5 && jogador.getOndeEstou().getClass().getSuperclass().equals(Itens.class)) {
                System.out.println("PARECE QUE A MOCHILA ESTA CHEIA, NAO CONSIGO GUARDAR O ITEM :( ");
                return;
            } else {
                if (jogador.getOndeEstou().getClass().getSuperclass().getName().equals("Itens")) {
                    jogador.getJogadorInventario().add(mapa.sala.get(jogador.getSalaAtual()).getItensSala().get(mapa.sala.get(jogador.getSalaAtual()).getItensSala().indexOf(jogador.getOndeEstou())));
                    mapa.sala.get(jogador.getSalaAtual()).getItensSala().remove(jogador.getOndeEstou());
                    jogador.setOndeEstou("Corredor");
                    System.out.println("(ᵔᴥᵔ) Pego Com Sucesso");

                } else if (jogador.getOndeEstou().getClass().getSuperclass().getName().equals("Pecas")) {
                    if(mapa.sala.get(jogador.getSalaAtual()).getTrollsSala().isEmpty() || jogador.getOndeEstou().getClass().getName().equals("Chave")) {
                        jogador.getJogadorInventarioPecas().add(mapa.sala.get(jogador.getSalaAtual()).getPecasSala().get(mapa.sala.get(jogador.getSalaAtual()).getPecasSala().indexOf(jogador.getOndeEstou())));
                        mapa.sala.get(jogador.getSalaAtual()).getPecasSala().remove(jogador.getOndeEstou());
                        jogador.setOndeEstou("Corredor");
                        System.out.println("(ᵔᴥᵔ) Pego Com Sucesso");
                    }else{
                        System.out.println("( ⚆ _ ⚆ ) EXISTEM TROLLS PROTEGENDO OS TESOUROS");
                    }
                }
            }
        }else{
            System.out.println("VOCE NAO PODE PEGAR ALGO QUE NAO É UM ITEM OU PECA (· _ ·) ノ");
        }
    }
    //METODO USADO PARA LARGAR UM ITEM DO INVENTARIO DE PECAS OU ITEMS DO JOGADOR
    public void drop(Mapa mapa,Jogador jogador, String item){
        if(item.contains("Ouro")||item.contains("Diamante") && !item.contains("Chave")){
            for(int i = 0 ; i < jogador.getJogadorInventarioPecas().size() ; i++){
                if(jogador.getJogadorInventarioPecas().get(i).getNomePeca().equals(item)){
                    Pecas pecaAserLargada = new Pecas();
                    pecaAserLargada = jogador.getJogadorInventarioPecas().get(i);
                    jogador.getJogadorInventarioPecas().remove(i);
                    mapa.sala.get(jogador.getSalaAtual()).getPecasSala().add(pecaAserLargada);
                    System.out.println(pecaAserLargada.getNomePeca()+" Foi Abandonada :(");
                    break;
                }else if(i == jogador.getJogadorInventarioPecas().size() - 1){
                    System.out.println("VOCE NAO TEM ESSA PEÇA NO INVENTARIO :O");
                }
            }
        }else{
            for(int i = 0 ; i < jogador.getJogadorInventario().size() ; i++){
                if(jogador.getJogadorInventario().get(i).getNomeItem().equals(item)){
                    Itens itemAserLargado = new Itens();
                    itemAserLargado = jogador.getJogadorInventario().get(i);
                    jogador.getJogadorInventario().remove(i);
                    mapa.sala.get(jogador.getSalaAtual()).getItensSala().add(itemAserLargado);
                    System.out.println(itemAserLargado.getNomeItem()+" Foi Abandonado :(");
                    break;
                } else if (i == jogador.getJogadorInventario().size() - 1) {
                    System.out.println("VOCE NAO TEM ESSE ITEM NO INVENTARIO :0");

                }
            }
        }
    }

    public void throwAxe(Mapa mapa, Jogador jogador,String troll){
        if(mapa.sala.get(jogador.getSalaAtual()).getTrollsSala().isEmpty()){
            System.out.println("༼ つ ◕_◕ ༽つ▄︻̷̿┻̿═━一 NAO TEM TROLLS NA SALA");
        }
        else {
            if (jogador.getOndeEstou().getClass().getName().equals("Trolls")) {
                int NumAleatorio = mapa.GerarNumeroALeatorio(2, 1);
                if (NumAleatorio == 1) {
                    mapa.sala.get(jogador.getSalaAtual()).getTrollsSala().remove(jogador.getOndeEstou());
                    jogador.getJogadorInventario().remove(Machado.class);
                    System.out.println("(ง ͠° ͟ل͜ ͡°)ง▄︻̷̿┻̿═━一 TROLL MORTO COM SUCESSO");
                } else {
                    Machado machadojogado = new Machado();
                    machadojogado = (Machado) jogador.getJogadorInventario().get(jogador.getJogadorInventario().indexOf(Machado.class));
                    mapa.sala.get(jogador.getSalaAtual()).getItensSala().add(machadojogado);
                    jogador.getJogadorInventario().remove(machadojogado);
                    System.out.println("༼ つ ಥ_ಥ ༽つ▄︻̷̿┻̿═━一 OH NAO, VOCÊ ERROU");
                }

            } else {
                System.out.println("༼ つ  ͡° ͜ʖ ͡° ༽つつ▄︻̷̿┻̿═━一VOCE NAO VAI CONSEGUIR ACERTAR ELE DESSA DISTANCIA");
            }
        }
    }

    //METODO PARA LISTAR OS ITEMS E PECAS DO JOGADOR
    public void viewInventory(Jogador jogador){
        System.out.println(jogador.getJogadorInventario().toString());
        System.out.println(jogador.getJogadorInventarioPecas().toString());
    }

    //METODO QUE DIZ AONDE O JOGADOR ESTA(NAO A SALA E SIM EM QUAL PORTA, ITEM, PECA OU TROLL)
    public void whereAmI(Jogador jogador) {
        if (jogador.getOndeEstou() == null) {
            System.out.println("Estou no Corredor");
        } else {
            System.out.println(jogador.getOndeEstou().toString());
        }
    }

    //METODO PARA SE LOCOMOVER ENTRE AS SALAS
    public void exit(Jogador jogador){
        if(jogador.getOndeEstou().getClass().getName().equals("Porta")){
            if(((Porta) jogador.getOndeEstou()).getPortaAberta() == true) {
                Porta ObjectNaoReconheceComoPorta = new Porta();
                ObjectNaoReconheceComoPorta = (Porta) jogador.getOndeEstou();
                jogador.setSalaAtual(Integer.parseInt(((Porta) jogador.getOndeEstou()).getProximaSala().getNomeSala().substring(4)));
                jogador.setOndeEstou("Corredor");
                System.out.println("╚(ಠ_ಠ)=┐ Indo para Sala" + jogador.getSalaAtual());
            }else{
                System.out.println("/'(´ཀ`)ﬣ∠ *Bateu de cara na porta*,voce nao é um fantasma pra atravessar portas");
            }
        }else{
            System.out.println("ᕙ(⇀‸↼)ᕗ PERA QUE VOU ABRIR UMA 4 DIMENSAO PARA SAIR DA SALA SEM SER PELA PORTA");
        }
    }
}
