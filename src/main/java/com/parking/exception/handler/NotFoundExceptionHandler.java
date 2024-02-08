package com.parking.exception.handler;

import com.parking.dto.ErrorDTO;
import com.parking.exception.NotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;

@Singleton
@Produces
@Requires(classes = {NotFoundException.class, ExceptionHandler.class})
public class NotFoundExceptionHandler implements ExceptionHandler<NotFoundException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, NotFoundException exception) {
        return HttpResponse.badRequest().body(new ErrorDTO(exception.getMessage(), LocalDateTime.now()));
    }
}
