/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

@SubscriptionDescription(domain="godev", service="godev2022desafio", event="importResponsibleFamilyMemberEvent")
public interface ImportResponsibleFamilyMemberEvent extends MessageHandler {
    public void importResponsibleFamilyMemberEvent(ImportResponsibleFamilyMemberEventPayload payload);
    
}
