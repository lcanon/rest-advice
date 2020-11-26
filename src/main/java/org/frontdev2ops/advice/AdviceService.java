// tag::adocTransactional[]
package org.frontdev2ops.advice;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(REQUIRED)
public class AdviceService {

    @Transactional(SUPPORTS)
    public Advice findRandomAdvice() {
        Advice randomAdvice = null;
        while (randomAdvice == null) {
            randomAdvice = Advice.findRandom();
        }
        return randomAdvice;
    }


}
// end::adocTransactional[]
