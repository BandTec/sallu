import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteFichaGrava {

    public static void gravaLista(ListaObj<FichaMedica> lista, boolean isCSV) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;
        String nomeArquivo;

        if (isCSV) {
            nomeArquivo= "fichaPaciente.csv";
        }
        else {
            nomeArquivo= "fichaPaciente.txt";
        }


        try {
            arq = new FileWriter(nomeArquivo, true);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }


        try {

            for (int i=0; i< lista.getTamanho(); i++) {
                FichaMedica a = lista.getElemento(i);

                if (isCSV) {
                    saida.format("%d;%.2f;%.2f;%.2f;%.2f;%s;%s;%s;%s%n",a.getId(), a.getPeso(),a.getAltura(),a.getPressaoArterial(),
                            a.getPressaoCorporal(),a.getSexo(),a.getAlergia(),a.getDataCiclo(), a.getDataUltFicha());
                }
                else {
                    saida.format("%d %.2f %.2f %.2f %.2f %s %s %s %s%n",a.getId(), a.getPeso(),a.getAltura(),a.getPressaoArterial(),
                            a.getPressaoCorporal(),a.getSexo(),a.getAlergia(),a.getDataCiclo(), a.getDataUltFicha());
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally {
            saida.close();

            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivo(boolean isCSV) {
        FileReader arq= null;
        Scanner entrada = null;
        String nomeArquivo;
        boolean deuRuim= false;

        if (isCSV) {
            nomeArquivo= "fichaPaciente.csv";
        }
        else {
            nomeArquivo= "fichaPaciente.txt";
        }


        try {
            arq = new FileReader(nomeArquivo);
            if (isCSV) {
                entrada = new Scanner(arq).useDelimiter(";|\\r\\n");
            }
            else {
                entrada = new Scanner(arq);
            }
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {

            System.out.printf("%-8s%-10s%-12s%-21s%-21s%-21s%-13s%-16s%16s\n","ID","PESO","ALTURA","PRESSAOARTERIAL","PRESSAOCORPORAL",
                    "SEXO","ALERGIA","DATAULTCICLO","DATAULTFICHA");

            while (entrada.hasNext()) {

                int id = entrada.nextInt();
                Double peso = entrada.nextDouble();
                Double altura = entrada.nextDouble();
                Double pressaoArterial = entrada.nextDouble();
                Double pressaoCorporal = entrada.nextDouble();
                String sexo = entrada.next();
                String alergia = entrada.next();
                String dataCiclo = entrada.next();
                String dataUltFicha = entrada.next();

                System.out.printf("%-8d%3.2f%11.2f%21.2f%21.2f%15s%18s%18s%22s\n",id, peso, altura, pressaoArterial, pressaoCorporal, sexo, alergia, dataCiclo, dataUltFicha);
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean fim = false;
        Integer id;
        Double peso;
        Double altura;
        Double pressaoArterial;
        Double temperaturaCorporal = 0.0;
        String sexo;
        String nome;
        String dataCiclo;
        String dataUltFicha;
        int opcao;
        int tamanhoAmarelo;
        int tamanhoVermelho;
        int tamanhoVerde;

        AtendimentoAmarelo amarelo = new AtendimentoAmarelo(50);
        AtendimentoVerde verde = new AtendimentoVerde(50);
        AtendimentoVermelho vermelho = new AtendimentoVermelho(50);

        ListaObj<FichaMedica> lista = new ListaObj(10);

        while (!fim) {	// Fica num loop até que o usuário escolha Fim
            // Exibe o menu de opções para o usuário
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1- Adicionar uma nova ficha médica");
            System.out.println("2- Exibir a lista de ficha médica");
            System.out.println("3- Gravar a ficha médica em um arquivo txt");
            System.out.println("4- Gravar a lista num arquivo csv");
            System.out.println("5- Ler e exibir arquivo txt");
            System.out.println("6- Ler e exibir arquivo csv");
            System.out.println("7- Verificar lista de atendimento");
            System.out.println("8- Fim");

            opcao= leitor.nextInt();

            switch(opcao) {

                case 1:
                    System.out.println("Digite o id do paciente");
                    id= leitor.nextInt();
                    System.out.println("Digite o nome do Paciente");
                    nome = leitor.next();
                    System.out.println("Digite o peso do Paciente");
                    peso = leitor.nextDouble();
                    System.out.println("Digite a altura do Paciente");
                    altura = leitor.nextDouble();
                    System.out.println("Digite sua pressão arterial do Paciente");
                    pressaoArterial = leitor.nextDouble();
                    System.out.println("Digite sua pressão corporal do Paciente");
                    temperaturaCorporal = leitor.nextDouble();
                    System.out.println("Digite seu sexo do Paciente");
                    sexo = leitor.next();

                    if (sexo.equals("feminino")){
                        System.out.println("Digite a data do seu último ciclo");
                        dataCiclo= leitor.next();
                        System.out.println("Digite a data da ultima ficha do Paciente");
                        dataUltFicha= leitor.next();

                        FichaMedica ficha = new FichaMedica(id, peso, altura, pressaoArterial, temperaturaCorporal,
                                sexo, nome, dataCiclo, dataUltFicha);

                        lista.adiciona(ficha);
                    }else {
                        dataCiclo = null;
                        System.out.println("Digite a data da ultima ficha do Paciente");
                        dataUltFicha= leitor.next();

                        FichaMedica ficha = new FichaMedica(id, peso, altura, pressaoArterial, temperaturaCorporal,
                                sexo, nome, dataCiclo, dataUltFicha);

                        lista.adiciona(ficha);
                    }
                    break;

                case 2:

                    if (lista.getTamanho() == 0)  {
                        System.out.println("Lista vazia");
                    }
                    else {
                        lista.exibe();
                    }
                    break;

                case 3:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, false);
                        lista.limpa();
                    }
                    break;

                case 4:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, true);
                        lista.limpa();
                    }
                    break;

                case 5:
                    leExibeArquivo(false);
                    break;

                case 6:
                    leExibeArquivo(true);
                    break;

                case 7:

                    if(temperaturaCorporal <= 36.9){
                        verde.insert(nome);
                        System.out.println(verde.poll());
                        System.out.println("Primeiro: " + verde.peek());

                    }else if(temperaturaCorporal <= 37.9){
                       amarelo.insert(nome);
                        System.out.println(verde.poll());
                        System.out.println("Primeiro: " + vermelho.peek());

                    }else if(temperaturaCorporal >= 38.1){
                        vermelho.insert(nome);
                        System.out.println(verde.poll());
                        System.out.println("Primeiro: " + amarelo.peek());
                    }


                    verde.exibe();
                    vermelho.exibe();
                    amarelo.exibe();

                case 8:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}
