/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * Default 'serviceStarted' event.
 */
@SubscriptionDescription(domain="godev", service="godev2022desafio", event="serviceStarted")
public interface ServiceStarted extends MessageHandler {
    public void serviceStarted(ServiceStartedPayload payload);
    
}
