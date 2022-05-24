package com.ias.SemilleroHandyman.infraestructure.controllers;

import com.ias.SemilleroHandyman.sharedDomain.ApplicationResponse.ResponseData;
import com.ias.SemilleroHandyman.technicalRequest.application.models.QueryByStartDateDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.technicalRequest.application.ports.in.CreateTechnicalRequestUseCase;
import com.ias.SemilleroHandyman.technicalRequest.application.servicesDomain.QueryTechnicalRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin()
public class ControllerRequest {

    public final CreateTechnicalRequestUseCase creatRequestUseCase;
    public final QueryTechnicalRequestService queryTechnicalRequestService;

    public ControllerRequest(CreateTechnicalRequestUseCase creatRequestUseCase, QueryTechnicalRequestService queryTechnicalRequestService) {
        this.creatRequestUseCase = creatRequestUseCase;
        this.queryTechnicalRequestService = queryTechnicalRequestService;
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
                    "Error del servidor inténtalo de nuevo más tarde",
                    null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @RequestMapping(value = "/technicalRequest/hours", method = RequestMethod.GET)
    //@GetMapping
    public ResponseEntity<?> queryByStarDate(@RequestBody QueryByStartDateDTO queryByStartDateDTO) {
        try {
            ArrayList<TechnicalRequestDTO> technicalRequestDTOList = queryTechnicalRequestService.excute(queryByStartDateDTO);

            ResponseData responseData= new ResponseData(
                    true,
                    "",
                    "¡Registro exitoso!",
                    technicalRequestDTOList.toString()
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
                    "Error del servidor inténtalo de nuevo más tarde",
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
                ex.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
}
