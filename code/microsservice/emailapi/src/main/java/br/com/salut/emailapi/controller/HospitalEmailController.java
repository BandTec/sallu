package br.com.salut.emailapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
public class HospitalEmailController
{
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/consulta/{hospital}/{nomePaciente}/{email}/{sintomas}")
    public ResponseEntity sendMail(@PathVariable("hospital") String hospital, @PathVariable("nomePaciente") String nomePaciente,
                                   @PathVariable("email") String email,@PathVariable("sintomas") String sintomas)
    {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo("doutorjaoroberto@gmail.com");
            helper.setSubject("Informações do Paciente");
            helper.setText("<h3>Dados do Paciente</h3>" + "Nome do Paciente: " + nomePaciente + "<br>" +
                    " contato: " + email + "<br>" + "Sintomas Apresentado: <br>" + sintomas, true);

            mailSender.send(mail);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
