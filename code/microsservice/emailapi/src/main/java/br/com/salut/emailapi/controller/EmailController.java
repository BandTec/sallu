package br.com.salut.emailapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/agendamento/{peso}/{altura}/{pressao}/{temperatura}/{alergia}/{dataUltCiclo}/{gravida}/{nomePaciente}/{emailMedico}")
    public ResponseEntity sendMail(@PathVariable("peso")String peso, @PathVariable("altura")String altura,
                                   @PathVariable("pressao")String pressao,@PathVariable("temperatura")String temperatura,
                                   @PathVariable("alergia")String alergia, @PathVariable("dataUltCiclo")String dataUltCiclo,
                                   @PathVariable("gravida")String gravida, @PathVariable("nomePaciente")String nomePaciente,@PathVariable("emailMedico")String emailMedico){
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo(emailMedico);
            helper.setSubject("Agendamento consulta médica");
            helper.setText("<h3>Ficha Médica do paciente</h3>" +
                    "Nome: "+nomePaciente+"<br>Peso: "+peso+"<br>Altura: "+altura+"<br>Pressão arterial: "+pressao+
                    "<br>Temperatura: "+temperatura+"<br>Alergia: "+alergia+"<br>Data ultimo ciclo: "+dataUltCiclo+
                    "<br>Gravida: "+gravida, true);
            mailSender.send(mail);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }


    @GetMapping("/email-interesse-hospitalar/{nome}/{cnpj}/{telefone}/{email}/{cep}/{bairro}/{end}/{num}")
    public ResponseEntity sendMail(@PathVariable("nome")String nome, @PathVariable("cnpj")String cnpj,
                                   @PathVariable("telefone")String telefone,@PathVariable("email")String email,
                                   @PathVariable("cep")String cep, @PathVariable("bairro")String bairro,
                                   @PathVariable("end")String endereco, @PathVariable("num")String num) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo("salut.corporation@gmail.com");
            helper.setSubject("Interesse hospitalar para triagem virtual");
            helper.setText("<h3>Dados do interessado</h3>" +
                    "Nome: "+nome+"<br>CNPJ: "+cnpj+"<br>Telefone: "+telefone+"<br>Email: "+email+
                    "<h3>Dados de endereço</h3>CEP: "+cep+"<br>Bairro: "+bairro+"<br>Endereço: "+endereco+
                    "<br>Logradouro: "+num, true);
            mailSender.send(mail);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}