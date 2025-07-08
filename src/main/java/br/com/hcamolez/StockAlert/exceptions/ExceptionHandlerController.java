package br.com.hcamolez.StockAlert.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
