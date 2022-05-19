package com.ias.SemilleroHandyman.infraestructure.controllers;

import com.ias.SemilleroHandyman.sharedDomain.errors.ApplicationError;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.in.CreateRequestUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRequest {

    public final CreateRequestUseCase creatRequestUseCase;

    public ControllerRequest(CreateRequestUseCase creatRequestUseCase) {
        this.creatRequestUseCase = creatRequestUseCase;
    }

    @RequestMapping(value = "/serviceRequest", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody TechnicalRequestDTO technicalRequestDTO) {
        try {
            TechnicalRequestDTO technical = creatRequestUseCase.excute(technicalRequestDTO);
            return ResponseEntity.ok(technical);

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
