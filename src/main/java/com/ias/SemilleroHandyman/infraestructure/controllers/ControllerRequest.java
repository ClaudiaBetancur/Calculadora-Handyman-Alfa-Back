package com.ias.SemilleroHandyman.infraestructure.controllers;

import com.ias.SemilleroHandyman.application.people.models.PeopleDTO;
import com.ias.SemilleroHandyman.application.people.ports.in.QueryPersonByIdUseCase;
import com.ias.SemilleroHandyman.sharedDomain.ApplicationResponse.ResponseData;
import com.ias.SemilleroHandyman.application.technicalRequest.models.QueryByStartDateDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechinicalResquestHoursDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.models.TechnicalRequestDTO;
import com.ias.SemilleroHandyman.application.technicalRequest.ports.in.CreateTechnicalRequestUseCase;
import com.ias.SemilleroHandyman.application.technicalRequest.ports.in.QueryTechnicalRequestUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping(value = "/technicalRequest")
public class ControllerRequest {

    public final CreateTechnicalRequestUseCase creatRequestUseCase;
    public final QueryTechnicalRequestUseCase queryTechnicalRequestUseCase;
    public final QueryPersonByIdUseCase queryPersonByIdUseCase;

    public ControllerRequest(CreateTechnicalRequestUseCase creatRequestUseCase, QueryTechnicalRequestUseCase queryTechnicalRequestUseCase, QueryPersonByIdUseCase queryPersonByIdUseCase) {
        this.creatRequestUseCase = creatRequestUseCase;
        this.queryTechnicalRequestUseCase = queryTechnicalRequestUseCase;
        this.queryPersonByIdUseCase = queryPersonByIdUseCase;
    }

    @PostMapping("/")
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
                    exception.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @PostMapping("/hours")
    //@GetMapping
    public ResponseEntity<?> queryByStarDate(@RequestBody QueryByStartDateDTO queryByStartDateDTO) {
        try {
            TechinicalResquestHoursDTO techinicalResquestHoursDTO = queryTechnicalRequestUseCase.excute(queryByStartDateDTO);
            Optional<PeopleDTO> person = queryPersonByIdUseCase.excute(Integer.parseInt(queryByStartDateDTO.getIdentification()));
            String jsonString = "{" + techinicalResquestHoursDTO.toString();
            jsonString += (!person.isEmpty()) && (queryByStartDateDTO.getTypeFilter().equals("technical_id")) ? "," + person.get().toString() + "}" : "}";
            ResponseData responseData= new ResponseData(
                    true,
                    "",
                    "Horas trabajadas calculadas",
                    jsonString
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
                    exception.toString());
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




    //@GetMapping()

}
