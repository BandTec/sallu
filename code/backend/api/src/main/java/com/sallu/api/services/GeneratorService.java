package com.sallu.api.services;
import com.sallu.api.entities.Encerramento;
import com.sallu.api.entities.FichaMedica;
import com.sallu.api.entities.User;
import com.sallu.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GeneratorService {

    @Autowired
    private UserRepository repository;

    private final FileGenerator geradorArquivo = new FileGenerator();
    public void gerarArquivo(){
        User usuario = repository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
        geradorArquivo.gravaLista("Header", usuario,null, null);

        ListaObj<Encerramento> listaObjEncerramento = new ListaObj(3);
        Encerramento e = new  Encerramento("000", 1);
        listaObjEncerramento.adiciona(e);


        geradorArquivo.gravaLista("A00", usuario, null, null);

        ListaObj<FichaMedica> listaObjFichaMedica = new ListaObj<>(usuario.getMedicalRecords().size());
        e.setQtdRegistros(e.getQtdRegistros() + usuario.getMedicalRecords().size());
        for (int i = 0; i < usuario.getMedicalRecords().size(); i++) {
            listaObjFichaMedica.adiciona(usuario.getMedicalRecords().get(i));
        }


        geradorArquivo.gravaLista("C00", null, listaObjFichaMedica, null);
        listaObjEncerramento.adiciona(e);

        geradorArquivo.gravaLista("E00",null, listaObjEncerramento, null);
    }
}