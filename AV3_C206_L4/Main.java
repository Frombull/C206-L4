package AV3_C206_L4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        Arquivo arq = new Arquivo();
        boolean running = true;
        ArrayList<Veiculo> veiculos;

        while (running) {
            veiculos = arq.ler();

            if(veiculos.isEmpty()){
                System.out.println("Lista vazia.");
            }

            // Menu
            System.out.println("""
                    Seleciona uma opcao ae:\s
                    1. Cadastrar veiculo
                    2. Listar veiculos
                    3. Ordenar veiculos por ano crescente
                    4. Quantidade de cada veiculo em estoque
                    """);
            System.out.print("-> ");
            int userInput = sc.nextInt();
            sc.nextLine();  
            System.out.println();

            switch (userInput) {
                case 1 -> {
                    Veiculo veiculo = new Veiculo();

                    try {
                        System.out.print("Marca: ");
                        String marca = sc.nextLine();
                        if(!marca.equalsIgnoreCase("rolls-royce") && !marca.equalsIgnoreCase("bentley")){
                            throw new ValorInvalidoException();
                        }
                        veiculo.setMarca(marca);

                        System.out.print("Modelo: ");
                        veiculo.setModelo(sc.nextLine());

                        System.out.print("Ano: ");
                        int ano = sc.nextInt();
                        if(ano < 1960 || ano > 2024){
                            throw new ValorInvalidoException();
                        }
                        veiculo.setAno(ano);

                        System.out.print("Km Rodados: ");
                        int kmRodados = sc.nextInt();
                        if (kmRodados < 0) {
                            throw new ValorInvalidoException();
                        }
                        veiculo.setKmRodados(kmRodados);

                        Motor motor = veiculo.getMotor();

                        System.out.print("Potencia do motor: ");
                        int potenciaMotor = sc.nextInt();
                        if (potenciaMotor < 0) {
                            throw new ValorInvalidoException();
                        }
                        motor.setPotencia(potenciaMotor);

                        System.out.print("Num cilindros do motor: ");
                        int numCilindros = sc.nextInt();
                        if (numCilindros < 0) {
                            throw new ValorInvalidoException();
                        }
                        motor.setNumCilindros(numCilindros);

                        System.out.println();
                    } catch (ValorInvalidoException e) {
                        System.out.println(e);
                        System.out.println("====================\n");
                        break;
                    }
                    arq.escrever(veiculo);
                }
                case 2 -> {
                    System.out.println("Lista de veiculos:");
                    System.out.println("| --------------------");
                    for (Veiculo f : veiculos) {
                        f.mostrarInfos();
                    }
                    System.out.println();
                }
                case 3 -> {
                    Collections.sort(veiculos);

                    System.out.println("Em ordem crescente:");
                    System.out.println("| --------------------");
                    for (Veiculo f : veiculos) {
                        f.mostrarInfos();
                    }
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Quantidade de veículos de cada marca disponíveis em estoque: ");
                    System.out.println("| --------------------");

                    int rolls = 0;
                    int bentley = 0;

                    for (Veiculo v : veiculos) {
                        if(v.getMarca().equalsIgnoreCase("rolls-royce")) {
                            rolls += 1;
                        }
                        else if(v.getMarca().equalsIgnoreCase("bentley")) {
                            bentley += 1;
                        }
                    }

                    System.out.println("| Rolls Royce: " + rolls);
                    System.out.println("| Bentley: " + bentley);
                    System.out.println("| --------------------");
                    System.out.println();
                }
                default -> {
                    System.out.println("Ja vai?\n");
                    running = false;
                }
            }
        }
        sc.close();
    }
}
