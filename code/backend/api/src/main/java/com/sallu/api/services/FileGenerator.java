package com.sallu.api.services;
import com.sallu.api.entities.Encerramento;
import com.sallu.api.entities.FichaMedica;
import com.sallu.api.entities.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class FileGenerator {
    public void gravaLista(String opção, User pacient, ListaObj lista, Integer index, LocalDate today) {
        FileWriter arq = null;		// objeto FileWriter - representa o arquivo
        Formatter saida = null;		// objeto Formatter para executar saída formatada
        boolean deuRuim = false;	// indica se deu erro
        String nomeArquivo;			// nome do arquivo
        nomeArquivo=today+".txt";
        // nomeArquivo= pacient.getName().replace(" ","-")+"-"+LocalDate.now()+".txt";	// nome do arquivo, se for TXT }


        try {
            if(opção.equals("Header")) {
                arq = new FileWriter(nomeArquivo, false);
            }
            else {
                arq = new FileWriter(nomeArquivo, true);
            }
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);  // encerra o programa, com status de erro
        }

        // Grava no arquivo os dados dobs objetos Aluno que estão na lista
        try {
            switch (opção){
                case "Header":
                    saida.format("000%s1.0%n", LocalDateTime.now());
                    break;
                case "A00":
                    String a00 = String.format("A00%-50s%10s%15s%n",
                            pacient.getName(), pacient.getBirthdayDate(), pacient.getTelephone());
                    saida.format("%s", a00.replaceAll("null", ""));
                    break;
                case "C00":
                    for (int i=0; i < lista.getTamanho(); i++) {
                        FichaMedica ficha = (FichaMedica)lista.getElemento(i);
                        String c00 = String.format("C00%02d%04.1f%04.1f%04.1f%04.1f%1s%-50s%-8s%-10s%-8s%-8s%-20s%n",
                                ficha.getIdFichaMedica(), ficha.getPeso(), ficha.getAltura(), ficha.getPressao(),
                                ficha.getTemperaturaCorporal(),
                                ficha.getSexo(), ficha.getAlergia(), ficha.getDataUltCiclo(),
                                ficha.isGestante(), ficha.getDataFicha(),ficha.getClassificacao().getCorClassificada(),
                                ficha.getHospital().getNomeHospital());
                        saida.format("%s", c00.replaceAll("null", ""));
                    }
                    break;
                case "E00":
                    for(int i = 0; i < lista.getTamanho(); i++){
                        Encerramento e = (Encerramento)lista.getElemento(i);

                        saida.format("E00%3s%011d%n", e.getRegistro(), e.getQtdRegistros());
                    }
                    break;
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

}
