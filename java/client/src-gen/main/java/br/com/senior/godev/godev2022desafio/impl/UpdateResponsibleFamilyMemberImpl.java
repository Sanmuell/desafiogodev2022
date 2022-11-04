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

import br.com.senior.godev.godev2022desafio.ResponsibleFamilyMember;
import br.com.senior.godev.godev2022desafio.Godev2022desafioConstants;
import br.com.senior.godev.godev2022desafio.Godev2022desafioValidator;
import br.com.senior.godev.godev2022desafio.Godev2022desafioException;
import br.com.senior.godev.godev2022desafio.Godev2022desafioMessageException;

/**
 * 
 */
public class UpdateResponsibleFamilyMemberImpl {

	private final Supplier<IMessenger> messengerSupplier;

	private final UserIdentifier userId;

	private final Supplier<Message> messageSupplier;

	public UpdateResponsibleFamilyMemberImpl(Supplier<IMessenger> messengerSupplier, UserIdentifier userId, Supplier<Message> messageSupplier) {
		this.messengerSupplier = messengerSupplier;
		this.userId = userId;
		this.messageSupplier = messageSupplier;
	}

	private Message createMessage(ResponsibleFamilyMember input) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				Godev2022desafioConstants.Commands.UPDATE_RESPONSIBLE_FAMILY_MEMBER, //
				DtoJsonConverter.toJSON(input));
		}
		return new Message(userId.getTenant(), //
			Godev2022desafioConstants.DOMAIN, //
			Godev2022desafioConstants.SERVICE, //
			Godev2022desafioConstants.Commands.UPDATE_RESPONSIBLE_FAMILY_MEMBER, //
			DtoJsonConverter.toJSON(input));
	}
	
	/**
	* Chamada síncrona para o método updateResponsibleFamilyMember
	* This is a public operation
	* The 'update' request primitive for the ResponsibleFamilyMember entity. 
	* @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	*/
	public ResponsibleFamilyMember updateResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout) {
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
			throw new Godev2022desafioException("Retorno inválido");
		}
		
		if (resultMessage.isError()) {
			ErrorPayload error = DtoJsonConverter.toDTO(resultMessage.getContent(), ErrorPayload.class);
			throw new Godev2022desafioMessageException(resultMessage.getErrorCategory(), error.getMessage(), error.getErrorCode());
		}
		ResponsibleFamilyMember output = DtoJsonConverter.toDTO(resultMessage.getContent(), ResponsibleFamilyMember.class);
		if (output == null) {
			throw new Godev2022desafioException("Contéudo do retorno inválido");
		}
		return output;
	}
	
	/**
	* Chamada assíncrona para o método updateResponsibleFamilyMember
	* This is a public operation
	* The 'update' request primitive for the ResponsibleFamilyMember entity.
	*/
	public void updateResponsibleFamilyMember(ResponsibleFamilyMember input) {
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
	* Chamada assíncrona para o método updateResponsibleFamilyMember
	* This is a public operation
	* The 'update' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Deprecated
	public CompletableFuture<ResponsibleFamilyMember> updateResponsibleFamilyMemberRequest(ResponsibleFamilyMember input) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context não iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, ResponsibleFamilyMember.class);
	}
	
	/**
	* Chamada assíncrona para o método updateResponsibleFamilyMember
	* This is a public operation
	* The 'update' request primitive for the ResponsibleFamilyMember entity.
	*/
	public CompletableFuture<ResponsibleFamilyMember> updateResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout, TimeUnit unit) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context não iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, ResponsibleFamilyMember.class, TimeUnit.MILLISECONDS.convert(timeout, unit));
	}
	
	private void addMessageHeaders(Message message) {
		message.setUsername(userId.getUsername());
		if (userId.isTrusted()) {
			message.addHeader("trusted", true);
		}
	}
}
