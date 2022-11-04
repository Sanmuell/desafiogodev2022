package br.com.senior.godev.godev2022desafio;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QResponsibleFamilyMemberEntity is a Querydsl query type for ResponsibleFamilyMemberEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResponsibleFamilyMemberEntity extends EntityPathBase<ResponsibleFamilyMemberEntity> {

    private static final long serialVersionUID = -919187569L;

    public static final QResponsibleFamilyMemberEntity responsibleFamilyMemberEntity = new QResponsibleFamilyMemberEntity("responsibleFamilyMemberEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    public final StringPath cpf = createString("cpf");

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath kinship = createString("kinship");

    public final StringPath name = createString("name");

    public QResponsibleFamilyMemberEntity(String variable) {
        super(ResponsibleFamilyMemberEntity.class, forVariable(variable));
    }

    public QResponsibleFamilyMemberEntity(Path<? extends ResponsibleFamilyMemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResponsibleFamilyMemberEntity(PathMetadata metadata) {
        super(ResponsibleFamilyMemberEntity.class, metadata);
    }

}

