package com.ias.SemilleroHandyman.infraestructure.controllers;

import com.ias.SemilleroHandyman.sharedDomain.errors.ApplicationError;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.in.CreateTechnicalRequestUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class ControllerRequest {

    public final CreateTechnicalRequestUseCase creatRequestUseCase;

    public ControllerRequest(CreateTechnicalRequestUseCase creatRequestUseCase) {
        this.creatRequestUseCase = creatRequestUseCase;
    }

    @RequestMapping(value = "/technicalRequest", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody TechnicalRequestDTO technicalRequestDTO) {
        try {
            TechnicalRequestDTO technical = creatRequestUseCase.excute(technicalRequestDTO);
            return ResponseEntity.ok("¡Registro exitoso!");

        } catch (IllegalArgumentException | NullPointerException e) {
            ApplicationError aplicationError = new ApplicationError(
                    "InputValidation",
                    "Bad input data: " + e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            ApplicationError aplicationError = new ApplicationError(
                    "SystemError",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }
}
