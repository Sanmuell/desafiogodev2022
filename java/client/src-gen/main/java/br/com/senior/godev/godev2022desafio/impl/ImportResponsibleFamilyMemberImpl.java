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

import br.com.senior.godev.godev2022desafio.ImportResponsibleFamilyMemberInput;
import br.com.senior.godev.godev2022desafio.ImportResponsibleFamilyMemberOutput;
import br.com.senior.godev.godev2022desafio.Godev2022desafioConstants;
import br.com.senior.godev.godev2022desafio.Godev2022desafioValidator;
import br.com.senior.godev.godev2022desafio.Godev2022desafioException;
import br.com.senior.godev.godev2022desafio.Godev2022desafioMessageException;

/**
 * 
 */
public class ImportResponsibleFamilyMemberImpl {

	private final Supplier<IMessenger> messengerSupplier;

	private final UserIdentifier userId;

	private final Supplier<Message> messageSupplier;

	public ImportResponsibleFamilyMemberImpl(Supplier<IMessenger> messengerSupplier, UserIdentifier userId, Supplier<Message> messageSupplier) {
		this.messengerSupplier = messengerSupplier;
		this.userId = userId;
		this.messageSupplier = messageSupplier;
	}

	private Message createMessage(ImportResponsibleFamilyMemberInput input) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				Godev2022desafioConstants.Commands.IMPORT_RESPONSIBLE_FAMILY_MEMBER, //
				DtoJsonConverter.toJSON(input));
		}
		return new Message(userId.getTenant(), //
			Godev2022desafioConstants.DOMAIN, //
			Godev2022desafioConstants.SERVICE, //
			Godev2022desafioConstants.Commands.IMPORT_RESPONSIBLE_FAMILY_MEMBER, //
			DtoJsonConverter.toJSON(input));
	}
	
	/**
	* Chamada s??ncrona para o m??todo importResponsibleFamilyMember
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	*  
	* @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	*/
	public ImportResponsibleFamilyMemberOutput importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput input, long timeout) {
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
		ImportResponsibleFamilyMemberOutput output = DtoJsonConverter.toDTO(resultMessage.getContent(), ImportResponsibleFamilyMemberOutput.class);
		if (output == null) {
			throw new Godev2022desafioException("Cont??udo do retorno inv??lido");
		}
		return output;
	}
	
	/**
	* Chamada ass??ncrona para o m??todo importResponsibleFamilyMember
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	* 
	*/
	public void importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput input) {
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
	* Chamada ass??ncrona para o m??todo importResponsibleFamilyMember
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	* 
	*/
	@Deprecated
	public CompletableFuture<ImportResponsibleFamilyMemberOutput> importResponsibleFamilyMemberRequest(ImportResponsibleFamilyMemberInput input) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context n??o iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, ImportResponsibleFamilyMemberOutput.class);
	}
	
	/**
	* Chamada ass??ncrona para o m??todo importResponsibleFamilyMember
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	* 
	*/
	public CompletableFuture<ImportResponsibleFamilyMemberOutput> importResponsibleFamilyMemberRequest(ImportResponsibleFamilyMemberInput input, long timeout, TimeUnit unit) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context n??o iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, ImportResponsibleFamilyMemberOutput.class, TimeUnit.MILLISECONDS.convert(timeout, unit));
	}
	
	private void addMessageHeaders(Message message) {
		message.setUsername(userId.getUsername());
		if (userId.isTrusted()) {
			message.addHeader("trusted", true);
		}
	}
}
