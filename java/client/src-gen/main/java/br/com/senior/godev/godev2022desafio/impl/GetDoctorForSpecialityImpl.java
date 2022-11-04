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

import br.com.senior.godev.godev2022desafio.GetDoctorForSpecialityInput;
import br.com.senior.godev.godev2022desafio.GetDoctorForSpecialityOutput;
import br.com.senior.godev.godev2022desafio.Godev2022desafioConstants;
import br.com.senior.godev.godev2022desafio.Godev2022desafioValidator;
import br.com.senior.godev.godev2022desafio.Godev2022desafioException;
import br.com.senior.godev.godev2022desafio.Godev2022desafioMessageException;

/**
 * 
 */
public class GetDoctorForSpecialityImpl {

	private final Supplier<IMessenger> messengerSupplier;

	private final UserIdentifier userId;

	private final Supplier<Message> messageSupplier;

	public GetDoctorForSpecialityImpl(Supplier<IMessenger> messengerSupplier, UserIdentifier userId, Supplier<Message> messageSupplier) {
		this.messengerSupplier = messengerSupplier;
		this.userId = userId;
		this.messageSupplier = messageSupplier;
	}

	private Message createMessage(GetDoctorForSpecialityInput input) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				Godev2022desafioConstants.Commands.GET_DOCTOR_FOR_SPECIALITY, //
				DtoJsonConverter.toJSON(input));
		}
		return new Message(userId.getTenant(), //
			Godev2022desafioConstants.DOMAIN, //
			Godev2022desafioConstants.SERVICE, //
			Godev2022desafioConstants.Commands.GET_DOCTOR_FOR_SPECIALITY, //
			DtoJsonConverter.toJSON(input));
	}
	
	/**
	* Chamada síncrona para o método getDoctorForSpeciality
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	* Responsável por obter Médicos por especialidade 
	* @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	*/
	public GetDoctorForSpecialityOutput getDoctorForSpeciality(GetDoctorForSpecialityInput input, long timeout) {
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
		GetDoctorForSpecialityOutput output = DtoJsonConverter.toDTO(resultMessage.getContent(), GetDoctorForSpecialityOutput.class);
		if (output == null) {
			throw new Godev2022desafioException("Contéudo do retorno inválido");
		}
		return output;
	}
	
	/**
	* Chamada assíncrona para o método getDoctorForSpeciality
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	* Responsável por obter Médicos por especialidade
	*/
	public void getDoctorForSpeciality(GetDoctorForSpecialityInput input) {
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
	* Chamada assíncrona para o método getDoctorForSpeciality
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	* Responsável por obter Médicos por especialidade
	*/
	@Deprecated
	public CompletableFuture<GetDoctorForSpecialityOutput> getDoctorForSpecialityRequest(GetDoctorForSpecialityInput input) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context não iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, GetDoctorForSpecialityOutput.class);
	}
	
	/**
	* Chamada assíncrona para o método getDoctorForSpeciality
	* Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	* Responsável por obter Médicos por especialidade
	*/
	public CompletableFuture<GetDoctorForSpecialityOutput> getDoctorForSpecialityRequest(GetDoctorForSpecialityInput input, long timeout, TimeUnit unit) {
		Godev2022desafioValidator.validate(input);
	
		if (ServiceContext.get() == null) {
			throw new ServiceException(ErrorCategory.INTERNAL_ERROR, "Service Context não iniciado. Erro ao efetuar request da mensagem");
		}
		ServiceRunner serviceRunner = ServiceContext.get().getCurrentServiceRunner();
		Message message = createMessage(input);
		addMessageHeaders(message);
		return serviceRunner.request(message, GetDoctorForSpecialityOutput.class, TimeUnit.MILLISECONDS.convert(timeout, unit));
	}
	
	private void addMessageHeaders(Message message) {
		message.setUsername(userId.getUsername());
		if (userId.isTrusted()) {
			message.addHeader("trusted", true);
		}
	}
}
