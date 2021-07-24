package aplicativos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import classes.Motorista;

public class AppHeranca2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        //final int MAX_ELEMENTOS = 20; Retirado para permitir o crescimento do vetor
        final int MAX_ERROS_CPF = 3; 
        int opcao, qtdCadastrados = 0;
        //Motorista[] motoristas = new Motorista[size]; Trocado o array pelo objeto arraylist com interface list abaixo
        List<Motorista> motoristas = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar motorista");
            System.out.println("2 - Listar motoristas cadastrados");
            System.out.println("3 - Listar motorista por CPF"); //coloquei nova opção
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                //  RETIRADO POIS NÃO TEM MAIS LIMITE MÁXIMO
                /*if (qtdCadastrados == MAX_ELEMENTOS) {
                  //  System.out.println("\nNão há espaço para cadastrar novos motoristas.");
                    //voltarMenu(in);
                    //continue;
                }*/

                Motorista mot = new Motorista();

                System.out.print("Nome: ");
                mot.setNome(in.nextLine());

                System.out.print("Habilitação: ");
                mot.setHabilitacao(in.nextLine());

                int numVezes = 0;
                do {
                    try {
                        System.out.print("CPF: ");
                        mot.setCpf(in.nextLine());
                    } catch (InputMismatchException ex) {
                        System.out.println(ex.getMessage() + " Tente novamente.");
                        numVezes += 1;
                    }
                } while (mot.getCpf() == null && numVezes < MAX_ERROS_CPF);

                // Se CPF está nulo, é porque errou as MAX_ERROS_CPF vezes. Assim, fim do programa.
                if (mot.getCpf() == null) {
                    System.out.printf("Você errou o CPF %d vezes. O programa será encerrado.", numVezes);
                    return;
                }
                
                motoristas.add(mot);// alterado para adicionar numa arryalist
                //qtdCadastrados = qtdCadastrados + 1; // reescrito para arraylist conforme abaixo
                qtdCadastrados = motoristas.size();
                

                System.out.println("\nMotorista cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("\nMOTORISTAS CADASTRADOS:");
                System.out.println("***********************");
                int n = motoristas.size(); // criado para saber o tamanho da arrylist
                for (int i = 0; i < n; i++) {
                    System.out.printf("\nMotorista %d: %s\n", (i +1), motoristas.get(i).getNome()); // realizada alterações de sintaxe para arraylist
                    System.out.printf("CPF: %s\n", motoristas.get(i).getCpf());
                    System.out.printf("Habilitação: %s\n", motoristas.get(i).getHabilitacao());
                }

                voltarMenu(in);
            } else if (opcao == 3){ //acrescentado como solictado
                if (qtdCadastrados == 0){
                    System.out.println("\nNão há CPFs cadastrados. ");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("Informe o CPF que deseja buscar: ");
                String cpfBuscado = in.nextLine();
                int n = motoristas.size();
                Motorista motEncontrado = new Motorista();
                int indexDoMotoristaEncontrado = 0;
            
                    for(int i = 0; i <n; i++) {                   
                        if (motoristas.get(i).getCpf().equals(cpfBuscado)){
                            motEncontrado = motoristas.get(i);
                            indexDoMotoristaEncontrado = i+1;
                        }
                    }
                    if (motEncontrado.getCpf()==null) {
                        System.out.println("CPF não encontrado");
                        voltarMenu(in);
                        //break;
                        
                    } else {
                        System.out.println("Motorista encontrado");
                        System.out.println("===========================");
                        System.out.printf("\nMotorista %d: %s\n", indexDoMotoristaEncontrado, motEncontrado.getNome());
                        System.out.printf("CPF: %s\n", motEncontrado.getCpf());
                        System.out.printf("Habilitação: %s\n", motEncontrado.getHabilitacao());
                        voltarMenu(in);
                        continue;
                    }
                    
                
            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}