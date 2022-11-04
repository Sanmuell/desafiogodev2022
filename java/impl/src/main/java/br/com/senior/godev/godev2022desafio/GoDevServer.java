package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.Server;
import br.com.senior.messaging.model.ServiceDescription;

@ServiceDescription(domain = Godev2022desafioConstants.DOMAIN, name = Godev2022desafioConstants.SERVICE, packages = { //
        "br.com.senior.godev", //
        "br.com.senior.platform.translationhub" // Package do translation-hub-api
})

public class GoDevServer extends Server {

    public static void main(String[] args) {
        bootstrap(new GoDevServer());
    }

}
