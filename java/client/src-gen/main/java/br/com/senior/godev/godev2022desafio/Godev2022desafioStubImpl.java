/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import br.com.senior.messaging.*;
import br.com.senior.messaging.utils.DtoJsonConverter;
import br.com.senior.sdl.user.UserIdentifier;

import java.util.concurrent.CompletableFuture;


/**
* 
*/
@SuppressWarnings("deprecation") // To prevent warnings in generated code about known deprecated methods.
public class Godev2022desafioStubImpl  implements Godev2022desafioStub {

	protected final Supplier<IMessenger> messengerSupplier;
	protected final UserIdentifier userId;
	protected final Supplier<Message> messageSupplier;

	/**
	 * Use {@link #Godev2022desafioStubImpl(MessengerSupplier, UserIdentifier, MessageSupplier)} instead.
	 */
	@Deprecated
	public Godev2022desafioStubImpl(IMessenger messenger, UserIdentifier userId) {
		this(new br.com.senior.godev.godev2022desafio.InstanceMessengerSupplier(messenger), userId, null);
	}

	/**
	 * @param messengerSupplier Supplies current service messenger.
	 * @param userId Provides tenant and user name to send or publish messages.
	 * @param messageSupplier Supplies current message being processed by service. Used to send messages by foolowup.
	 */
	public Godev2022desafioStubImpl(Supplier<IMessenger> messengerSupplier, UserIdentifier userId, Supplier<Message> messageSupplier) {
		this.messengerSupplier = messengerSupplier;
		this.userId = userId;
		this.messageSupplier = messageSupplier;
	}

	/**
	 * Chamada síncrona para o método alterStatusPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public AlterStatusPatientOutput alterStatusPatient(AlterStatusPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.AlterStatusPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.AlterStatusPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.alterStatusPatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método alterStatusPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	 */
	@Override
	public void alterStatusPatient(AlterStatusPatientInput input) {
		br.com.senior.godev.godev2022desafio.impl.AlterStatusPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.AlterStatusPatientImpl(messengerSupplier, userId, messageSupplier);
		impl.alterStatusPatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método alterStatusPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	 */
	@Override
	public CompletableFuture<AlterStatusPatientOutput> alterStatusPatientRequest(AlterStatusPatientInput input) {
		return this.alterStatusPatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método alterStatusPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	*/
	@Override
	public CompletableFuture<AlterStatusPatientOutput> alterStatusPatientRequest(AlterStatusPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.AlterStatusPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.AlterStatusPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.alterStatusPatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método getDoctorForSpeciality
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetDoctorForSpecialityOutput getDoctorForSpeciality(GetDoctorForSpecialityInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetDoctorForSpecialityImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetDoctorForSpecialityImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDoctorForSpeciality(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getDoctorForSpeciality
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	 */
	@Override
	public void getDoctorForSpeciality(GetDoctorForSpecialityInput input) {
		br.com.senior.godev.godev2022desafio.impl.GetDoctorForSpecialityImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetDoctorForSpecialityImpl(messengerSupplier, userId, messageSupplier);
		impl.getDoctorForSpeciality(input);
	}
	
	/**
	 * Chamada assíncrona para o método getDoctorForSpeciality
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	 */
	@Override
	public CompletableFuture<GetDoctorForSpecialityOutput> getDoctorForSpecialityRequest(GetDoctorForSpecialityInput input) {
		return this.getDoctorForSpecialityRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método getDoctorForSpeciality
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	*/
	@Override
	public CompletableFuture<GetDoctorForSpecialityOutput> getDoctorForSpecialityRequest(GetDoctorForSpecialityInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetDoctorForSpecialityImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetDoctorForSpecialityImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDoctorForSpecialityRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método getPrescriptionsForDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetPrescriptionsForDoctorOutput getPrescriptionsForDoctor(GetPrescriptionsForDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetPrescriptionsForDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetPrescriptionsForDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.getPrescriptionsForDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getPrescriptionsForDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	 */
	@Override
	public void getPrescriptionsForDoctor(GetPrescriptionsForDoctorInput input) {
		br.com.senior.godev.godev2022desafio.impl.GetPrescriptionsForDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetPrescriptionsForDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.getPrescriptionsForDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método getPrescriptionsForDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	 */
	@Override
	public CompletableFuture<GetPrescriptionsForDoctorOutput> getPrescriptionsForDoctorRequest(GetPrescriptionsForDoctorInput input) {
		return this.getPrescriptionsForDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método getPrescriptionsForDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	*/
	@Override
	public CompletableFuture<GetPrescriptionsForDoctorOutput> getPrescriptionsForDoctorRequest(GetPrescriptionsForDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetPrescriptionsForDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetPrescriptionsForDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.getPrescriptionsForDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetMetadataOutput getMetadata(GetMetadataInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetMetadataImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		return impl.getMetadata(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 */
	@Override
	public void getMetadata(GetMetadataInput input) {
		br.com.senior.godev.godev2022desafio.impl.GetMetadataImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		impl.getMetadata(input);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 */
	@Override
	public CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input) {
		return this.getMetadataRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método getMetadata
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	*/
	@Override
	public CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetMetadataImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetMetadataImpl(messengerSupplier, userId, messageSupplier);
		return impl.getMetadataRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportPatientOutput importPatient(ImportPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.importPatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importPatient(ImportPatientInput input) {
		br.com.senior.godev.godev2022desafio.impl.ImportPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportPatientImpl(messengerSupplier, userId, messageSupplier);
		impl.importPatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método importPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportPatientOutput> importPatientRequest(ImportPatientInput input) {
		return this.importPatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportPatientOutput> importPatientRequest(ImportPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.importPatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportPatientOutput exportPatient(ExportPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportPatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportPatient(ExportPatientInput input) {
		br.com.senior.godev.godev2022desafio.impl.ExportPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportPatientImpl(messengerSupplier, userId, messageSupplier);
		impl.exportPatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportPatientOutput> exportPatientRequest(ExportPatientInput input) {
		return this.exportPatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportPatientOutput> exportPatientRequest(ExportPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportPatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportDoctorOutput importDoctor(ImportDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.importDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importDoctor(ImportDoctorInput input) {
		br.com.senior.godev.godev2022desafio.impl.ImportDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.importDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método importDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportDoctorOutput> importDoctorRequest(ImportDoctorInput input) {
		return this.importDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportDoctorOutput> importDoctorRequest(ImportDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.importDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportDoctorOutput exportDoctor(ExportDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportDoctor(ExportDoctorInput input) {
		br.com.senior.godev.godev2022desafio.impl.ExportDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.exportDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportDoctorOutput> exportDoctorRequest(ExportDoctorInput input) {
		return this.exportDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportDoctorOutput> exportDoctorRequest(ExportDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportPrescriptionOutput importPrescription(ImportPrescriptionInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.importPrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importPrescription(ImportPrescriptionInput input) {
		br.com.senior.godev.godev2022desafio.impl.ImportPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.importPrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método importPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportPrescriptionOutput> importPrescriptionRequest(ImportPrescriptionInput input) {
		return this.importPrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportPrescriptionOutput> importPrescriptionRequest(ImportPrescriptionInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.importPrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportPrescriptionOutput exportPrescription(ExportPrescriptionInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportPrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportPrescription(ExportPrescriptionInput input) {
		br.com.senior.godev.godev2022desafio.impl.ExportPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.exportPrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportPrescriptionOutput> exportPrescriptionRequest(ExportPrescriptionInput input) {
		return this.exportPrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportPrescriptionOutput> exportPrescriptionRequest(ExportPrescriptionInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportPrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método importResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ImportResponsibleFamilyMemberOutput importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.importResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método importResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput input) {
		br.com.senior.godev.godev2022desafio.impl.ImportResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.importResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método importResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ImportResponsibleFamilyMemberOutput> importResponsibleFamilyMemberRequest(ImportResponsibleFamilyMemberInput input) {
		return this.importResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método importResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ImportResponsibleFamilyMemberOutput> importResponsibleFamilyMemberRequest(ImportResponsibleFamilyMemberInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ImportResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ImportResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.importResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método exportResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ExportResponsibleFamilyMemberOutput exportResponsibleFamilyMember(ExportResponsibleFamilyMemberInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método exportResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public void exportResponsibleFamilyMember(ExportResponsibleFamilyMemberInput input) {
		br.com.senior.godev.godev2022desafio.impl.ExportResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.exportResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método exportResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 */
	@Override
	public CompletableFuture<ExportResponsibleFamilyMemberOutput> exportResponsibleFamilyMemberRequest(ExportResponsibleFamilyMemberInput input) {
		return this.exportResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método exportResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	*/
	@Override
	public CompletableFuture<ExportResponsibleFamilyMemberOutput> exportResponsibleFamilyMemberRequest(ExportResponsibleFamilyMemberInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ExportResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ExportResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.exportResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Patient.PagedResults listPatient(Patient.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.listPatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	 */
	@Override
	public void listPatient(Patient.PageRequest input) {
		br.com.senior.godev.godev2022desafio.impl.ListPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListPatientImpl(messengerSupplier, userId, messageSupplier);
		impl.listPatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método listPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	 */
	@Override
	public CompletableFuture<Patient.PagedResults> listPatientRequest(Patient.PageRequest input) {
		return this.listPatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listPatient
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	*/
	@Override
	public CompletableFuture<Patient.PagedResults> listPatientRequest(Patient.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.listPatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Doctor.PagedResults listDoctor(Doctor.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.listDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	 */
	@Override
	public void listDoctor(Doctor.PageRequest input) {
		br.com.senior.godev.godev2022desafio.impl.ListDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.listDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método listDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	 */
	@Override
	public CompletableFuture<Doctor.PagedResults> listDoctorRequest(Doctor.PageRequest input) {
		return this.listDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listDoctor
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	*/
	@Override
	public CompletableFuture<Doctor.PagedResults> listDoctorRequest(Doctor.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.listDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Prescription.PagedResults listPrescription(Prescription.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.listPrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	 */
	@Override
	public void listPrescription(Prescription.PageRequest input) {
		br.com.senior.godev.godev2022desafio.impl.ListPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.listPrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método listPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	 */
	@Override
	public CompletableFuture<Prescription.PagedResults> listPrescriptionRequest(Prescription.PageRequest input) {
		return this.listPrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listPrescription
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	*/
	@Override
	public CompletableFuture<Prescription.PagedResults> listPrescriptionRequest(Prescription.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.listPrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método listResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ResponsibleFamilyMember.PagedResults listResponsibleFamilyMember(ResponsibleFamilyMember.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.listResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método listResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void listResponsibleFamilyMember(ResponsibleFamilyMember.PageRequest input) {
		br.com.senior.godev.godev2022desafio.impl.ListResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.listResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método listResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public CompletableFuture<ResponsibleFamilyMember.PagedResults> listResponsibleFamilyMemberRequest(ResponsibleFamilyMember.PageRequest input) {
		return this.listResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método listResponsibleFamilyMember
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Override
	public CompletableFuture<ResponsibleFamilyMember.PagedResults> listResponsibleFamilyMemberRequest(ResponsibleFamilyMember.PageRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.ListResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.ListResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.listResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public GetDependenciesOutput getDependencies(long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetDependenciesImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDependencies(timeout);
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 */
	@Override
	public void getDependencies() {
		br.com.senior.godev.godev2022desafio.impl.GetDependenciesImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		impl.getDependencies();
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 */
	@Override
	public CompletableFuture<GetDependenciesOutput> getDependenciesRequest() {
		return this.getDependenciesRequest(0l);
	}
	
	/**
	 * Chamada assíncrona para o método getDependencies
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	*/
	@Override
	public CompletableFuture<GetDependenciesOutput> getDependenciesRequest(long timeout) {
		br.com.senior.godev.godev2022desafio.impl.GetDependenciesImpl impl = new br.com.senior.godev.godev2022desafio.impl.GetDependenciesImpl(messengerSupplier, userId, messageSupplier);
		return impl.getDependenciesRequest(timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createPatient
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Patient createPatient(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreatePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreatePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.createPatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createPatient
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	 */
	@Override
	public void createPatient(Patient input) {
		br.com.senior.godev.godev2022desafio.impl.CreatePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreatePatientImpl(messengerSupplier, userId, messageSupplier);
		impl.createPatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método createPatient
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	 */
	@Override
	public CompletableFuture<Patient> createPatientRequest(Patient input) {
		return this.createPatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createPatient
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	*/
	@Override
	public CompletableFuture<Patient> createPatientRequest(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreatePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreatePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.createPatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkPatient
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkPatientOutput createBulkPatient(CreateBulkPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkPatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPatient
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	 */
	@Override
	public void createBulkPatient(CreateBulkPatientInput input) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkPatientImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkPatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPatient
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	 */
	@Override
	public CompletableFuture<CreateBulkPatientOutput> createBulkPatientRequest(CreateBulkPatientInput input) {
		return this.createBulkPatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPatient
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	*/
	@Override
	public CompletableFuture<CreateBulkPatientOutput> createBulkPatientRequest(CreateBulkPatientInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkPatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkPatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkPatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergePatient
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Patient createMergePatient(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergePatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePatient
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	 */
	@Override
	public void createMergePatient(Patient input) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergePatientImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergePatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePatient
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	 */
	@Override
	public CompletableFuture<Patient> createMergePatientRequest(Patient input) {
		return this.createMergePatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePatient
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	*/
	@Override
	public CompletableFuture<Patient> createMergePatientRequest(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergePatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrievePatient
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Patient retrievePatient(Patient.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrievePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrievePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrievePatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePatient
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	 */
	@Override
	public void retrievePatient(Patient.GetRequest input) {
		br.com.senior.godev.godev2022desafio.impl.RetrievePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrievePatientImpl(messengerSupplier, userId, messageSupplier);
		impl.retrievePatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePatient
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	 */
	@Override
	public CompletableFuture<Patient> retrievePatientRequest(Patient.GetRequest input) {
		return this.retrievePatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePatient
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	*/
	@Override
	public CompletableFuture<Patient> retrievePatientRequest(Patient.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrievePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrievePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrievePatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updatePatient
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Patient updatePatient(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdatePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdatePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.updatePatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updatePatient
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	 */
	@Override
	public void updatePatient(Patient input) {
		br.com.senior.godev.godev2022desafio.impl.UpdatePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdatePatientImpl(messengerSupplier, userId, messageSupplier);
		impl.updatePatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método updatePatient
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	 */
	@Override
	public CompletableFuture<Patient> updatePatientRequest(Patient input) {
		return this.updatePatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updatePatient
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	*/
	@Override
	public CompletableFuture<Patient> updatePatientRequest(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdatePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdatePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.updatePatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergePatient
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Patient updateMergePatient(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergePatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePatient
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	 */
	@Override
	public void updateMergePatient(Patient input) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergePatientImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergePatient(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePatient
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	 */
	@Override
	public CompletableFuture<Patient> updateMergePatientRequest(Patient input) {
		return this.updateMergePatientRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePatient
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	*/
	@Override
	public CompletableFuture<Patient> updateMergePatientRequest(Patient input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergePatientImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergePatientRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deletePatient
	 * This is a public operation
	 * The 'delete' request primitive for the Patient entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deletePatient(Patient.Id input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.DeletePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeletePatientImpl(messengerSupplier, userId, messageSupplier);
		impl.deletePatient(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deletePatient
	 * This is a public operation
	 * The 'delete' request primitive for the Patient entity.
	 */
	@Override
	public void deletePatient(Patient.Id input) {
		br.com.senior.godev.godev2022desafio.impl.DeletePatientImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeletePatientImpl(messengerSupplier, userId, messageSupplier);
		impl.deletePatient(input);
	}
	
	
	/**
	 * Chamada síncrona para o método createDoctor
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Doctor createDoctor(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.createDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createDoctor
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	 */
	@Override
	public void createDoctor(Doctor input) {
		br.com.senior.godev.godev2022desafio.impl.CreateDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.createDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método createDoctor
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	 */
	@Override
	public CompletableFuture<Doctor> createDoctorRequest(Doctor input) {
		return this.createDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createDoctor
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	*/
	@Override
	public CompletableFuture<Doctor> createDoctorRequest(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.createDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkDoctor
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkDoctorOutput createBulkDoctor(CreateBulkDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkDoctor
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	 */
	@Override
	public void createBulkDoctor(CreateBulkDoctorInput input) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkDoctor
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	 */
	@Override
	public CompletableFuture<CreateBulkDoctorOutput> createBulkDoctorRequest(CreateBulkDoctorInput input) {
		return this.createBulkDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkDoctor
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	*/
	@Override
	public CompletableFuture<CreateBulkDoctorOutput> createBulkDoctorRequest(CreateBulkDoctorInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergeDoctor
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Doctor createMergeDoctor(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergeDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergeDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeDoctor
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	 */
	@Override
	public void createMergeDoctor(Doctor input) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergeDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergeDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeDoctor
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	 */
	@Override
	public CompletableFuture<Doctor> createMergeDoctorRequest(Doctor input) {
		return this.createMergeDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeDoctor
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	*/
	@Override
	public CompletableFuture<Doctor> createMergeDoctorRequest(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergeDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergeDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrieveDoctor
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Doctor retrieveDoctor(Doctor.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrieveDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrieveDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveDoctor
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	 */
	@Override
	public void retrieveDoctor(Doctor.GetRequest input) {
		br.com.senior.godev.godev2022desafio.impl.RetrieveDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrieveDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveDoctor
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	 */
	@Override
	public CompletableFuture<Doctor> retrieveDoctorRequest(Doctor.GetRequest input) {
		return this.retrieveDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveDoctor
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	*/
	@Override
	public CompletableFuture<Doctor> retrieveDoctorRequest(Doctor.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrieveDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrieveDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateDoctor
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Doctor updateDoctor(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateDoctor
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	 */
	@Override
	public void updateDoctor(Doctor input) {
		br.com.senior.godev.godev2022desafio.impl.UpdateDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.updateDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateDoctor
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	 */
	@Override
	public CompletableFuture<Doctor> updateDoctorRequest(Doctor input) {
		return this.updateDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateDoctor
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	*/
	@Override
	public CompletableFuture<Doctor> updateDoctorRequest(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergeDoctor
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Doctor updateMergeDoctor(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergeDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergeDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeDoctor
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	 */
	@Override
	public void updateMergeDoctor(Doctor input) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergeDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergeDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeDoctor(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeDoctor
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	 */
	@Override
	public CompletableFuture<Doctor> updateMergeDoctorRequest(Doctor input) {
		return this.updateMergeDoctorRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeDoctor
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	*/
	@Override
	public CompletableFuture<Doctor> updateMergeDoctorRequest(Doctor input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergeDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergeDoctorImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeDoctorRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deleteDoctor
	 * This is a public operation
	 * The 'delete' request primitive for the Doctor entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteDoctor(Doctor.Id input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.DeleteDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeleteDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteDoctor(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteDoctor
	 * This is a public operation
	 * The 'delete' request primitive for the Doctor entity.
	 */
	@Override
	public void deleteDoctor(Doctor.Id input) {
		br.com.senior.godev.godev2022desafio.impl.DeleteDoctorImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeleteDoctorImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteDoctor(input);
	}
	
	
	/**
	 * Chamada síncrona para o método createPrescription
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Prescription createPrescription(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreatePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreatePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.createPrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createPrescription
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	 */
	@Override
	public void createPrescription(Prescription input) {
		br.com.senior.godev.godev2022desafio.impl.CreatePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreatePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.createPrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método createPrescription
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	 */
	@Override
	public CompletableFuture<Prescription> createPrescriptionRequest(Prescription input) {
		return this.createPrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createPrescription
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	*/
	@Override
	public CompletableFuture<Prescription> createPrescriptionRequest(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreatePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreatePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.createPrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkPrescription
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkPrescriptionOutput createBulkPrescription(CreateBulkPrescriptionInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkPrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPrescription
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	 */
	@Override
	public void createBulkPrescription(CreateBulkPrescriptionInput input) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkPrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPrescription
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	 */
	@Override
	public CompletableFuture<CreateBulkPrescriptionOutput> createBulkPrescriptionRequest(CreateBulkPrescriptionInput input) {
		return this.createBulkPrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkPrescription
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	*/
	@Override
	public CompletableFuture<CreateBulkPrescriptionOutput> createBulkPrescriptionRequest(CreateBulkPrescriptionInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkPrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkPrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkPrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergePrescription
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Prescription createMergePrescription(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergePrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePrescription
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	 */
	@Override
	public void createMergePrescription(Prescription input) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergePrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePrescription
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	 */
	@Override
	public CompletableFuture<Prescription> createMergePrescriptionRequest(Prescription input) {
		return this.createMergePrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergePrescription
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	*/
	@Override
	public CompletableFuture<Prescription> createMergePrescriptionRequest(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergePrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrievePrescription
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Prescription retrievePrescription(Prescription.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrievePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrievePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrievePrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePrescription
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	 */
	@Override
	public void retrievePrescription(Prescription.GetRequest input) {
		br.com.senior.godev.godev2022desafio.impl.RetrievePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrievePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.retrievePrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePrescription
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	 */
	@Override
	public CompletableFuture<Prescription> retrievePrescriptionRequest(Prescription.GetRequest input) {
		return this.retrievePrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrievePrescription
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	*/
	@Override
	public CompletableFuture<Prescription> retrievePrescriptionRequest(Prescription.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrievePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrievePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrievePrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updatePrescription
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Prescription updatePrescription(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdatePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdatePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.updatePrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updatePrescription
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	 */
	@Override
	public void updatePrescription(Prescription input) {
		br.com.senior.godev.godev2022desafio.impl.UpdatePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdatePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.updatePrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método updatePrescription
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	 */
	@Override
	public CompletableFuture<Prescription> updatePrescriptionRequest(Prescription input) {
		return this.updatePrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updatePrescription
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	*/
	@Override
	public CompletableFuture<Prescription> updatePrescriptionRequest(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdatePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdatePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.updatePrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergePrescription
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public Prescription updateMergePrescription(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergePrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePrescription
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	 */
	@Override
	public void updateMergePrescription(Prescription input) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergePrescription(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePrescription
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	 */
	@Override
	public CompletableFuture<Prescription> updateMergePrescriptionRequest(Prescription input) {
		return this.updateMergePrescriptionRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergePrescription
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	*/
	@Override
	public CompletableFuture<Prescription> updateMergePrescriptionRequest(Prescription input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergePrescriptionRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deletePrescription
	 * This is a public operation
	 * The 'delete' request primitive for the Prescription entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deletePrescription(Prescription.Id input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.DeletePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeletePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.deletePrescription(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deletePrescription
	 * This is a public operation
	 * The 'delete' request primitive for the Prescription entity.
	 */
	@Override
	public void deletePrescription(Prescription.Id input) {
		br.com.senior.godev.godev2022desafio.impl.DeletePrescriptionImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeletePrescriptionImpl(messengerSupplier, userId, messageSupplier);
		impl.deletePrescription(input);
	}
	
	
	/**
	 * Chamada síncrona para o método createResponsibleFamilyMember
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ResponsibleFamilyMember createResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.createResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createResponsibleFamilyMember
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void createResponsibleFamilyMember(ResponsibleFamilyMember input) {
		br.com.senior.godev.godev2022desafio.impl.CreateResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.createResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método createResponsibleFamilyMember
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public CompletableFuture<ResponsibleFamilyMember> createResponsibleFamilyMemberRequest(ResponsibleFamilyMember input) {
		return this.createResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createResponsibleFamilyMember
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Override
	public CompletableFuture<ResponsibleFamilyMember> createResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.createResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createBulkResponsibleFamilyMember
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public CreateBulkResponsibleFamilyMemberOutput createBulkResponsibleFamilyMember(CreateBulkResponsibleFamilyMemberInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkResponsibleFamilyMember
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void createBulkResponsibleFamilyMember(CreateBulkResponsibleFamilyMemberInput input) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.createBulkResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkResponsibleFamilyMember
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public CompletableFuture<CreateBulkResponsibleFamilyMemberOutput> createBulkResponsibleFamilyMemberRequest(CreateBulkResponsibleFamilyMemberInput input) {
		return this.createBulkResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createBulkResponsibleFamilyMember
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Override
	public CompletableFuture<CreateBulkResponsibleFamilyMemberOutput> createBulkResponsibleFamilyMemberRequest(CreateBulkResponsibleFamilyMemberInput input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateBulkResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateBulkResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.createBulkResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método createMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ResponsibleFamilyMember createMergeResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergeResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergeResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void createMergeResponsibleFamilyMember(ResponsibleFamilyMember input) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergeResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergeResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.createMergeResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public CompletableFuture<ResponsibleFamilyMember> createMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input) {
		return this.createMergeResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método createMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Override
	public CompletableFuture<ResponsibleFamilyMember> createMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.CreateMergeResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.CreateMergeResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.createMergeResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método retrieveResponsibleFamilyMember
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ResponsibleFamilyMember retrieveResponsibleFamilyMember(ResponsibleFamilyMember.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrieveResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrieveResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveResponsibleFamilyMember
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void retrieveResponsibleFamilyMember(ResponsibleFamilyMember.GetRequest input) {
		br.com.senior.godev.godev2022desafio.impl.RetrieveResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrieveResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.retrieveResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveResponsibleFamilyMember
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public CompletableFuture<ResponsibleFamilyMember> retrieveResponsibleFamilyMemberRequest(ResponsibleFamilyMember.GetRequest input) {
		return this.retrieveResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método retrieveResponsibleFamilyMember
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Override
	public CompletableFuture<ResponsibleFamilyMember> retrieveResponsibleFamilyMemberRequest(ResponsibleFamilyMember.GetRequest input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.RetrieveResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.RetrieveResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.retrieveResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateResponsibleFamilyMember
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ResponsibleFamilyMember updateResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateResponsibleFamilyMember
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void updateResponsibleFamilyMember(ResponsibleFamilyMember input) {
		br.com.senior.godev.godev2022desafio.impl.UpdateResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.updateResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateResponsibleFamilyMember
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public CompletableFuture<ResponsibleFamilyMember> updateResponsibleFamilyMemberRequest(ResponsibleFamilyMember input) {
		return this.updateResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateResponsibleFamilyMember
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Override
	public CompletableFuture<ResponsibleFamilyMember> updateResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método updateMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public ResponsibleFamilyMember updateMergeResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergeResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergeResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void updateMergeResponsibleFamilyMember(ResponsibleFamilyMember input) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergeResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergeResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.updateMergeResponsibleFamilyMember(input);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public CompletableFuture<ResponsibleFamilyMember> updateMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input) {
		return this.updateMergeResponsibleFamilyMemberRequest(input, 0l);
	}
	
	/**
	 * Chamada assíncrona para o método updateMergeResponsibleFamilyMember
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	*/
	@Override
	public CompletableFuture<ResponsibleFamilyMember> updateMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.UpdateMergeResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.UpdateMergeResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		return impl.updateMergeResponsibleFamilyMemberRequest(input, timeout, TimeUnit.MILLISECONDS);
	}
	/**
	 * Chamada síncrona para o método deleteResponsibleFamilyMember
	 * This is a public operation
	 * The 'delete' request primitive for the ResponsibleFamilyMember entity.
	 * @throws Godev2022desafioMessageException quando um erro com payload for retornado pela mensageria
	 */
	@Override
	public void deleteResponsibleFamilyMember(ResponsibleFamilyMember.Id input, long timeout) {
		br.com.senior.godev.godev2022desafio.impl.DeleteResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeleteResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteResponsibleFamilyMember(input, timeout);
	}
	
	/**
	 * Chamada assíncrona para o método deleteResponsibleFamilyMember
	 * This is a public operation
	 * The 'delete' request primitive for the ResponsibleFamilyMember entity.
	 */
	@Override
	public void deleteResponsibleFamilyMember(ResponsibleFamilyMember.Id input) {
		br.com.senior.godev.godev2022desafio.impl.DeleteResponsibleFamilyMemberImpl impl = new br.com.senior.godev.godev2022desafio.impl.DeleteResponsibleFamilyMemberImpl(messengerSupplier, userId, messageSupplier);
		impl.deleteResponsibleFamilyMember(input);
	}
	
	

	
	private Message createMessage(ExportPrescriptionEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ServiceStartedPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ImportPrescriptionEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(PatientAdmittedPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ImportResponsibleFamilyMemberEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ExportResponsibleFamilyMemberEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ExportDoctorEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ImportDoctorEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ExportPatientEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(NotifyUserEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	
	private Message createMessage(ImportPatientEventPayload input, String requestName) {
		if (messageSupplier != null && messageSupplier.get() != null) {
			return messageSupplier.get().followUp( //
				userId.getTenant(), //
				Godev2022desafioConstants.DOMAIN, //
				Godev2022desafioConstants.SERVICE, //
				requestName, //
				DtoJsonConverter.toJSON(input));
		}
		return  new Message(userId.getTenant(), // 
			Godev2022desafioConstants.DOMAIN, // 
			Godev2022desafioConstants.SERVICE, //
			requestName, // 
			DtoJsonConverter.toJSON(input));
	}
	

	/**
	 * Chamada assíncrona para o método publishPatientAdmitted
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishPatientAdmitted( PatientAdmittedPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.PATIENT_ADMITTED);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishServiceStarted
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishServiceStarted( ServiceStartedPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.SERVICE_STARTED);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishNotifyUserEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishNotifyUserEvent( NotifyUserEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.NOTIFY_USER_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportPatientEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportPatientEvent( ImportPatientEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.IMPORT_PATIENT_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportPatientEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportPatientEvent( ExportPatientEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.EXPORT_PATIENT_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportDoctorEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportDoctorEvent( ImportDoctorEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.IMPORT_DOCTOR_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportDoctorEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportDoctorEvent( ExportDoctorEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.EXPORT_DOCTOR_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportPrescriptionEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportPrescriptionEvent( ImportPrescriptionEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.IMPORT_PRESCRIPTION_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportPrescriptionEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportPrescriptionEvent( ExportPrescriptionEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.EXPORT_PRESCRIPTION_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishImportResponsibleFamilyMemberEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishImportResponsibleFamilyMemberEvent( ImportResponsibleFamilyMemberEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.IMPORT_RESPONSIBLE_FAMILY_MEMBER_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	/**
	 * Chamada assíncrona para o método publishExportResponsibleFamilyMemberEvent
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	public void publishExportResponsibleFamilyMemberEvent( ExportResponsibleFamilyMemberEventPayload input ) {
		Message message = createMessage(input, Godev2022desafioConstants.Events.EXPORT_RESPONSIBLE_FAMILY_MEMBER_EVENT);
		try {
			addMessageHeaders(message);
			messengerSupplier.get().publish(message);
		} catch (Exception e) {
			throw new Godev2022desafioException("Erro ao enviar a mensagem", e);
		}
	}
	
	private void addMessageHeaders(Message message) {
		message.setUsername(userId.getUsername());
		if (userId.isTrusted()) {
			message.addHeader("trusted", true);
		}
	}
}
