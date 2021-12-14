package com.bridgelabz.employeepayrollserviceapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * purpose: to maintain the response data in an object
 * class contains fields for message and Data
 *
 * @author  Sunil
 * @version 0.0.1
 * @since 7/12/2021
 */
@Data
@AllArgsConstructor
public class ResponseDTO {

    private String message;
    private Object data;
}