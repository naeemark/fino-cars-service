package com.naeemark.fcs.api.health;


import com.naeemark.fcs.config.SwaggerConfiguration;
import com.naeemark.fcs.models.responses.HealthResponse;
import com.naeemark.fcs.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Naeem <naeemark@gmail.com>.
 * <p>
 * Created on: 2023-03-27
 */
@RestController
@RequestMapping("/api/health")
@Api(tags = {SwaggerConfiguration.HEALTH_TAG})
public class HealthController {

    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @ApiOperation(value = "HealthResponse Check", notes = "Gets health status of the service", response = HealthResponse.class)
    @GetMapping(value = "/")
    public HealthResponse checkHealth() {

        HealthResponse healthResponse = new HealthResponse(Constants.SERVICE_NAME, "OK");

        logger.info("{}", healthResponse);
        return healthResponse;
    }
}
