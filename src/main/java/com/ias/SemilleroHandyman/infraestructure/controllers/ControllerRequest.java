package com.ias.SemilleroHandyman.infraestructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ias.SemilleroHandyman.sharedDomain.ApplicationResponse.ResponseData;
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

            ResponseData responseData= new ResponseData(
                    true,
                    "",
                    "¡Registro exitoso!",
                    technical.toString()
            );
            return ResponseEntity.ok(responseData);

        } catch (IllegalArgumentException | NullPointerException e) {
            ResponseData responseData = new ResponseData(
                    false,
                    "InputValidation",
                    e.getMessage(),
                    null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        } catch (Exception | Error exception) {
            ResponseData responseData = new ResponseData(
                    false,
                    "SystemError",
                    "server error try again later",
                    null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @ExceptionHandler()
    public ResponseEntity<?> handleException(Exception ex) {
        ResponseData responseData = new ResponseData(
                false,
                "SystemError",
                "Revisa los datos ingresados",
                null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
}
