package com.jaideravila01.SE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Controller
public class ControlErrores {

    @ExceptionHandler({ Exception.class }) 
    public String manejarErrorDeHorarioLaboral(Exception ex, Model model) throws Exception {
        // Solo maneja el error específico "ORA-20502" y personaliza el mensaje
        if (ex.getMessage() != null && ex.getMessage().contains("ORA-20502")) {
            model.addAttribute("mensajeError", "Solo puede actualizar registros en días y horas laborales");
            return "ErrorHorarioLaboral"; // Vista personalizada para el error de horario laboral
        }

        // Para cualquier otro error, lanza nuevamente la excepción y permite que Spring Boot la maneje
        throw ex;
    }
}
