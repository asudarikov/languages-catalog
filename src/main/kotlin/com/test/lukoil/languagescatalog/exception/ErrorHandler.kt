package com.test.lukoil.languagescatalog.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(ex: BaseException): ResponseEntity<ApiError> {
        return ResponseEntity(ex.apiError, ex.httpStatus)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val sb = StringBuilder("Validation failed: ")
        for (error in ex.bindingResult.getAllErrors()) {
            sb.append('[').append(error.defaultMessage).append("] ")
        }
        return ResponseEntity(
            ApiError(
                errorCode = "VALIDATION_FAILED",
                errorMessage = sb.toString()
            ),
            HttpStatus.BAD_REQUEST
        )
    }

}