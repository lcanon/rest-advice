// tag::adocEntity[]
package org.frontdev2ops.advice;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.Random;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Schema(description = "The economical advice")
public class Advice extends PanacheEntity {

    @NotNull
    public String concept;

    @NotNull
    public String description;

    @NotNull
    public String advice;

    public String url;

    // tag::adocSkip[]
    @Override
    public String toString() {
        return "Advice{" +
            "id=" + id +
            ", concept='" + concept + '\'' +
            ", description='" + description + '\'' +
            ", advice='" + advice + '\'' +
            ", url='" + url + '\'' +
            '}';
    }

    public static Advice findRandom() {
        long countAdvice = count();
        Random random = new Random();
        int randomAdvice = random.nextInt((int) countAdvice);
        return findAll().page(randomAdvice, 1).firstResult();
    }
    // end::adocSkip[]
}
// end::adocEntity[]
