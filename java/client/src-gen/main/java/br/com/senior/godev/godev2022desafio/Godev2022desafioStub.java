/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import java.util.concurrent.CompletableFuture;


/**
* 
*/
public interface Godev2022desafioStub {

	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	AlterStatusPatientOutput alterStatusPatient(AlterStatusPatientInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	 * Chamada assíncrona
	 */
	void alterStatusPatient(AlterStatusPatientInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<AlterStatusPatientOutput> alterStatusPatientRequest(AlterStatusPatientInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por alterar status do paciente para ativo
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<AlterStatusPatientOutput> alterStatusPatientRequest(AlterStatusPatientInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetDoctorForSpecialityOutput getDoctorForSpeciality(GetDoctorForSpecialityInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	 * Chamada assíncrona
	 */
	void getDoctorForSpeciality(GetDoctorForSpecialityInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetDoctorForSpecialityOutput> getDoctorForSpecialityRequest(GetDoctorForSpecialityInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter Médicos por especialidade
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetDoctorForSpecialityOutput> getDoctorForSpecialityRequest(GetDoctorForSpecialityInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetPrescriptionsForDoctorOutput getPrescriptionsForDoctor(GetPrescriptionsForDoctorInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	 * Chamada assíncrona
	 */
	void getPrescriptionsForDoctor(GetPrescriptionsForDoctorInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetPrescriptionsForDoctorOutput> getPrescriptionsForDoctorRequest(GetPrescriptionsForDoctorInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Responsável por obter prescrições por nome do médico
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetPrescriptionsForDoctorOutput> getPrescriptionsForDoctorRequest(GetPrescriptionsForDoctorInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetMetadataOutput getMetadata(GetMetadataInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona
	 */
	void getMetadata(GetMetadataInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetMetadataOutput> getMetadataRequest(GetMetadataInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportPatientOutput importPatient(ImportPatientInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importPatient(ImportPatientInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportPatientOutput> importPatientRequest(ImportPatientInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportPatientOutput> importPatientRequest(ImportPatientInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportPatientOutput exportPatient(ExportPatientInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportPatient(ExportPatientInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportPatientOutput> exportPatientRequest(ExportPatientInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportPatientOutput> exportPatientRequest(ExportPatientInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportDoctorOutput importDoctor(ImportDoctorInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importDoctor(ImportDoctorInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportDoctorOutput> importDoctorRequest(ImportDoctorInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportDoctorOutput> importDoctorRequest(ImportDoctorInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportDoctorOutput exportDoctor(ExportDoctorInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportDoctor(ExportDoctorInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportDoctorOutput> exportDoctorRequest(ExportDoctorInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportDoctorOutput> exportDoctorRequest(ExportDoctorInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportPrescriptionOutput importPrescription(ImportPrescriptionInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importPrescription(ImportPrescriptionInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportPrescriptionOutput> importPrescriptionRequest(ImportPrescriptionInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportPrescriptionOutput> importPrescriptionRequest(ImportPrescriptionInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportPrescriptionOutput exportPrescription(ExportPrescriptionInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportPrescription(ExportPrescriptionInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportPrescriptionOutput> exportPrescriptionRequest(ExportPrescriptionInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportPrescriptionOutput> exportPrescriptionRequest(ExportPrescriptionInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ImportResponsibleFamilyMemberOutput importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportResponsibleFamilyMemberOutput> importResponsibleFamilyMemberRequest(ImportResponsibleFamilyMemberInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ImportResponsibleFamilyMemberOutput> importResponsibleFamilyMemberRequest(ImportResponsibleFamilyMemberInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ExportResponsibleFamilyMemberOutput exportResponsibleFamilyMember(ExportResponsibleFamilyMemberInput input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona
	 */
	void exportResponsibleFamilyMember(ExportResponsibleFamilyMemberInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportResponsibleFamilyMemberOutput> exportResponsibleFamilyMemberRequest(ExportResponsibleFamilyMemberInput input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * 
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ExportResponsibleFamilyMemberOutput> exportResponsibleFamilyMemberRequest(ExportResponsibleFamilyMemberInput input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Patient.PagedResults listPatient(Patient.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void listPatient(Patient.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient.PagedResults> listPatientRequest(Patient.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient.PagedResults> listPatientRequest(Patient.PageRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Doctor.PagedResults listDoctor(Doctor.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void listDoctor(Doctor.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor.PagedResults> listDoctorRequest(Doctor.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor.PagedResults> listDoctorRequest(Doctor.PageRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Prescription.PagedResults listPrescription(Prescription.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void listPrescription(Prescription.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription.PagedResults> listPrescriptionRequest(Prescription.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription.PagedResults> listPrescriptionRequest(Prescription.PageRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ResponsibleFamilyMember.PagedResults listResponsibleFamilyMember(ResponsibleFamilyMember.PageRequest input, long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void listResponsibleFamilyMember(ResponsibleFamilyMember.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember.PagedResults> listResponsibleFamilyMemberRequest(ResponsibleFamilyMember.PageRequest input);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember.PagedResults> listResponsibleFamilyMemberRequest(ResponsibleFamilyMember.PageRequest input, long timeout);
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	GetDependenciesOutput getDependencies(long timeout);
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona
	 */
	void getDependencies();
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetDependenciesOutput> getDependenciesRequest();
	
	/**
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 * Returns a list with all dependencies from this service, along with their respective versions
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<GetDependenciesOutput> getDependenciesRequest(long timeout);
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Patient createPatient(Patient input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void createPatient(Patient input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> createPatientRequest(Patient input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> createPatientRequest(Patient input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkPatientOutput createBulkPatient(CreateBulkPatientInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void createBulkPatient(CreateBulkPatientInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkPatientOutput> createBulkPatientRequest(CreateBulkPatientInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkPatientOutput> createBulkPatientRequest(CreateBulkPatientInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Patient createMergePatient(Patient input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void createMergePatient(Patient input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> createMergePatientRequest(Patient input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> createMergePatientRequest(Patient input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Patient retrievePatient(Patient.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void retrievePatient(Patient.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> retrievePatientRequest(Patient.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> retrievePatientRequest(Patient.GetRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Patient updatePatient(Patient input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void updatePatient(Patient input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> updatePatientRequest(Patient input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> updatePatientRequest(Patient input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Patient updateMergePatient(Patient input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void updateMergePatient(Patient input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> updateMergePatientRequest(Patient input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Patient entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Patient> updateMergePatientRequest(Patient input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Patient entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deletePatient(Patient.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Patient entity.
	 * Chamada assíncrona
	 */
	void deletePatient(Patient.Id input);
	
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Doctor createDoctor(Doctor input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void createDoctor(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> createDoctorRequest(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> createDoctorRequest(Doctor input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkDoctorOutput createBulkDoctor(CreateBulkDoctorInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void createBulkDoctor(CreateBulkDoctorInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkDoctorOutput> createBulkDoctorRequest(CreateBulkDoctorInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkDoctorOutput> createBulkDoctorRequest(CreateBulkDoctorInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Doctor createMergeDoctor(Doctor input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void createMergeDoctor(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> createMergeDoctorRequest(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> createMergeDoctorRequest(Doctor input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Doctor retrieveDoctor(Doctor.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void retrieveDoctor(Doctor.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> retrieveDoctorRequest(Doctor.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> retrieveDoctorRequest(Doctor.GetRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Doctor updateDoctor(Doctor input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void updateDoctor(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> updateDoctorRequest(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> updateDoctorRequest(Doctor input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Doctor updateMergeDoctor(Doctor input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void updateMergeDoctor(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> updateMergeDoctorRequest(Doctor input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Doctor entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Doctor> updateMergeDoctorRequest(Doctor input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Doctor entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteDoctor(Doctor.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Doctor entity.
	 * Chamada assíncrona
	 */
	void deleteDoctor(Doctor.Id input);
	
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Prescription createPrescription(Prescription input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void createPrescription(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> createPrescriptionRequest(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> createPrescriptionRequest(Prescription input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkPrescriptionOutput createBulkPrescription(CreateBulkPrescriptionInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void createBulkPrescription(CreateBulkPrescriptionInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkPrescriptionOutput> createBulkPrescriptionRequest(CreateBulkPrescriptionInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkPrescriptionOutput> createBulkPrescriptionRequest(CreateBulkPrescriptionInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Prescription createMergePrescription(Prescription input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void createMergePrescription(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> createMergePrescriptionRequest(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> createMergePrescriptionRequest(Prescription input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Prescription retrievePrescription(Prescription.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void retrievePrescription(Prescription.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> retrievePrescriptionRequest(Prescription.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> retrievePrescriptionRequest(Prescription.GetRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Prescription updatePrescription(Prescription input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void updatePrescription(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> updatePrescriptionRequest(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> updatePrescriptionRequest(Prescription input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	Prescription updateMergePrescription(Prescription input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void updateMergePrescription(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> updateMergePrescriptionRequest(Prescription input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the Prescription entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<Prescription> updateMergePrescriptionRequest(Prescription input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Prescription entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deletePrescription(Prescription.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the Prescription entity.
	 * Chamada assíncrona
	 */
	void deletePrescription(Prescription.Id input);
	
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ResponsibleFamilyMember createResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void createResponsibleFamilyMember(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> createResponsibleFamilyMemberRequest(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> createResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout);
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	CreateBulkResponsibleFamilyMemberOutput createBulkResponsibleFamilyMember(CreateBulkResponsibleFamilyMemberInput input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void createBulkResponsibleFamilyMember(CreateBulkResponsibleFamilyMemberInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkResponsibleFamilyMemberOutput> createBulkResponsibleFamilyMemberRequest(CreateBulkResponsibleFamilyMemberInput input);
	
	/**
	 * This is a public operation
	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<CreateBulkResponsibleFamilyMemberOutput> createBulkResponsibleFamilyMemberRequest(CreateBulkResponsibleFamilyMemberInput input, long timeout);
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ResponsibleFamilyMember createMergeResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void createMergeResponsibleFamilyMember(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> createMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> createMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout);
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ResponsibleFamilyMember retrieveResponsibleFamilyMember(ResponsibleFamilyMember.GetRequest input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void retrieveResponsibleFamilyMember(ResponsibleFamilyMember.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> retrieveResponsibleFamilyMemberRequest(ResponsibleFamilyMember.GetRequest input);
	
	/**
	 * This is a public operation
	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> retrieveResponsibleFamilyMemberRequest(ResponsibleFamilyMember.GetRequest input, long timeout);
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ResponsibleFamilyMember updateResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void updateResponsibleFamilyMember(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> updateResponsibleFamilyMemberRequest(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> updateResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout);
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	ResponsibleFamilyMember updateMergeResponsibleFamilyMember(ResponsibleFamilyMember input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void updateMergeResponsibleFamilyMember(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> updateMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input);
	
	/**
	 * This is a public operation
	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona utilizando request
	 */
	CompletableFuture<ResponsibleFamilyMember> updateMergeResponsibleFamilyMemberRequest(ResponsibleFamilyMember input, long timeout);
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada síncrona, o valor de timeout deve ser informado em ms 
	 */
	void deleteResponsibleFamilyMember(ResponsibleFamilyMember.Id input, long timeout);
	
	/**
	 * This is a public operation
	 * The 'delete' request primitive for the ResponsibleFamilyMember entity.
	 * Chamada assíncrona
	 */
	void deleteResponsibleFamilyMember(ResponsibleFamilyMember.Id input);
	
	


	/**
	 * Chamada assíncrona para o método publishPatientAdmitted 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishPatientAdmitted( PatientAdmittedPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishServiceStarted 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishServiceStarted( ServiceStartedPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishNotifyUserEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishNotifyUserEvent( NotifyUserEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportPatientEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportPatientEvent( ImportPatientEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportPatientEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportPatientEvent( ExportPatientEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportDoctorEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportDoctorEvent( ImportDoctorEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportDoctorEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportDoctorEvent( ExportDoctorEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportPrescriptionEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportPrescriptionEvent( ImportPrescriptionEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportPrescriptionEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportPrescriptionEvent( ExportPrescriptionEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishImportResponsibleFamilyMemberEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishImportResponsibleFamilyMemberEvent( ImportResponsibleFamilyMemberEventPayload input );
			
	
	/**
	 * Chamada assíncrona para o método publishExportResponsibleFamilyMemberEvent 
	 * Warning: this operation is PRIVATE and may have its behavior changed at any time without notice
	 */
	void publishExportResponsibleFamilyMemberEvent( ExportResponsibleFamilyMemberEventPayload input );
			
	

}
