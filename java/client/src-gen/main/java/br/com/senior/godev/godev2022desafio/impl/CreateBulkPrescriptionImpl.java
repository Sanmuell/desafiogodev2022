/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio.impl;

import java.util.function.Supplier;

import br.com.senior.messaging.*;
import br.com.senior.messaging.utils.DtoJsonConverter;
import br.com.senior.sdl.user.UserIdentifier;			

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import br.com.senior.messaging.model.ServiceContext;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.messaging.model.ServiceRunner;

import br.com.senior.godev.godev2022desafio.CreateBulkPrescriptionInput;
import br.com.senior.godev.godev2022desafio.CreateBulkPrescriptionOutput;
import br.com.senior.godev.godev2022desafio.Godev2022desafioConstants;
import br.com.senior.godev.godev2022desafio.Godev2022desafioValidator;
import br.com.senior.godev.godev2022desafio.Godev2022desafioException;
import br.com.senior.godev.godev2022desafio.Godev2022desafioMessageException;

/**
 * 
 */
public class CreateBulkPrescriptionImpl {

	private final Supplier<IMessenger> messengerSupplier;

	private final UserIdentifier userId;

	private final Supplier<Message> messageSupplier;

	public CreateBulkPrescriptionImpl(Supplier<IMessenger> messengerSupplier, UserIdentifier userId, Supplier<Message> messageSupplier) {
		this.messengerSupplier = messengerSupplier;
		this.userId = userId;
		this.messageSupplier = messageSupplier;
	}

	private Message createMessage(CreateBulkPrescriptionInput input) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				Godev2022desafioConstants.Commands.CREATE_BULK_PRESCRIPTION, //
				DtoJsonConverter.toJSON(input));
		}
		return new Message(userId.getTenant(), //
			Godev2022desafioConstants.DOMAIN, //
			Godev2022desafioConstants.SERVICE, //
			Godev2022desafioConstants.Commands.CREATE_BULK_PRESCRIPTION, //
			DtoJsonConverter.toJSON(input));
	}
	
	/**
	* Chamada s??ncrona para o m??todo createBulkPrescription
	* This is a public operation
	* The 'createBulk' request primitive for the Prescription entity. 
	* @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	*/
	public CreateBulkPrescriptionOutput createBulkPrescription(CreateBulkPrescriptionInput input, long timeout) {
		Godev2022desafioValidator.validate(input);
		
		Message message = createMessage(input);
		Message resultMessage; 
		try {
			addMessageHeaders(message);
			resultMessage = messengerSupplier.get().requestSync(message, timeout);
			messengerSupplier.get().ack(resultMessage);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
		
		if (resultMessage == null) {
			throw new Godev2022desafioException("Retorno inv??lido");
		}
		
		if (resultMessage.isError()) {
			ErrorPayload error = DtoJsonConverter.toDTO(resultMessage.getContent(), ErrorPayload.class);
			throw new Godev2022desafioMessageException(resultMessage.getErrorCategory(), error.getMessage(), error.getErrorCode());
		}
		CreateBulkPrescriptionOutput output = DtoJsonConverter.toDTO(resultMessage.getContent(), CreateBulkPrescriptionOutput.class);
		if (output == null) {
			throw new Godev2022desafioException("Cont??udo do retorno inv??lido");
		}
		return output;
	}
	
	/**
	* Chamada ass??ncrona para o m??todo createBulkPrescription
	* This is a public operation
	* The 'createBulk' request primitive for the Prescription entity.
	*/
	public void createBulkPrescription(CreateBulkPrescriptionInput input) {
		Godev2022desafioValidator.validate(input);
		
		Message message = createMessage(input);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().send(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	* Chamada ass??ncrona para o m??todo createBulkPrescription
	* This is a public operation
	* The 'createBulk' request primitive for the Prescription entity.
	*/
	@Deprecated
	public CompletableFuture<CreateBulkPrescriptionOutput> createBulkPrescriptionRequest(CreateBulkPrescriptionInput input) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context n??o iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, CreateBulkPrescriptionOutput.class);
	}
	
	/**
	* Chamada ass??ncrona para o m??todo createBulkPrescription
	* This is a public operation
	* The 'createBulk' request primitive for the Prescription entity.
	*/
	public CompletableFuture<CreateBulkPrescriptionOutput> createBulkPrescriptionRequest(CreateBulkPrescriptionInput input, long timeout, TimeUnit unit) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context n??o iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, CreateBulkPrescriptionOutput.class, TimeUnit.MILLISECONDS.convert(timeout, unit));
	}
	
	private void addMessageHeaders(Message message) {
		message.setUsername(userId.getUsername());
		if (userId.isTrusted()) {
			message.addHeader("trusted", true);
		}
	}
}
