// tag::adocApplication[]
package org.frontdev2ops.advice;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
    info = @Info(title = "User API",
        description = "This API allows CRUD operations on an advice",
        version = "1.0",
        contact = @Contact(name = "Quarkus", url = "https://github.com/quarkusio")),
    externalDocs = @ExternalDocumentation(url = "https://github.com/quarkusio/quarkus-workshops", description = "All the Quarkus workshops"),
    tags = {
        @Tag(name = "api", description = "Public that can be used by anybody"),
        @Tag(name = "users", description = "Anybody interested in advice")
    }
)
public class AdviceApplication extends Application {
}
// end::adocApplication[]
