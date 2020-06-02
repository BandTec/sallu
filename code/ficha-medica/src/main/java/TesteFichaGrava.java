import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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
                            a.getTemperaturaCorporal(),a.getSexo(),a.getDataCiclo(), a.getDataFicha(),a.getDataFicha());
                }
                else {
                    saida.format("%d %.2f %.2f %.2f %.2f %s %s %s %s%n",a.getId(), a.getPeso(),a.getAltura(),a.getPressaoArterial(),
                            a.getTemperaturaCorporal(),a.getSexo(),a.getDataCiclo(), a.getDataFicha());
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

            System.out.printf("%-8s%-10s%-12s%-21s%-21s%-21s%-16s%16s\n","ID","PESO","ALTURA","PRESSAOARTERIAL","PRESSAOCORPORAL",
                    "SEXO","DATAULTCICLO","DATAULTFICHA");

            while (entrada.hasNext()) {

                int id = entrada.nextInt();
                Double peso = entrada.nextDouble();
                Double altura = entrada.nextDouble();
                Double pressaoArterial = entrada.nextDouble();
                Double pressaoCorporal = entrada.nextDouble();
                String sexo = entrada.next();
                String dataCiclo = entrada.next();
                String dataUltFicha = entrada.next();

                System.out.printf("%-8d%3.2f%11.2f%21.2f%21.2f%15s%18s%18s%22s\n",id, peso, altura, pressaoArterial, pressaoCorporal, sexo, dataCiclo, dataUltFicha);
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
        Integer idPaciente=1;
        Double peso;
        Double altura;
        Double pressaoArterial;
        Double temperaturaCorporal = 0.0;
        String sexo;
        String nome;
        String dataCiclo;
        LocalDate dataUltFicha;
        String gestantes;
        Boolean gestante;
        int opcao;

        String classifica;

        AtendimentoAmarelo amarelo = new AtendimentoAmarelo(50);
        AtendimentoVerde verde = new AtendimentoVerde(50);
        AtendimentoVermelho vermelho = new AtendimentoVermelho(50);

        ListaObj<FichaMedica> lista = new ListaObj(150);

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
                    System.out.println("id do paciente");
                    idPaciente=1;
                    System.out.println(idPaciente);
                    System.out.println("Digite o nome do Paciente");
                    nome = leitor.next();
                    System.out.println("Digite o peso do Paciente");
                    peso = leitor.nextDouble();
                    System.out.println("Digite a altura do Paciente");
                    altura = leitor.nextDouble();
                    System.out.println("Digite sua pressão arterial do Paciente");
                    pressaoArterial = leitor.nextDouble();
                    System.out.println("Digite sua temperatura corporal do Paciente");
                    temperaturaCorporal = leitor.nextDouble();
                    System.out.println("Digite sexo do Paciente");
                    sexo = leitor.next();

                    if (sexo.equals("feminino")){
                        System.out.println("Digite a data do seu último ciclo");
                        dataCiclo= leitor.next();
                        System.out.println("É gestante ?");
                        gestantes = leitor.next();
                        if (gestantes.equals("sim")){
                            gestante=true;
                        }else {
                            gestante=false;
                        }
                        System.out.println("data da ficha do Paciente");
                        dataUltFicha= LocalDate.now();
                        System.out.println(dataUltFicha);

                        FichaMedica ficha = new FichaMedica(idPaciente, peso, altura, pressaoArterial, temperaturaCorporal,
                                sexo, nome, dataCiclo, dataUltFicha, gestante);
                        lista.adiciona(ficha);

                        if(temperaturaCorporal <= 36.9){
                            verde.insert(nome);
                            System.out.println("Sua classificação é verde");
                        }else if(temperaturaCorporal>36.9 && temperaturaCorporal <= 37.9){
                            amarelo.insert(idPaciente);
                            System.out.println("Sua classificação é amarelo");
                        }else if(temperaturaCorporal >= 38.1 || gestante == true){
                            vermelho.insert(nome);
                            System.out.println("Sua classificação é vermelho");
                        }

                    }else {
                        dataCiclo = null;
                        gestante= false;
                        System.out.println("data da ficha do Paciente");
                        dataUltFicha= LocalDate.now();
                        System.out.println(dataUltFicha);

                        FichaMedica ficha = new FichaMedica(idPaciente, peso, altura, pressaoArterial, temperaturaCorporal,
                                sexo, nome, dataCiclo, dataUltFicha,gestante);

                        lista.adiciona(ficha);

                        if(temperaturaCorporal <= 36.9){
                            verde.insert(nome);
                            System.out.println("Sua classificação é verde");
                        }else if(temperaturaCorporal>36.9 && temperaturaCorporal <= 37.9){
                            amarelo.insert(idPaciente);
                            System.out.println("Sua classificação é amarelo");
                        }else if(temperaturaCorporal >= 38.0 ){
                            vermelho.insert(nome);
                            System.out.println("Sua classificação é vermelho");
                        }
                    }
                    idPaciente++;
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
                    String atendidov;
                    String atendidoa;
                    String atendidove;
                    System.out.println("Qual sua classificação ?");
                    classifica = leitor.next();

                    if (classifica.equals("verde")){
                        verde.exibe();
                        System.out.println("Já foi atendido ?");
                        atendidov = leitor.next();
                        if (atendidov.equals("sim")){
                            verde.poll();
                            verde.exibe();
                        }if (atendidov.equals("não")){
                            verde.exibe();
                        }
                    }

                    if (classifica.equals("amarelo")){
                        amarelo.exibe();
                        System.out.println("Já foi atendido?");
                        atendidoa= leitor.next();
                        if (atendidoa.equals("sim")){
                            amarelo.poll();
                            amarelo.exibe();
                        }if (atendidoa.equals("não")){
                            amarelo.exibe();
                        }
                    }

                    if (classifica.equals("vermelho")){
                        vermelho.exibe();

                        System.out.println("Já foi atendido ?");
                        atendidove=leitor.next();
                        if (atendidove.equals("sim")){
                            vermelho.poll();
                            vermelho.exibe();
                        }if (atendidove.equals("não")){
                            vermelho.exibe();
                        }
                    }

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
