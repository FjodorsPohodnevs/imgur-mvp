package com.fjodors.imgurmvp.data.remote;

import com.fjodors.imgurmvp.R;

import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public class ErrorManager {
    public static final int RATE_LIMIT = 429;

    public static int getErrorMessage(Throwable error) {
        if (error instanceof UnknownHostException) {
            return R.string.error_network;
        }
        return R.string.error_generic;
    }

    public static int getErrorMessage(int httpStatus) {
        switch (httpStatus) {
            case HttpURLConnection.HTTP_BAD_REQUEST:
                return R.string.error_400;
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                return R.string.error_401;
            case HttpURLConnection.HTTP_FORBIDDEN:
                return R.string.error_403;
            case HttpURLConnection.HTTP_NOT_FOUND:
                return R.string.error_404;
            case RATE_LIMIT:
                return R.string.error_429;
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
                return R.string.error_500;
            default:
                return R.string.error_generic;
        }
    }
}
