package br.com.senior.godev.godev2022desafio;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrescriptionEntity is a Querydsl query type for PrescriptionEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrescriptionEntity extends EntityPathBase<PrescriptionEntity> {

    private static final long serialVersionUID = 1796586053L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPrescriptionEntity prescriptionEntity = new QPrescriptionEntity("prescriptionEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final DatePath<java.time.LocalDate> data = createDate("data", java.time.LocalDate.class);

    public final StringPath description = createString("description");

    public final QDoctorEntity doctorResponsible;

    public final StringPath drug = createString("drug");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final QPatientEntity patient;

    public final BooleanPath statementOfReponsability = createBoolean("statementOfReponsability");

    public final EnumPath<PrecriptionType> type = createEnum("type", PrecriptionType.class);

    public QPrescriptionEntity(String variable) {
        this(PrescriptionEntity.class, forVariable(variable), INITS);
    }

    public QPrescriptionEntity(Path<? extends PrescriptionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPrescriptionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPrescriptionEntity(PathMetadata metadata, PathInits inits) {
        this(PrescriptionEntity.class, metadata, inits);
    }

    public QPrescriptionEntity(Class<? extends PrescriptionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.doctorResponsible = inits.isInitialized("doctorResponsible") ? new QDoctorEntity(forProperty("doctorResponsible")) : null;
        this.patient = inits.isInitialized("patient") ? new QPatientEntity(forProperty("patient")) : null;
    }

}

