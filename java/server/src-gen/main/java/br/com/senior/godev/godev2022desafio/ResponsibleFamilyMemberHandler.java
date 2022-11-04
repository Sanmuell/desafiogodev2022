/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import static br.com.senior.SecurityConstants.*;
import static br.com.senior.godev.godev2022desafio.ResponsibleFamilyMemberEntity.SECURITY_RESOURCE;
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
import br.com.senior.godev.godev2022desafio.ResponsibleFamilyMember.Id;
import br.com.senior.godev.godev2022desafio.ResponsibleFamilyMember.PageRequest;
import br.com.senior.godev.godev2022desafio.ResponsibleFamilyMember.PagedResults;
import org.springframework.stereotype.Component;
import br.com.senior.platform.translationhub.api.TranslationHubApi;

@HandlerImpl(serviceClass = Godev2022desafioConstants.class)
@Component("godev.godev2022desafio.ResponsibleFamilyMemberHandler")
public class ResponsibleFamilyMemberHandler implements CreateResponsibleFamilyMember, CreateMergeResponsibleFamilyMember, UpdateResponsibleFamilyMember, DeleteResponsibleFamilyMember, 
		 UpdateMergeResponsibleFamilyMember, CreateBulkResponsibleFamilyMember, RetrieveResponsibleFamilyMember, ListResponsibleFamilyMember, 
		 ImportResponsibleFamilyMember, ExportResponsibleFamilyMember {
	static final Logger logger = LoggerFactory.getLogger(ResponsibleFamilyMemberHandler.class);
	
	private static final String ID_FIELD_NAME = Arrays.stream(ResponsibleFamilyMemberEntity.class.getDeclaredFields())
            .filter(field -> field.isAnnotationPresent(javax.persistence.Id.class))
            .map(Field::getName)
            .findFirst()
            .orElseGet(() -> "id");

	@Inject
	ResponsibleFamilyMemberCrudService service;
	
	@Inject
	ResponsibleFamilyMemberDTOConverter dtoConverter;
	
	@Inject
	CustomDTOValidatorImpl customValidator;
	
	@Inject
	EntityDefProviderImpl entityDefProvider;
	
	@Inject
	protected TranslationHubApi translationHubApi;
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public ResponsibleFamilyMember createResponsibleFamilyMember(ResponsibleFamilyMember toCreate) {
		try {
			customValidator.validate(toCreate, entityDefProvider.getEntityDef("responsibleFamilyMember"));
			ResponsibleFamilyMemberEntity entity = service.createResponsibleFamilyMember(dtoConverter.toEntity(toCreate, true));
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public ResponsibleFamilyMember createMergeResponsibleFamilyMember(ResponsibleFamilyMember toCreate) {
		try {
			ResponsibleFamilyMemberEntity entity = service.createResponsibleFamilyMember(dtoConverter.toEntity(toCreate, false));
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_UPDATE)
	@Transactional
	@Override
	public ResponsibleFamilyMember updateResponsibleFamilyMember(ResponsibleFamilyMember toUpdate) {
		try {
			customValidator.validate(toUpdate, entityDefProvider.getEntityDef("responsibleFamilyMember"));
			ResponsibleFamilyMemberEntity modified = doUpdate(toUpdate);
			return dtoConverter.toDTO(modified);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_UPDATE)
	@Transactional
	@Override
	public ResponsibleFamilyMember updateMergeResponsibleFamilyMember(ResponsibleFamilyMember toUpdate) {
		try {
			customValidator.validate(toUpdate, entityDefProvider.getEntityDef("responsibleFamilyMember"));
			ResponsibleFamilyMemberEntity entity = service.retrieveResponsibleFamilyMember(new ResponsibleFamilyMember.Id(toUpdate.id));
			dtoConverter.mergeEntity(entity, toUpdate);
			entity = service.updateResponsibleFamilyMember(entity);
			return dtoConverter.toDTO(entity);
			
		} catch (br.com.senior.messaging.model.ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_illegalArgument", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.INTERNAL_ERROR, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_internalError", "An internal error occurred: "
				+ e.getClass().getSimpleName() + ". Please check the request parameters and try again."), e);
		}
	}
	
	private ResponsibleFamilyMemberEntity doUpdate(ResponsibleFamilyMember toUpdate) {
		java.util.Optional<ResponsibleFamilyMemberEntity> optionalEntity = service.getRepository().findById(java.util.UUID.fromString(toUpdate.id));
		
		if(optionalEntity.isEmpty())
			throw new br.com.senior.messaging.model.ServiceException(br.com.senior.messaging.ErrorCategory.OBJECT_NOT_FOUND, translationHubApi.getExternalMessage("godev", "godev2022desafio", "godev.godev2022desafio.responsibleFamilyMember_notFound", "ResponsibleFamilyMember not found with id " + toUpdate.id));
		
		ResponsibleFamilyMemberEntity entity = optionalEntity.get();
		
		dtoConverter.updateEntity(entity, toUpdate);
		return doUpdate(entity);
	}
	
	private ResponsibleFamilyMemberEntity doUpdate(ResponsibleFamilyMemberEntity entity) {
		return service.updateResponsibleFamilyMember(entity);
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_DELETE)
	@Transactional
	@Override
	public void deleteResponsibleFamilyMember(Id id) {
		try {
			this.service.deleteResponsibleFamilyMember(id);
		} catch(DataIntegrityViolationException ex) {
			logger.warn(ex.getMessage(), ex);
			if(ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
				org.hibernate.exception.ConstraintViolationException cve = (org.hibernate.exception.ConstraintViolationException) ex.getCause();
				throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getFormattedMessage("godev.godev2022desafio.delete_constraint_violation", cve.getConstraintName()));
			}
			
			throw new ServiceException(ErrorCategory.CONFLICT, translationHubApi.getMessage("godev.godev2022desafio.responsibleFamilyMember_dataIntegrityViolation", "Data integrity violation to Delete ResponsibleFamilyMember. Error: " + ex.getMessage()), ex);
		}
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public ResponsibleFamilyMember retrieveResponsibleFamilyMember(ResponsibleFamilyMember.GetRequest request) {
		ResponsibleFamilyMemberEntity entity = service.retrieveResponsibleFamilyMember(new ResponsibleFamilyMember.Id(request.id));
		return dtoConverter.toDTO(entity, request.displayFields);
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public PagedResults listResponsibleFamilyMember(PageRequest pageRequest) {
		int skip = pageRequest.offset != null ? pageRequest.offset.intValue() : 0;
		int top = pageRequest.size != null ? pageRequest.size.intValue() : 0;
		String orderBy = pageRequest.orderBy == null ? ID_FIELD_NAME + " asc" : pageRequest.orderBy;
		String filter = pageRequest.filter;
		Page<ResponsibleFamilyMemberEntity> pages = this.service.listResponsibleFamilyMemberPageable(skip, top, orderBy, filter);
		List<ResponsibleFamilyMemberEntity> entities = pages.getContent();
		List<ResponsibleFamilyMember> dtos = null;
		
		dtos = entities != null ? entities.stream().map(e -> dtoConverter.toDTO(e, pageRequest.displayFields)).collect(Collectors.toList()) : null;
		return new PagedResults(dtos, Long.valueOf(pages.getTotalPages()), Long.valueOf(pages.getTotalElements()));
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public CreateBulkResponsibleFamilyMemberOutput createBulkResponsibleFamilyMember(CreateBulkResponsibleFamilyMemberInput toCreate) {
		if (toCreate != null) {
			List<ResponsibleFamilyMember> entitiesToCreate = toCreate.entities;
			if (entitiesToCreate != null && !entitiesToCreate.isEmpty()) {
				entitiesToCreate.forEach(bean -> {
					customValidator.validate(bean, entityDefProvider.getEntityDef("responsibleFamilyMember"));
					bean.validate();
				});
				
				List<ResponsibleFamilyMemberEntity> entities = entitiesToCreate.stream().map(bean -> dtoConverter.toEntity(bean))
						.collect(Collectors.toList());
				this.service.createBulk(entities);
			}
		}
		return new CreateBulkResponsibleFamilyMemberOutput();
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_CREATE)
	@Transactional
	@Override
	public ImportResponsibleFamilyMemberOutput importResponsibleFamilyMember(ImportResponsibleFamilyMemberInput request) {
		Importer importer = BatchIntegrationController.getInstance().newImporter();
		StartImportProcess startImportProcess = new StartImportProcess(importer, request.config);
		startImportProcess.start();
		ImportResponsibleFamilyMemberOutput output = new ImportResponsibleFamilyMemberOutput(importer.getId());
		return output;
	}
	
	@SecureResource(name=SECURITY_RESOURCE, action=ENTITY_SECURITY_ACTION_VIEW)
	@Transactional(readOnly = true)
	@Override
	public ExportResponsibleFamilyMemberOutput exportResponsibleFamilyMember(ExportResponsibleFamilyMemberInput request) {
		/*
		 * **** Not implemented yet **** ExporterControl control =
		 * ExporterControl.getInstance(); Exporter exporter =
		 * control.newExporter(); StartExportProcess startExportProcess = new
		 * StartExportProcess(exporter, request.config);
		 * startExportProcess.start();
		 */
		ExportResponsibleFamilyMemberOutput output = new ExportResponsibleFamilyMemberOutput(
				null /* exporter.getId() */);
		return output;
	}
	
	class StartImportProcess extends Thread {
	
		private Importer importer;
		private ImportConfig config;
		
		StartImportProcess(Importer importer, ImportConfig config) {
			this.importer = importer;
			this.importer.addListener(new ResponsibleFamilyMemberImporterListener());
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
					importer.setBeanClass(ResponsibleFamilyMember.class.getName());
					importer.setCrudService(ResponsibleFamilyMemberHandler.this.service, (config.batchSize > 0));
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
				File blob = File.createTempFile("responsiblefamilymember", "blob");
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
