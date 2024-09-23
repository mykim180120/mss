package com.mss.fashion.common.error.dto;

public interface CommonErrorConst {
    long BAD_REQUEST_ERROR_CODE = 000000L;
    String BAD_REQUEST_ERROR_MESSAGE = "Bad Request";

    long NOT_FOUND_ERROR_CODE = 000000L;
    String NOT_FOUND_ERROR_MESSAGE = "Not Found";

    long METHOD_NOT_ALLOWED_ERROR_CODE = 000000L;
    String METHOD_NOT_ALLOWED_ERROR_MESSAGE = "Method Not Allowed";

    long NOT_IMPLEMENTED_ERROR_CODE = 000000L;
    String NOT_IMPLEMENTED_ERROR_MESSAGE = "Not Implemented";

    long MALFORMED_URL_ERROR_CODE = 000000L;
    String MALFORMED_URL_ERROR_MESSAGE = "Wrong URL string requested.";

    long MISSING_REQUEST_HEADER_ERROR_CODE = 000000L;
    String MISSING_REQUEST_HEADER_ERROR_MESSAGE = "Missing Request Header";

    long UNKNOWN_ERROR_CODE = 000000L;
    String UNKNOWN_ERROR_MESSAGE = "Unknown";
}
