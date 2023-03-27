package com.naeemark.fcs.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HealthResponse {

    private String serviceName;
    private String status;
}
