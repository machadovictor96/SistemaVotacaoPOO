package com.votacao;

import java.util.*;

public class SistemaVotacaoPOO {
    public static void main(String[] args) {
        // Inicializa lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            funcionarios.add(new Funcionario(i, "Funcionário " + i));
        }

        // Inicializa mapa de votos
        Map<Integer, Integer> votos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Processo de votação
        System.out.println("Início da votação!");

        for (int i = 1; i <= 20; i++) {
            int eleitorId = i;
            int candidatoId = -1; // Inicializa com um valor inválido

            while (true) {
                System.out.println("\nFuncionário " + i + ", digite o ID do candidato em quem você deseja votar (1-20, exceto seu próprio ID): ");

                try {
                    candidatoId = scanner.nextInt();

                    if (candidatoId == eleitorId) {
                        System.out.println("Você não pode votar em si mesmo!");
                        continue;
                    }

                    if (candidatoId < 1 || candidatoId > 20) {
                        System.out.println("ID do candidato inválido! Por favor, insira um valor entre 1 e 20.");
                        continue;
                    }

                    // Adiciona o voto no mapa de votos
                    votos.put(candidatoId, votos.getOrDefault(candidatoId, 0) + 1);
                    System.out.println("Voto registrado com sucesso!");
                    break; // Sai do loop quando o voto é registrado com sucesso

                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa o buffer do scanner
                }
            }
        }

        // Apuração dos resultados
        System.out.println("\nApuração dos resultados:");

        // Exibe os resultados para cada candidato (funcionário)
        for (Funcionario funcionario : funcionarios) {
            int candidatoId = funcionario.getId();
            int totalVotos = votos.getOrDefault(candidatoId, 0);
            System.out.println(funcionario.getNome() + " recebeu " + totalVotos + " votos.");
        }

        // Adiciona um prompt para evitar que o programa feche imediatamente
        System.out.println("\nAperte Enter para encerrar o programa...");
        scanner.nextLine(); // Limpa o buffer após a leitura dos números
        scanner.nextLine(); // Espera o usuário apertar Enter

        scanner.close();
    }
}
