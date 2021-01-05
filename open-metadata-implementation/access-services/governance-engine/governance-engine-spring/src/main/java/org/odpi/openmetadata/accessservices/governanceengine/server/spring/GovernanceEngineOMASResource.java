/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.governanceengine.server.spring;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.odpi.openmetadata.accessservices.governanceengine.server.GovernanceEngineRESTServices;
import org.odpi.openmetadata.commonservices.ffdc.rest.ConnectionResponse;
import org.odpi.openmetadata.commonservices.ffdc.rest.VoidResponse;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/servers/{serverName}/open-metadata/access-services/governance-engine/users/{userId}")

@Tag(name="Governance Engine OMAS", description="The Governance Engine Open Metadata Access Service (OMAS) provides support for governance engines, services and actions.", externalDocs=@ExternalDocumentation(description="Governance Engine Open Metadata Access Service (OMAS)",url="https://egeria.odpi.org/open-metadata-implementation/access-services/governance-engine/"))

public class GovernanceEngineOMASResource
{

    private GovernanceEngineRESTServices restAPI = new GovernanceEngineRESTServices();


    /**
     * Return the connection object for the Governance Engine OMAS's out topic.
     *
     * @param serverName name of the service to route the request to.
     * @param userId identifier of calling user.
     * @param callerId unique identifier of the caller
     *
     * @return connection object for the out topic or
     * InvalidParameterException one of the parameters is null or invalid or
     * UserNotAuthorizedException user not authorized to issue this request or
     * PropertyServerException problem retrieving the topic connection.
     */
    @GetMapping(path = "/topics/out-topic-connection/{callerId}")

    public ConnectionResponse getOutTopicConnection(@PathVariable String serverName,
                                                    @PathVariable String userId,
                                                    @PathVariable String callerId)
    {
        return restAPI.getOutTopicConnection(serverName, userId, callerId);
    }


    /**
     * Log an audit message about an asset.
     *
     * @param serverName            name of server instance to route request to
     * @param userId                userId of user making request.
     * @param assetGUID             unique identifier for asset.
     * @param governanceService     unique name for governance service.
     * @param message               message to log
     * @return void or
     *  InvalidParameterException one of the parameters is null or invalid.
     *  UserNotAuthorizedException user not authorized to issue this request.
     *  PropertyServerException there was a problem that occurred within the property server.
     */
    @PostMapping(path = "/assets/{assetGUID}/log-records/{governanceService}")

    public VoidResponse logAssetAuditMessage(@PathVariable String    serverName,
                                             @PathVariable String    userId,
                                             @PathVariable String    assetGUID,
                                             @PathVariable String    governanceService,
                                             @RequestBody  String    message)
    {
        return restAPI.logAssetAuditMessage(serverName, userId, assetGUID, governanceService, message);
    }
}
