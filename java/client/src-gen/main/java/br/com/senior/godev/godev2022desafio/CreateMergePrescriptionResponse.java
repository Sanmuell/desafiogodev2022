/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createMergePrescription
 */
@CommandDescription(name="createMergePrescriptionResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMergePrescriptionResponse")
public interface CreateMergePrescriptionResponse extends MessageHandler {

	void createMergePrescriptionResponse(Prescription response);
	
	void createMergePrescriptionResponseError(ErrorPayload error);

}
