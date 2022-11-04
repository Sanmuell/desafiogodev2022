/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import static br.com.senior.SecurityConstants.*;
import static br.com.senior.godev.godev2022desafio.DoctorEntity.SECURITY_RESOURCE;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.messaging.security.SecureResource;
import br.com.senior.custom.metadata.EntityDefProviderImpl;
import br.com.senior.custom.validator.CustomDTOValidatorImpl;
import br.com.senior.springbatchintegration.control.BatchIntegrationController;
import br.com.senior.springbatchintegration.importer.Importer;
import br.com.senior.springbatchintegration.importer.ImporterException;
import br.com.senior.springbatchintegration.model.Layout;
import br.com.senior.godev.godev2022desafio.Doctor.Id;
import br.com.senior.godev.godev2022desafio.Doctor.PageRequest;
import br.com.senior.godev.godev2022desafio.Doctor.PagedResults;
import org.springframework.stereotype.Component;
import br.com.senior.platform.translationhub.api.TranslationHubApi;

@HandlerImpl(serviceClass = Godev2022desafioConstants.class)
@Component("godev.godev2022desafio.DoctorHandler")
public class DoctorHandler implements CreateDoctor, CreateMergeDoctor, UpdateDoctor, DeleteDoctor, 
		 UpdateMergeDoctor, CreateBulkDoctor, RetrieveDoctor, ListDoctor, 
		 ImportDoctor, ExportDoctor {
	static final Logger logger = LoggerFactory.getLogger(DoctorHandler.class);
	
	private static final String ID_FIELD_NAME = Arrays.stream(DoctorEntity.class.getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(javax.persistence.Id.class))
            .map(Field::getName)
            .findFirst()
            .orElseGet(() -> "id");

	@Inject
	DoctorCrudService service;
	
	@Inject
	DoctorDTOConverter dtoConverter;
	
	@Inject
	CustomDTOValidatorImpl customValidator;
	
	@Inject
	EntityDefProviderImpl entityDefProvider;
	
	@Inject
	protected TranslationHubApi translationHubApi;
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public Doctor createDoctor(Doctor toCreate) {
		try {
			customValidator.validate(toCreate, entityDefProvider.getEntityDef("doctor"));
			DoctorEntity entity = service.createDoctor(dtoConverter.toEntity(toCreate, true));
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public Doctor createMergeDoctor(Doctor toCreate) {
		try {
			DoctorEntity entity = service.createDoctor(dtoConverter.toEntity(toCreate, false));
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_UPDATE)
	@Transactional
	@Override
	public Doctor updateDoctor(Doctor toUpdate) {
		try {
			customValidator.validate(toUpdate, entityDefProvider.getEntityDef("doctor"));
			DoctorEntity modified = doUpdate(toUpdate);
			return dtoConverter.toDTO(modified);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_UPDATE)
	@Transactional
	@Override
	public Doctor updateMergeDoctor(Doctor toUpdate) {
		try {
			customValidator.validate(toUpdate, entityDefProvider.getEntityDef("doctor"));
			DoctorEntity entity = service.retrieveDoctor(new Doctor.Id(toUpdate.id));
			dtoConverter.mergeEntity(entity, toUpdate);
			entity = service.updateDoctor(entity);
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.doctor_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	private DoctorEntity doUpdate(Doctor toUpdate) {
		java.util.Optional<DoctorEntity> optionalEntity = service.getRepository().findById(java.util.UUID.fromString(toUpdate.id));
		
		if(optionalEntity.isEmpty())
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.OBJECT_NOT_FOUND, translationHubApi.getExternalMessage("godev", "godev2022desafio", "godev.godev2022desafio.doctor_notFound", "Doctor not found with id " + toUpdate.id));
		
		DoctorEntity entity = optionalEntity.get();
		
		dtoConverter.updateEntity(entity, toUpdate);
		return doUpdate(entity);
	}
	
	private DoctorEntity doUpdate(DoctorEntity entity) {
		return service.updateDoctor(entity);
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_DELETE)
	@Transactional
	@Override
	public void deleteDoctor(Id id) {
		try {
			this.service.deleteDoctor(id);
		} catch(DataIntegrityViolationException ex) {
			logger.warn(ex.getMessage(), ex);
			if(ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
				org.hibernate.exception.ConstraintViolationException cve = (org.hibernate.exception.ConstraintViolationException) ex.getCause();
				throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getFormattedMessage("godev.godev2022desafio.delete_constraint_violation", cve.getConstraintName()));
			}
			
			throw new ServiceException(ErrorCategory.CONFLICT, translationHubApi.getMessage("godev.godev2022desafio.doctor_dataIntegrityViolation", "Data integrity violation to Delete Doctor. Error: " + ex.getMessage()), ex);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public Doctor retrieveDoctor(Doctor.GetRequest request) {
		DoctorEntity entity = service.retrieveDoctor(new Doctor.Id(request.id));
		return dtoConverter.toDTO(entity, request.displayFields);
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public PagedResults listDoctor(PageRequest pageRequest) {
		int skip = pageRequest.offset != null ? pageRequest.offset.intValue() : 0;
		int top = pageRequest.size != null ? pageRequest.size.intValue() : 0;
		String orderBy = pageRequest.orderBy == null ? ID_FIELD_NAME + " asc" : pageRequest.orderBy;
		String filter = pageRequest.filter;
		Page<DoctorEntity> pages = this.service.listDoctorPageable(skip, top, orderBy, filter);
		List<DoctorEntity> entities = pages.getContent();
		List<Doctor> dtos = null;
		
		dtos = entities != null ? entities.stream().map(e -> dtoConverter.toDTO(e, pageRequest.displayFields)).collect(Collectors.toList()) : null;
		return new PagedResults(dtos, Long.valueOf(pages.getTotalPages()), Long.valueOf(pages.getTotalElements()));
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public CreateBulkDoctorOutput createBulkDoctor(CreateBulkDoctorInput toCreate) {
		if (toCreate != null) {
			List<Doctor> entitiesToCreate = toCreate.entities;
			if (entitiesToCreate != null && !entitiesToCreate.isEmpty()) {
				entitiesToCreate.forEach(bean -> {
					customValidator.validate(bean, entityDefProvider.getEntityDef("doctor"));
					bean.validate();
				});
				
				List<DoctorEntity> entities = entitiesToCreate.stream().map(bean -> dtoConverter.toEntity(bean))
						.collect(Collectors.toList());
				this.service.createBulk(entities);
			}
		}
		return new CreateBulkDoctorOutput();
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public ImportDoctorOutput importDoctor(ImportDoctorInput request) {
		Importer importer = BatchIntegrationController.getInstance().newImporter();
		StartImportProcess startImportProcess = new StartImportProcess(importer, request.config);
		startImportProcess.start();
		ImportDoctorOutput output = new ImportDoctorOutput(importer.getId());
		return output;
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public ExportDoctorOutput exportDoctor(ExportDoctorInput request) {
		/*
		 * **** Not implemented yet **** ExporterControl control =
		 * ExporterControl.getInstance(); Exporter exporter =
		 * control.newExporter(); StartExportProcess startExportProcess = new
		 * StartExportProcess(exporter, request.config);
		 * startExportProcess.start();
		 */
		ExportDoctorOutput output = new ExportDoctorOutput(
				null /* exporter.getId() */);
		return output;
	}
	
	class StartImportProcess extends Thread {
	
		private Importer importer;
		private ImportConfig config;
		
		StartImportProcess(Importer importer, ImportConfig config) {
			this.importer = importer;
			this.importer.addListener(new DoctorImporterListener());
			this.config = config;
			this.importer.logUri(this.config.uri);
		}
		
		@Async
		@Override
		public void run() {
			File blob = getBlobFile();
			try {
				Layout layout = LayoutDTOConverter.dtoToLayout(config.layout);
				try (FileReader reader = new FileReader(blob)) {
					importer.setReader(reader);
					importer.setLayout(layout);
					importer.setBeanClass(Doctor.class.getName());
					importer.setCrudService(DoctorHandler.this.service, (config.batchSize > 0));
					importer.setBatchSize(config.batchSize);
					if (config.async) {
						importer.startAsync();
					} else {
						try {
							importer.start();
						} catch (ImporterException e) {
							logger.error(e.getMessage(), e);
						}
					}
				}
			} catch (IOException e) {
				// isto nao deveria ocorrer
				logger.error(e.getMessage(), e);
			}
		}
		
		private File getBlobFile() {
			URI uri = null;
			try {
				uri = new URI(config.uri);
			} catch (URISyntaxException e1) {
				logger.error(e1.getMessage(), e1);
			}
			String scheme = uri.getScheme();
			if (scheme.equals("file")) {
				return new File(uri);
			} else if (scheme.startsWith("http")) {
				return getHttpBlobFile(uri);
			}
			return null;
		}
		
		private File getHttpBlobFile(URI uri) {
			importer.notifyDownload();
			HttpGet get = new HttpGet(uri);
			try (CloseableHttpClient httpClient = HttpClients.createDefault();
					CloseableHttpResponse httpResponse = httpClient.execute(get);
					InputStream is = httpResponse.getEntity().getContent()) {
				File blob = File.createTempFile("doctor", "blob");
				try (FileOutputStream fos = new FileOutputStream(blob);
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						BufferedInputStream bis = new BufferedInputStream(is)) {
					byte[] bytes = new byte[8192];
					int tam = 0;
					while ((tam = bis.read(bytes)) > 0) {
						bos.write(bytes, 0, tam);
					}
					bos.flush();
					fos.flush();
				}
				return blob;
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			return null;
		}
	}
}
