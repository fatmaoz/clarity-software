package com.claritysoftware.exception;

import com.claritysoftware.annotation.DefaultExceptionMessage;
import com.claritysoftware.dto.DefaultExceptionMessageDto;
import com.claritysoftware.entity.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {
//
//    @ExceptionHandler(ProjectException.class)
//    public ResponseEntity<ResponseWrapper> serviceException(ProjectException se) {
//        String message = se.getMessage();
//        return new ResponseEntity<>(ResponseWrapper.builder().success(false).code(HttpStatus.CONFLICT.value()).message(message).build(), HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ResponseWrapper> accessDeniedException(AccessDeniedException se) {
//        String message = se.getMessage();
//        return new ResponseEntity<>(ResponseWrapper.builder().success(false).code(HttpStatus.FORBIDDEN.value()).message(message).build(), HttpStatus.FORBIDDEN);
//    }
//
//    @ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class, BadCredentialsException.class})
//    public ResponseEntity<ResponseWrapper> genericException(Throwable e, HandlerMethod handlerMethod) {
//
//        Optional<DefaultExceptionMessageDto> defaultMessage = getMessageFromAnnotation(handlerMethod.getMethod());
//        if (defaultMessage.isPresent() && !ObjectUtils.isEmpty(defaultMessage.get().getMessage())) {
//            ResponseWrapper response = ResponseWrapper
//                    .builder()
//                    .success(false)
//                    .message(defaultMessage.get().getMessage())
//                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                    .build();
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(ResponseWrapper.builder().success(false).message("Action failed: An error occurred!").code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    private Optional<DefaultExceptionMessageDto> getMessageFromAnnotation(Method method) {
//        DefaultExceptionMessage defaultExceptionMessage = method.getAnnotation(DefaultExceptionMessage.class);
//        if (defaultExceptionMessage != null) {
//            DefaultExceptionMessageDto defaultExceptionMessageDto = DefaultExceptionMessageDto
//                    .builder()
//                    .message(defaultExceptionMessage.defaultMessage())
//                    .build();
//            return Optional.of(defaultExceptionMessageDto);
//        }
//        return Optional.empty();
//    }
}