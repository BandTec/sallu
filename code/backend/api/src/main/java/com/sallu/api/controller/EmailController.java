package com.sallu.api.controller;
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

    @GetMapping("/email-interesse-hospitalar/{nome}/{cnpj}/{telefone}/{email}/{cep}/{bairro}/{end}/{num}")
    public ResponseEntity sendMail(@PathVariable("nome")String nome, @PathVariable("cnpj")String cnpj,
                                   @PathVariable("telefone")String telefone,@PathVariable("email")String email,
                                   @PathVariable("cep")String cep, @PathVariable("bairro")String bairro,
                                   @PathVariable("end")String endereco, @PathVariable("num")String num) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo("salut.bandtec@gmail.com");
            helper.setSubject("Interesse hospitalar para triagem virtual");
            helper.setText("<h2>Dados do interessado</h2>" +
                    "Nome: "+nome+"<br>CNPJ: "+cnpj+"<br>Telefone: "+telefone+"<br>Email: "+email+
                    "<h2>Dados de endereço</h2>CEP: "+cep+"<br>Bairro: "+bairro+"<br>Endereço: "+endereco+
                    "<br>Logradouro: "+num, true);
            mailSender.send(mail);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
//    @RequestMapping(path = "/email-send", method = RequestMethod.GET)
//    public String sendMail() {
//        try {
//            MimeMessage mail = mailSender.createMimeMessage();
//
//            MimeMessageHelper helper = new MimeMessageHelper( mail );
//            helper.setTo( "salut.bandtec@gmail.com" );
//            helper.setSubject( "Interesse hospitalar para triagem virtual" );
//            helper.setText("<p>Hello from Spring Boot Application</p>", true);
//            mailSender.send(mail);
//
//            return "OK";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Erro ao enviar e-mail";
//        }
//    }