/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

public interface Godev2022desafioConstants {
    String DOMAIN = "godev";
    String SERVICE = "godev2022desafio";
    
    interface Commands {
    	/**
    	 * Responsável por alterar status do paciente para ativo
    	 * @see AlterStatusPatientInput the request payload
    	 */
    	String ALTER_STATUS_PATIENT = "alterStatusPatient";
    	/**
    	 * The success response primitive for alterStatusPatient.
    	 *
    	 * @see #ALTER_STATUS_PATIENT the request primitive
    	 * @see AlterStatusPatientOutput the response payload
    	 */
    	String ALTER_STATUS_PATIENT_RESPONSE = "alterStatusPatientResponse";
    	/**
    	 * An error response primitive for alterStatusPatient.
    	 *
    	 * @see #ALTER_STATUS_PATIENT the request primitive
    	 */
    	String ALTER_STATUS_PATIENT_ERROR = "alterStatusPatientError";
    	/**
    	 * Responsável por obter Médicos por especialidade
    	 * @see GetDoctorForSpecialityInput the request payload
    	 */
    	String GET_DOCTOR_FOR_SPECIALITY = "getDoctorForSpeciality";
    	/**
    	 * The success response primitive for getDoctorForSpeciality.
    	 *
    	 * @see #GET_DOCTOR_FOR_SPECIALITY the request primitive
    	 * @see GetDoctorForSpecialityOutput the response payload
    	 */
    	String GET_DOCTOR_FOR_SPECIALITY_RESPONSE = "getDoctorForSpecialityResponse";
    	/**
    	 * An error response primitive for getDoctorForSpeciality.
    	 *
    	 * @see #GET_DOCTOR_FOR_SPECIALITY the request primitive
    	 */
    	String GET_DOCTOR_FOR_SPECIALITY_ERROR = "getDoctorForSpecialityError";
    	/**
    	 * Responsável por obter prescrições por nome do médico
    	 * @see GetPrescriptionsForDoctorInput the request payload
    	 */
    	String GET_PRESCRIPTIONS_FOR_DOCTOR = "getPrescriptionsForDoctor";
    	/**
    	 * The success response primitive for getPrescriptionsForDoctor.
    	 *
    	 * @see #GET_PRESCRIPTIONS_FOR_DOCTOR the request primitive
    	 * @see GetPrescriptionsForDoctorOutput the response payload
    	 */
    	String GET_PRESCRIPTIONS_FOR_DOCTOR_RESPONSE = "getPrescriptionsForDoctorResponse";
    	/**
    	 * An error response primitive for getPrescriptionsForDoctor.
    	 *
    	 * @see #GET_PRESCRIPTIONS_FOR_DOCTOR the request primitive
    	 */
    	String GET_PRESCRIPTIONS_FOR_DOCTOR_ERROR = "getPrescriptionsForDoctorError";
    	/**
    	 * Default 'getMetadata' query. Every service must handle this command and return metadata in the format requested.
    	 * @see GetMetadataInput the request payload
    	 */
    	String GET_METADATA = "getMetadata";
    	/**
    	 * The success response primitive for getMetadata.
    	 *
    	 * @see #GET_METADATA the request primitive
    	 * @see GetMetadataOutput the response payload
    	 */
    	String GET_METADATA_RESPONSE = "getMetadataResponse";
    	/**
    	 * An error response primitive for getMetadata.
    	 *
    	 * @see #GET_METADATA the request primitive
    	 */
    	String GET_METADATA_ERROR = "getMetadataError";
    	String ODATA = "odata";
    	/**
    	 * The success response primitive for odata.
    	 *
    	 * @see #ODATA the request primitive
    	 */
    	String ODATA_RESPONSE = "odataResponse";
    	/**
    	 * An error response primitive for odata.
    	 *
    	 * @see #ODATA the request primitive
    	 */
    	String ODATA_ERROR = "odataError";
    	/**
    	 * @see ImportPatientInput the request payload
    	 */
    	String IMPORT_PATIENT = "importPatient";
    	/**
    	 * The success response primitive for importPatient.
    	 *
    	 * @see #IMPORT_PATIENT the request primitive
    	 * @see ImportPatientOutput the response payload
    	 */
    	String IMPORT_PATIENT_RESPONSE = "importPatientResponse";
    	/**
    	 * An error response primitive for importPatient.
    	 *
    	 * @see #IMPORT_PATIENT the request primitive
    	 */
    	String IMPORT_PATIENT_ERROR = "importPatientError";
    	/**
    	 * @see ExportPatientInput the request payload
    	 */
    	String EXPORT_PATIENT = "exportPatient";
    	/**
    	 * The success response primitive for exportPatient.
    	 *
    	 * @see #EXPORT_PATIENT the request primitive
    	 * @see ExportPatientOutput the response payload
    	 */
    	String EXPORT_PATIENT_RESPONSE = "exportPatientResponse";
    	/**
    	 * An error response primitive for exportPatient.
    	 *
    	 * @see #EXPORT_PATIENT the request primitive
    	 */
    	String EXPORT_PATIENT_ERROR = "exportPatientError";
    	/**
    	 * @see ImportDoctorInput the request payload
    	 */
    	String IMPORT_DOCTOR = "importDoctor";
    	/**
    	 * The success response primitive for importDoctor.
    	 *
    	 * @see #IMPORT_DOCTOR the request primitive
    	 * @see ImportDoctorOutput the response payload
    	 */
    	String IMPORT_DOCTOR_RESPONSE = "importDoctorResponse";
    	/**
    	 * An error response primitive for importDoctor.
    	 *
    	 * @see #IMPORT_DOCTOR the request primitive
    	 */
    	String IMPORT_DOCTOR_ERROR = "importDoctorError";
    	/**
    	 * @see ExportDoctorInput the request payload
    	 */
    	String EXPORT_DOCTOR = "exportDoctor";
    	/**
    	 * The success response primitive for exportDoctor.
    	 *
    	 * @see #EXPORT_DOCTOR the request primitive
    	 * @see ExportDoctorOutput the response payload
    	 */
    	String EXPORT_DOCTOR_RESPONSE = "exportDoctorResponse";
    	/**
    	 * An error response primitive for exportDoctor.
    	 *
    	 * @see #EXPORT_DOCTOR the request primitive
    	 */
    	String EXPORT_DOCTOR_ERROR = "exportDoctorError";
    	/**
    	 * @see ImportPrescriptionInput the request payload
    	 */
    	String IMPORT_PRESCRIPTION = "importPrescription";
    	/**
    	 * The success response primitive for importPrescription.
    	 *
    	 * @see #IMPORT_PRESCRIPTION the request primitive
    	 * @see ImportPrescriptionOutput the response payload
    	 */
    	String IMPORT_PRESCRIPTION_RESPONSE = "importPrescriptionResponse";
    	/**
    	 * An error response primitive for importPrescription.
    	 *
    	 * @see #IMPORT_PRESCRIPTION the request primitive
    	 */
    	String IMPORT_PRESCRIPTION_ERROR = "importPrescriptionError";
    	/**
    	 * @see ExportPrescriptionInput the request payload
    	 */
    	String EXPORT_PRESCRIPTION = "exportPrescription";
    	/**
    	 * The success response primitive for exportPrescription.
    	 *
    	 * @see #EXPORT_PRESCRIPTION the request primitive
    	 * @see ExportPrescriptionOutput the response payload
    	 */
    	String EXPORT_PRESCRIPTION_RESPONSE = "exportPrescriptionResponse";
    	/**
    	 * An error response primitive for exportPrescription.
    	 *
    	 * @see #EXPORT_PRESCRIPTION the request primitive
    	 */
    	String EXPORT_PRESCRIPTION_ERROR = "exportPrescriptionError";
    	/**
    	 * @see ImportResponsibleFamilyMemberInput the request payload
    	 */
    	String IMPORT_RESPONSIBLE_FAMILY_MEMBER = "importResponsibleFamilyMember";
    	/**
    	 * The success response primitive for importResponsibleFamilyMember.
    	 *
    	 * @see #IMPORT_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 * @see ImportResponsibleFamilyMemberOutput the response payload
    	 */
    	String IMPORT_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "importResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for importResponsibleFamilyMember.
    	 *
    	 * @see #IMPORT_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String IMPORT_RESPONSIBLE_FAMILY_MEMBER_ERROR = "importResponsibleFamilyMemberError";
    	/**
    	 * @see ExportResponsibleFamilyMemberInput the request payload
    	 */
    	String EXPORT_RESPONSIBLE_FAMILY_MEMBER = "exportResponsibleFamilyMember";
    	/**
    	 * The success response primitive for exportResponsibleFamilyMember.
    	 *
    	 * @see #EXPORT_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 * @see ExportResponsibleFamilyMemberOutput the response payload
    	 */
    	String EXPORT_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "exportResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for exportResponsibleFamilyMember.
    	 *
    	 * @see #EXPORT_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String EXPORT_RESPONSIBLE_FAMILY_MEMBER_ERROR = "exportResponsibleFamilyMemberError";
    	/**
    	 * The 'list' request primitive for the Patient entity.
    	 * @see patient.pageRequest the request payload
    	 */
    	String LIST_PATIENT = "listPatient";
    	/**
    	 * The success response primitive for listPatient.
    	 *
    	 * @see #LIST_PATIENT the request primitive
    	 * @see Patient.PagedResults the response payload
    	 */
    	String LIST_PATIENT_RESPONSE = "listPatientResponse";
    	/**
    	 * An error response primitive for listPatient.
    	 *
    	 * @see #LIST_PATIENT the request primitive
    	 */
    	String LIST_PATIENT_ERROR = "listPatientError";
    	/**
    	 * The 'list' request primitive for the Doctor entity.
    	 * @see doctor.pageRequest the request payload
    	 */
    	String LIST_DOCTOR = "listDoctor";
    	/**
    	 * The success response primitive for listDoctor.
    	 *
    	 * @see #LIST_DOCTOR the request primitive
    	 * @see Doctor.PagedResults the response payload
    	 */
    	String LIST_DOCTOR_RESPONSE = "listDoctorResponse";
    	/**
    	 * An error response primitive for listDoctor.
    	 *
    	 * @see #LIST_DOCTOR the request primitive
    	 */
    	String LIST_DOCTOR_ERROR = "listDoctorError";
    	/**
    	 * The 'list' request primitive for the Prescription entity.
    	 * @see prescription.pageRequest the request payload
    	 */
    	String LIST_PRESCRIPTION = "listPrescription";
    	/**
    	 * The success response primitive for listPrescription.
    	 *
    	 * @see #LIST_PRESCRIPTION the request primitive
    	 * @see Prescription.PagedResults the response payload
    	 */
    	String LIST_PRESCRIPTION_RESPONSE = "listPrescriptionResponse";
    	/**
    	 * An error response primitive for listPrescription.
    	 *
    	 * @see #LIST_PRESCRIPTION the request primitive
    	 */
    	String LIST_PRESCRIPTION_ERROR = "listPrescriptionError";
    	/**
    	 * The 'list' request primitive for the ResponsibleFamilyMember entity.
    	 * @see responsibleFamilyMember.pageRequest the request payload
    	 */
    	String LIST_RESPONSIBLE_FAMILY_MEMBER = "listResponsibleFamilyMember";
    	/**
    	 * The success response primitive for listResponsibleFamilyMember.
    	 *
    	 * @see #LIST_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 * @see ResponsibleFamilyMember.PagedResults the response payload
    	 */
    	String LIST_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "listResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for listResponsibleFamilyMember.
    	 *
    	 * @see #LIST_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String LIST_RESPONSIBLE_FAMILY_MEMBER_ERROR = "listResponsibleFamilyMemberError";
    	/**
    	 * Returns a list with all dependencies from this service, along with their respective versions
    	 */
    	String GET_DEPENDENCIES = "getDependencies";
    	/**
    	 * The success response primitive for getDependencies.
    	 *
    	 * @see #GET_DEPENDENCIES the request primitive
    	 * @see GetDependenciesOutput the response payload
    	 */
    	String GET_DEPENDENCIES_RESPONSE = "getDependenciesResponse";
    	/**
    	 * An error response primitive for getDependencies.
    	 *
    	 * @see #GET_DEPENDENCIES the request primitive
    	 */
    	String GET_DEPENDENCIES_ERROR = "getDependenciesError";
    	/**
    	 * The 'create' request primitive for the Patient entity.
    	 * @see Patient the request payload
    	 */
    	String CREATE_PATIENT = "createPatient";
    	/**
    	 * The success response primitive for createPatient.
    	 *
    	 * @see #CREATE_PATIENT the request primitive
    	 */
    	String CREATE_PATIENT_RESPONSE = "createPatientResponse";
    	/**
    	 * An error response primitive for createPatient.
    	 *
    	 * @see #CREATE_PATIENT the request primitive
    	 */
    	String CREATE_PATIENT_ERROR = "createPatientError";
    	/**
    	 * The 'createBulk' request primitive for the Patient entity.
    	 * @see CreateBulkPatientInput the request payload
    	 */
    	String CREATE_BULK_PATIENT = "createBulkPatient";
    	/**
    	 * The success response primitive for createBulkPatient.
    	 *
    	 * @see #CREATE_BULK_PATIENT the request primitive
    	 * @see CreateBulkPatientOutput the response payload
    	 */
    	String CREATE_BULK_PATIENT_RESPONSE = "createBulkPatientResponse";
    	/**
    	 * An error response primitive for createBulkPatient.
    	 *
    	 * @see #CREATE_BULK_PATIENT the request primitive
    	 */
    	String CREATE_BULK_PATIENT_ERROR = "createBulkPatientError";
    	/**
    	 * The 'createMerge' request primitive for the Patient entity.
    	 * @see Patient the request payload
    	 */
    	String CREATE_MERGE_PATIENT = "createMergePatient";
    	/**
    	 * The success response primitive for createMergePatient.
    	 *
    	 * @see #CREATE_MERGE_PATIENT the request primitive
    	 */
    	String CREATE_MERGE_PATIENT_RESPONSE = "createMergePatientResponse";
    	/**
    	 * An error response primitive for createMergePatient.
    	 *
    	 * @see #CREATE_MERGE_PATIENT the request primitive
    	 */
    	String CREATE_MERGE_PATIENT_ERROR = "createMergePatientError";
    	/**
    	 * The 'retrieve' request primitive for the Patient entity.
    	 * @see Patient.GetRequest the request payload
    	 */
    	String RETRIEVE_PATIENT = "retrievePatient";
    	/**
    	 * The success response primitive for retrievePatient.
    	 *
    	 * @see #RETRIEVE_PATIENT the request primitive
    	 */
    	String RETRIEVE_PATIENT_RESPONSE = "retrievePatientResponse";
    	/**
    	 * An error response primitive for retrievePatient.
    	 *
    	 * @see #RETRIEVE_PATIENT the request primitive
    	 */
    	String RETRIEVE_PATIENT_ERROR = "retrievePatientError";
    	/**
    	 * The 'update' request primitive for the Patient entity.
    	 * @see Patient the request payload
    	 */
    	String UPDATE_PATIENT = "updatePatient";
    	/**
    	 * The success response primitive for updatePatient.
    	 *
    	 * @see #UPDATE_PATIENT the request primitive
    	 */
    	String UPDATE_PATIENT_RESPONSE = "updatePatientResponse";
    	/**
    	 * An error response primitive for updatePatient.
    	 *
    	 * @see #UPDATE_PATIENT the request primitive
    	 */
    	String UPDATE_PATIENT_ERROR = "updatePatientError";
    	/**
    	 * The 'updateMerge' request primitive for the Patient entity.
    	 * @see Patient the request payload
    	 */
    	String UPDATE_MERGE_PATIENT = "updateMergePatient";
    	/**
    	 * The success response primitive for updateMergePatient.
    	 *
    	 * @see #UPDATE_MERGE_PATIENT the request primitive
    	 */
    	String UPDATE_MERGE_PATIENT_RESPONSE = "updateMergePatientResponse";
    	/**
    	 * An error response primitive for updateMergePatient.
    	 *
    	 * @see #UPDATE_MERGE_PATIENT the request primitive
    	 */
    	String UPDATE_MERGE_PATIENT_ERROR = "updateMergePatientError";
    	/**
    	 * The 'delete' request primitive for the Patient entity.
    	 * @see Patient.Id the request payload
    	 */
    	String DELETE_PATIENT = "deletePatient";
    	/**
    	 * The success response primitive for deletePatient.
    	 *
    	 * @see #DELETE_PATIENT the request primitive
    	 */
    	String DELETE_PATIENT_RESPONSE = "deletePatientResponse";
    	/**
    	 * An error response primitive for deletePatient.
    	 *
    	 * @see #DELETE_PATIENT the request primitive
    	 */
    	String DELETE_PATIENT_ERROR = "deletePatientError";
    	/**
    	 * The 'create' request primitive for the Doctor entity.
    	 * @see Doctor the request payload
    	 */
    	String CREATE_DOCTOR = "createDoctor";
    	/**
    	 * The success response primitive for createDoctor.
    	 *
    	 * @see #CREATE_DOCTOR the request primitive
    	 */
    	String CREATE_DOCTOR_RESPONSE = "createDoctorResponse";
    	/**
    	 * An error response primitive for createDoctor.
    	 *
    	 * @see #CREATE_DOCTOR the request primitive
    	 */
    	String CREATE_DOCTOR_ERROR = "createDoctorError";
    	/**
    	 * The 'createBulk' request primitive for the Doctor entity.
    	 * @see CreateBulkDoctorInput the request payload
    	 */
    	String CREATE_BULK_DOCTOR = "createBulkDoctor";
    	/**
    	 * The success response primitive for createBulkDoctor.
    	 *
    	 * @see #CREATE_BULK_DOCTOR the request primitive
    	 * @see CreateBulkDoctorOutput the response payload
    	 */
    	String CREATE_BULK_DOCTOR_RESPONSE = "createBulkDoctorResponse";
    	/**
    	 * An error response primitive for createBulkDoctor.
    	 *
    	 * @see #CREATE_BULK_DOCTOR the request primitive
    	 */
    	String CREATE_BULK_DOCTOR_ERROR = "createBulkDoctorError";
    	/**
    	 * The 'createMerge' request primitive for the Doctor entity.
    	 * @see Doctor the request payload
    	 */
    	String CREATE_MERGE_DOCTOR = "createMergeDoctor";
    	/**
    	 * The success response primitive for createMergeDoctor.
    	 *
    	 * @see #CREATE_MERGE_DOCTOR the request primitive
    	 */
    	String CREATE_MERGE_DOCTOR_RESPONSE = "createMergeDoctorResponse";
    	/**
    	 * An error response primitive for createMergeDoctor.
    	 *
    	 * @see #CREATE_MERGE_DOCTOR the request primitive
    	 */
    	String CREATE_MERGE_DOCTOR_ERROR = "createMergeDoctorError";
    	/**
    	 * The 'retrieve' request primitive for the Doctor entity.
    	 * @see Doctor.GetRequest the request payload
    	 */
    	String RETRIEVE_DOCTOR = "retrieveDoctor";
    	/**
    	 * The success response primitive for retrieveDoctor.
    	 *
    	 * @see #RETRIEVE_DOCTOR the request primitive
    	 */
    	String RETRIEVE_DOCTOR_RESPONSE = "retrieveDoctorResponse";
    	/**
    	 * An error response primitive for retrieveDoctor.
    	 *
    	 * @see #RETRIEVE_DOCTOR the request primitive
    	 */
    	String RETRIEVE_DOCTOR_ERROR = "retrieveDoctorError";
    	/**
    	 * The 'update' request primitive for the Doctor entity.
    	 * @see Doctor the request payload
    	 */
    	String UPDATE_DOCTOR = "updateDoctor";
    	/**
    	 * The success response primitive for updateDoctor.
    	 *
    	 * @see #UPDATE_DOCTOR the request primitive
    	 */
    	String UPDATE_DOCTOR_RESPONSE = "updateDoctorResponse";
    	/**
    	 * An error response primitive for updateDoctor.
    	 *
    	 * @see #UPDATE_DOCTOR the request primitive
    	 */
    	String UPDATE_DOCTOR_ERROR = "updateDoctorError";
    	/**
    	 * The 'updateMerge' request primitive for the Doctor entity.
    	 * @see Doctor the request payload
    	 */
    	String UPDATE_MERGE_DOCTOR = "updateMergeDoctor";
    	/**
    	 * The success response primitive for updateMergeDoctor.
    	 *
    	 * @see #UPDATE_MERGE_DOCTOR the request primitive
    	 */
    	String UPDATE_MERGE_DOCTOR_RESPONSE = "updateMergeDoctorResponse";
    	/**
    	 * An error response primitive for updateMergeDoctor.
    	 *
    	 * @see #UPDATE_MERGE_DOCTOR the request primitive
    	 */
    	String UPDATE_MERGE_DOCTOR_ERROR = "updateMergeDoctorError";
    	/**
    	 * The 'delete' request primitive for the Doctor entity.
    	 * @see Doctor.Id the request payload
    	 */
    	String DELETE_DOCTOR = "deleteDoctor";
    	/**
    	 * The success response primitive for deleteDoctor.
    	 *
    	 * @see #DELETE_DOCTOR the request primitive
    	 */
    	String DELETE_DOCTOR_RESPONSE = "deleteDoctorResponse";
    	/**
    	 * An error response primitive for deleteDoctor.
    	 *
    	 * @see #DELETE_DOCTOR the request primitive
    	 */
    	String DELETE_DOCTOR_ERROR = "deleteDoctorError";
    	/**
    	 * The 'create' request primitive for the Prescription entity.
    	 * @see Prescription the request payload
    	 */
    	String CREATE_PRESCRIPTION = "createPrescription";
    	/**
    	 * The success response primitive for createPrescription.
    	 *
    	 * @see #CREATE_PRESCRIPTION the request primitive
    	 */
    	String CREATE_PRESCRIPTION_RESPONSE = "createPrescriptionResponse";
    	/**
    	 * An error response primitive for createPrescription.
    	 *
    	 * @see #CREATE_PRESCRIPTION the request primitive
    	 */
    	String CREATE_PRESCRIPTION_ERROR = "createPrescriptionError";
    	/**
    	 * The 'createBulk' request primitive for the Prescription entity.
    	 * @see CreateBulkPrescriptionInput the request payload
    	 */
    	String CREATE_BULK_PRESCRIPTION = "createBulkPrescription";
    	/**
    	 * The success response primitive for createBulkPrescription.
    	 *
    	 * @see #CREATE_BULK_PRESCRIPTION the request primitive
    	 * @see CreateBulkPrescriptionOutput the response payload
    	 */
    	String CREATE_BULK_PRESCRIPTION_RESPONSE = "createBulkPrescriptionResponse";
    	/**
    	 * An error response primitive for createBulkPrescription.
    	 *
    	 * @see #CREATE_BULK_PRESCRIPTION the request primitive
    	 */
    	String CREATE_BULK_PRESCRIPTION_ERROR = "createBulkPrescriptionError";
    	/**
    	 * The 'createMerge' request primitive for the Prescription entity.
    	 * @see Prescription the request payload
    	 */
    	String CREATE_MERGE_PRESCRIPTION = "createMergePrescription";
    	/**
    	 * The success response primitive for createMergePrescription.
    	 *
    	 * @see #CREATE_MERGE_PRESCRIPTION the request primitive
    	 */
    	String CREATE_MERGE_PRESCRIPTION_RESPONSE = "createMergePrescriptionResponse";
    	/**
    	 * An error response primitive for createMergePrescription.
    	 *
    	 * @see #CREATE_MERGE_PRESCRIPTION the request primitive
    	 */
    	String CREATE_MERGE_PRESCRIPTION_ERROR = "createMergePrescriptionError";
    	/**
    	 * The 'retrieve' request primitive for the Prescription entity.
    	 * @see Prescription.GetRequest the request payload
    	 */
    	String RETRIEVE_PRESCRIPTION = "retrievePrescription";
    	/**
    	 * The success response primitive for retrievePrescription.
    	 *
    	 * @see #RETRIEVE_PRESCRIPTION the request primitive
    	 */
    	String RETRIEVE_PRESCRIPTION_RESPONSE = "retrievePrescriptionResponse";
    	/**
    	 * An error response primitive for retrievePrescription.
    	 *
    	 * @see #RETRIEVE_PRESCRIPTION the request primitive
    	 */
    	String RETRIEVE_PRESCRIPTION_ERROR = "retrievePrescriptionError";
    	/**
    	 * The 'update' request primitive for the Prescription entity.
    	 * @see Prescription the request payload
    	 */
    	String UPDATE_PRESCRIPTION = "updatePrescription";
    	/**
    	 * The success response primitive for updatePrescription.
    	 *
    	 * @see #UPDATE_PRESCRIPTION the request primitive
    	 */
    	String UPDATE_PRESCRIPTION_RESPONSE = "updatePrescriptionResponse";
    	/**
    	 * An error response primitive for updatePrescription.
    	 *
    	 * @see #UPDATE_PRESCRIPTION the request primitive
    	 */
    	String UPDATE_PRESCRIPTION_ERROR = "updatePrescriptionError";
    	/**
    	 * The 'updateMerge' request primitive for the Prescription entity.
    	 * @see Prescription the request payload
    	 */
    	String UPDATE_MERGE_PRESCRIPTION = "updateMergePrescription";
    	/**
    	 * The success response primitive for updateMergePrescription.
    	 *
    	 * @see #UPDATE_MERGE_PRESCRIPTION the request primitive
    	 */
    	String UPDATE_MERGE_PRESCRIPTION_RESPONSE = "updateMergePrescriptionResponse";
    	/**
    	 * An error response primitive for updateMergePrescription.
    	 *
    	 * @see #UPDATE_MERGE_PRESCRIPTION the request primitive
    	 */
    	String UPDATE_MERGE_PRESCRIPTION_ERROR = "updateMergePrescriptionError";
    	/**
    	 * The 'delete' request primitive for the Prescription entity.
    	 * @see Prescription.Id the request payload
    	 */
    	String DELETE_PRESCRIPTION = "deletePrescription";
    	/**
    	 * The success response primitive for deletePrescription.
    	 *
    	 * @see #DELETE_PRESCRIPTION the request primitive
    	 */
    	String DELETE_PRESCRIPTION_RESPONSE = "deletePrescriptionResponse";
    	/**
    	 * An error response primitive for deletePrescription.
    	 *
    	 * @see #DELETE_PRESCRIPTION the request primitive
    	 */
    	String DELETE_PRESCRIPTION_ERROR = "deletePrescriptionError";
    	/**
    	 * The 'create' request primitive for the ResponsibleFamilyMember entity.
    	 * @see ResponsibleFamilyMember the request payload
    	 */
    	String CREATE_RESPONSIBLE_FAMILY_MEMBER = "createResponsibleFamilyMember";
    	/**
    	 * The success response primitive for createResponsibleFamilyMember.
    	 *
    	 * @see #CREATE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String CREATE_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "createResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for createResponsibleFamilyMember.
    	 *
    	 * @see #CREATE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String CREATE_RESPONSIBLE_FAMILY_MEMBER_ERROR = "createResponsibleFamilyMemberError";
    	/**
    	 * The 'createBulk' request primitive for the ResponsibleFamilyMember entity.
    	 * @see CreateBulkResponsibleFamilyMemberInput the request payload
    	 */
    	String CREATE_BULK_RESPONSIBLE_FAMILY_MEMBER = "createBulkResponsibleFamilyMember";
    	/**
    	 * The success response primitive for createBulkResponsibleFamilyMember.
    	 *
    	 * @see #CREATE_BULK_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 * @see CreateBulkResponsibleFamilyMemberOutput the response payload
    	 */
    	String CREATE_BULK_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "createBulkResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for createBulkResponsibleFamilyMember.
    	 *
    	 * @see #CREATE_BULK_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String CREATE_BULK_RESPONSIBLE_FAMILY_MEMBER_ERROR = "createBulkResponsibleFamilyMemberError";
    	/**
    	 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
    	 * @see ResponsibleFamilyMember the request payload
    	 */
    	String CREATE_MERGE_RESPONSIBLE_FAMILY_MEMBER = "createMergeResponsibleFamilyMember";
    	/**
    	 * The success response primitive for createMergeResponsibleFamilyMember.
    	 *
    	 * @see #CREATE_MERGE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String CREATE_MERGE_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "createMergeResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for createMergeResponsibleFamilyMember.
    	 *
    	 * @see #CREATE_MERGE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String CREATE_MERGE_RESPONSIBLE_FAMILY_MEMBER_ERROR = "createMergeResponsibleFamilyMemberError";
    	/**
    	 * The 'retrieve' request primitive for the ResponsibleFamilyMember entity.
    	 * @see ResponsibleFamilyMember.GetRequest the request payload
    	 */
    	String RETRIEVE_RESPONSIBLE_FAMILY_MEMBER = "retrieveResponsibleFamilyMember";
    	/**
    	 * The success response primitive for retrieveResponsibleFamilyMember.
    	 *
    	 * @see #RETRIEVE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String RETRIEVE_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "retrieveResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for retrieveResponsibleFamilyMember.
    	 *
    	 * @see #RETRIEVE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String RETRIEVE_RESPONSIBLE_FAMILY_MEMBER_ERROR = "retrieveResponsibleFamilyMemberError";
    	/**
    	 * The 'update' request primitive for the ResponsibleFamilyMember entity.
    	 * @see ResponsibleFamilyMember the request payload
    	 */
    	String UPDATE_RESPONSIBLE_FAMILY_MEMBER = "updateResponsibleFamilyMember";
    	/**
    	 * The success response primitive for updateResponsibleFamilyMember.
    	 *
    	 * @see #UPDATE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String UPDATE_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "updateResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for updateResponsibleFamilyMember.
    	 *
    	 * @see #UPDATE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String UPDATE_RESPONSIBLE_FAMILY_MEMBER_ERROR = "updateResponsibleFamilyMemberError";
    	/**
    	 * The 'updateMerge' request primitive for the ResponsibleFamilyMember entity.
    	 * @see ResponsibleFamilyMember the request payload
    	 */
    	String UPDATE_MERGE_RESPONSIBLE_FAMILY_MEMBER = "updateMergeResponsibleFamilyMember";
    	/**
    	 * The success response primitive for updateMergeResponsibleFamilyMember.
    	 *
    	 * @see #UPDATE_MERGE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String UPDATE_MERGE_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "updateMergeResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for updateMergeResponsibleFamilyMember.
    	 *
    	 * @see #UPDATE_MERGE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String UPDATE_MERGE_RESPONSIBLE_FAMILY_MEMBER_ERROR = "updateMergeResponsibleFamilyMemberError";
    	/**
    	 * The 'delete' request primitive for the ResponsibleFamilyMember entity.
    	 * @see ResponsibleFamilyMember.Id the request payload
    	 */
    	String DELETE_RESPONSIBLE_FAMILY_MEMBER = "deleteResponsibleFamilyMember";
    	/**
    	 * The success response primitive for deleteResponsibleFamilyMember.
    	 *
    	 * @see #DELETE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String DELETE_RESPONSIBLE_FAMILY_MEMBER_RESPONSE = "deleteResponsibleFamilyMemberResponse";
    	/**
    	 * An error response primitive for deleteResponsibleFamilyMember.
    	 *
    	 * @see #DELETE_RESPONSIBLE_FAMILY_MEMBER the request primitive
    	 */
    	String DELETE_RESPONSIBLE_FAMILY_MEMBER_ERROR = "deleteResponsibleFamilyMemberError";
    }
    
    interface Events {
    	/**
    	 * Evento responsável por declarar que paciente foi admitido
    	 */
    	String PATIENT_ADMITTED = "patientAdmitted";
    	/**
    	 * Default 'serviceStarted' event.
    	 */
    	String SERVICE_STARTED = "serviceStarted";
    	/**
    	 * Default 'notifyUser' event.
    	 */
    	String NOTIFY_USER_EVENT = "notifyUserEvent";
    	String IMPORT_PATIENT_EVENT = "importPatientEvent";
    	String EXPORT_PATIENT_EVENT = "exportPatientEvent";
    	String IMPORT_DOCTOR_EVENT = "importDoctorEvent";
    	String EXPORT_DOCTOR_EVENT = "exportDoctorEvent";
    	String IMPORT_PRESCRIPTION_EVENT = "importPrescriptionEvent";
    	String EXPORT_PRESCRIPTION_EVENT = "exportPrescriptionEvent";
    	String IMPORT_RESPONSIBLE_FAMILY_MEMBER_EVENT = "importResponsibleFamilyMemberEvent";
    	String EXPORT_RESPONSIBLE_FAMILY_MEMBER_EVENT = "exportResponsibleFamilyMemberEvent";
    }
    
}
