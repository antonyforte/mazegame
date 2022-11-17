import java.sql.Time;


//PROGRAMA NAO MOSTRA OURO E DIAMANTE MAIS
public class Programa {
    public static long Tempo = System.currentTimeMillis();
    public static Mapa GameMap = new Mapa();

    public static void main(String[] args) {
        GenerateMap();
        Comandos comandos = new Comandos();
        String Comando;
        Jogador NovoJogador = new Jogador();
        System.out.println("｡･:*:･ﾟ★,｡･:*:･ﾟ☆:*:･ﾟ☆\n╔═.✵.════════════════╗");
        System.out.println("BEM VINDO AO ADVENTURE");
        System.out.println("╚════════════════.✵.═╝\n");
        System.out.print("Digite seu Nick ");
        NovoJogador.setNome(Console.readLine());
        System.out.println("｡･:*:･ﾟ★,｡･:*:･ﾟ☆:*:･ﾟ☆ O Objetivo do Jogo é chegar na Sala Final Com a maior quantidade de Ouro e Diamantes possivel ｡･:*:･ﾟ★,｡･:*:･ﾟ☆:*:･ﾟ☆\n\n\n｡･:*:･ﾟ★,｡･:*:･ﾟ☆:*:･ﾟ☆\t\t\t\t\t\t\t\tBoa Sorte "+NovoJogador.getNome()+"\t\t\t\t\t\t\t\t\t\t\t\t｡･:*:･ﾟ★,｡･:*:･ﾟ☆:*:･ﾟ☆\n");

        System.out.println("\n_______UTILIZE COMANDOS PARA FAZER AÇÕES_________");
        while(true){
            System.out.print("\n");
            System.out.print(NovoJogador.getNome()+" > ");
            Comando = Console.readLine();

            if(Comando.equals("view")){
                comandos.view(GameMap,NovoJogador.getSalaAtual());
            } else if (Comando.contains("moveTo")) {
                try {
                    GameMap.LocomocaoTrolls(GameMap);
                    comandos.moveTo(GameMap, NovoJogador.getSalaAtual(), NovoJogador, Comando.substring(7));
                }catch (StringIndexOutOfBoundsException e){
                    System.out.println("'-' digita pra aonde você quer ir");
                }
            } else if (Comando.equals("viewActions")) {
                comandos.viewActions(GameMap,NovoJogador);

            } else if (Comando.equals("openDoor")) {
                comandos.openDoor(GameMap,NovoJogador);

            } else if (Comando.equals("pickUp")) {
                comandos.pickUp(GameMap,NovoJogador);

            } else if (Comando.contains("drop")) {
                comandos.drop(GameMap,NovoJogador,Comando.substring(5));

            } else if (Comando.contains("throwAxe")) {
                try {
                    comandos.throwAxe(GameMap, NovoJogador, Comando.substring(9));
                }catch (StringIndexOutOfBoundsException e){
                    System.out.println("( ^\u200B_^）Jogo é ruim então, voce tem que digitar o nome do troll em que deseja tacar o machado");
                }
            } else if (Comando.equals("viewInventory")) {
                comandos.viewInventory(NovoJogador);

            } else if (Comando.equals("whereAmI")) {
                comandos.whereAmI(NovoJogador);

            } else if (Comando.equals("exit")) {
                comandos.exit(NovoJogador);

            } else if (Comando.equals("lockDoor")) {
                comandos.lockDoor(GameMap,NovoJogador);

            } else if (Comando.equals("finish")) {
                break;
            }else {
                System.out.println("( ≖.≖) Comando Não Encontrado");
            }
            if(NovoJogador.getSalaAtual() == 20) {
                System.out.println("\nʕ( ͡❛ ͜ʖ ͡❛)ʔ PARABENS VOCÊ CHEGOU A SAÍDA\n");
                System.out.print("Voce Concluiu em ");
                TempodeJogo(Tempo,System.currentTimeMillis());
                System.out.println("\nVoce Conseguiu: ");
                System.out.println(QuantidadeOuro(NovoJogador)+" Ouros");
                System.out.println(QuantidadeDiamantes(NovoJogador)+" Diamantes");
            }
        }
    }

    public static void GenerateMap() {
        GameMap.GerarNomeSalas(GameMap);
        GameMap.GerarPortas(GameMap);
        GameMap.GerarOuro(GameMap);
        GameMap.GerarDiamante(GameMap);
        GameMap.GerarMachado(GameMap);
        GameMap.GerarPocaoMagica(GameMap);
        GameMap.GerarChaves2(GameMap);
        GameMap.GerarTrolls(GameMap);
    }

    public static void TempodeJogo(long Inicio,long Fim){
        long Horas = (long) (Math.floor((Fim / (1000 * 60 * 60)) % 24) - Math.floor((Inicio / (1000 * 60 * 60)) % 24));
        long Minutos = (long) (Math.floor((Fim / (1000 * 60)) % 60) -  Math.floor((Inicio / (1000 * 60)) % 60));
        long Segundos = (long) (Math.floor((Fim / 1000) % 60) -  Math.floor((Inicio / 1000) % 60));

        Horas = (Horas < 10) ? Long.parseLong("0" + Horas) : Horas;
        Minutos = (Minutos < 10) ? Long.parseLong("0" + Minutos) : Minutos;
        Segundos = (Segundos < 10) ? Long.parseLong("0" + Segundos) : Segundos;

        System.out.print(Horas+"h: "+Minutos+"m: "+Segundos+"s");
    }

    public static int QuantidadeOuro(Jogador jogador){
        int Contador = 0;
        for(int i = 0 ; i < jogador.getJogadorInventarioPecas().size() ; i++){
            if(jogador.getJogadorInventarioPecas().get(i).getClass().getName().equals("Ouro")){
                Contador++;
            }
        }
        return Contador;
    }

    public static int QuantidadeDiamantes(Jogador jogador){
        int Contador = 0;
        for(int i = 0; i < jogador.getJogadorInventarioPecas().size() ; i++){
            if(jogador.getJogadorInventarioPecas().get(i).getClass().getName().equals("Diamante")){
                Contador++;
            }
        }
        return Contador;
    }

}