package br.com.senior.godev.godev2022desafio;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDoctorEntity is a Querydsl query type for DoctorEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDoctorEntity extends EntityPathBase<DoctorEntity> {

    private static final long serialVersionUID = -87331446L;

    public static final QDoctorEntity doctorEntity = new QDoctorEntity("doctorEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    public final StringPath cpf = createString("cpf");

    public final NumberPath<Long> crmNumber = createNumber("crmNumber", Long.class);

    public final StringPath crmState = createString("crmState");

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final StringPath especiality = createString("especiality");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    public final ListPath<PrescriptionEntity, QPrescriptionEntity> prescriptions = this.<PrescriptionEntity, QPrescriptionEntity>createList("prescriptions", PrescriptionEntity.class, QPrescriptionEntity.class, PathInits.DIRECT2);

    public QDoctorEntity(String variable) {
        super(DoctorEntity.class, forVariable(variable));
    }

    public QDoctorEntity(Path<? extends DoctorEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDoctorEntity(PathMetadata metadata) {
        super(DoctorEntity.class, metadata);
    }

}

