package br.com.hcamolez.StockAlert.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {
    private MessageSource messageSource;
    public ExceptionHandlerController(MessageSource message){this.messageSource = message;}
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<List<ErroMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
       List<ErroMessageDTO> dto = new ArrayList<>();
       exception.getBindingResult().getFieldErrors().forEach(error -> {
           String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
           ErroMessageDTO err = new ErroMessageDTO(message, error.getField());
           dto.add(err);
       });
       return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
   }
   @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<DatabaseErrorDTO> database(DatabaseException e, HttpServletRequest request) {
        DatabaseErrorDTO databaseErrorDTO = new DatabaseErrorDTO();
        HttpStatus status = HttpStatus.NOT_FOUND;
        databaseErrorDTO.setTimestamp(Instant.from(LocalDateTime.from(Instant.now())));
        databaseErrorDTO.setStatus(status.value());
        databaseErrorDTO.setError("Database exception");
        databaseErrorDTO.setMessage(e.getMessage());
        databaseErrorDTO.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(databaseErrorDTO);
    }



}
