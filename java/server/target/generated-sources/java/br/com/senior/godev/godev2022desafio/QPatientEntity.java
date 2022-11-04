package br.com.senior.godev.godev2022desafio;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPatientEntity is a Querydsl query type for PatientEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPatientEntity extends EntityPathBase<PatientEntity> {

    private static final long serialVersionUID = -1964705632L;

    public static final QPatientEntity patientEntity = new QPatientEntity("patientEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    public final StringPath address = createString("address");

    public final StringPath cpf = createString("cpf");

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final BooleanPath isAtivo = createBoolean("isAtivo");

    public final StringPath name = createString("name");

    public final NumberPath<Long> phone = createNumber("phone", Long.class);

    public final ListPath<PrescriptionEntity, QPrescriptionEntity> prescriptions = this.<PrescriptionEntity, QPrescriptionEntity>createList("prescriptions", PrescriptionEntity.class, QPrescriptionEntity.class, PathInits.DIRECT2);

    public final ListPath<DoctorEntity, QDoctorEntity> responsibleDoctors = this.<DoctorEntity, QDoctorEntity>createList("responsibleDoctors", DoctorEntity.class, QDoctorEntity.class, PathInits.DIRECT2);

    public final ListPath<ResponsibleFamilyMemberEntity, QResponsibleFamilyMemberEntity> responsibleFamilyMembers = this.<ResponsibleFamilyMemberEntity, QResponsibleFamilyMemberEntity>createList("responsibleFamilyMembers", ResponsibleFamilyMemberEntity.class, QResponsibleFamilyMemberEntity.class, PathInits.DIRECT2);

    public QPatientEntity(String variable) {
        super(PatientEntity.class, forVariable(variable));
    }

    public QPatientEntity(Path<? extends PatientEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPatientEntity(PathMetadata metadata) {
        super(PatientEntity.class, metadata);
    }

}

