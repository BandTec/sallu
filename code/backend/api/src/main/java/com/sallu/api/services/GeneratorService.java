package com.sallu.api.services;
import com.sallu.api.entities.Encerramento;
import com.sallu.api.entities.FichaMedica;
import com.sallu.api.entities.User;
import com.sallu.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GeneratorService {

    @Autowired
    private UserRepository repository;

    private final FileGenerator geradorArquivo = new FileGenerator();
    public void gerarArquivo(){
        geradorArquivo.gravaLista("Header", null, null);

        ListaObj<Encerramento> listaObjEncerramento = new ListaObj(3);
        Encerramento e = new  Encerramento("000", 1);
        listaObjEncerramento.adiciona(e);
        User usuario = repository.findById(SecurityContextHolder.getContext().getAuthentication().getName());

        List<FichaMedica> fichamedica = usuario.getMedicalRecords();
        ListaObj<FichaMedica> listaObjFicha = new ListaObj(fichamedica.size());
        e = new Encerramento("A00", fichamedica.size());
        listaObjEncerramento.adiciona(e);

        e = new Encerramento("C00", 0);
        for (int i = 0; i < listaObjFicha.getTamanho(); i++){
            geradorArquivo.gravaLista("A00", listaObjFicha, i);
            for (FichaMedica fichaMedicas : fichamedica){
                listaObjFicha.adiciona(fichaMedicas);
            }
            geradorArquivo.gravaLista("C00", listaObjFicha, null);
        }
        listaObjEncerramento.adiciona(e);
        geradorArquivo.gravaLista("E00", listaObjEncerramento, null);
    }
}