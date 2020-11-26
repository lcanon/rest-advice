// tag::adocResource[]
package org.frontdev2ops.advice;

// end::adocResource[]

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import java.net.URI;
import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;


@Path("/api/advice")
@Produces(APPLICATION_JSON)
@ApplicationScoped
public class AdviceResource {

    private static final Logger LOGGER = Logger.getLogger(AdviceResource.class);

    @Inject
    AdviceService service;

    @Operation(summary = "Returns a random advice")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Advice.class, required = true)))
    // tag::adocMetrics[]
    @Counted(name = "countGetRandomAdvice", description = "Counts how many times the getRandomAdvice method has been invoked")
    @Timed(name = "timeGetRandomAdvice", description = "Times how long it takes to invoke the getRandomAdvice method", unit = MetricUnits.MILLISECONDS)
    // end::adocMetrics[]
    @GET
    @Path("/random")
    public Response getRandomAdvice() {
        Advice advice = service.findRandomAdvice();
        LOGGER.debug("Found random advice " + advice);
        return Response.ok(advice).build();
    }

}
// end::adocResource[]
