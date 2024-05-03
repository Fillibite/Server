package com.example.hackathon.domain.item.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPackage is a Querydsl query type for Package
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPackage extends EntityPathBase<Package> {

    private static final long serialVersionUID = 1222111384L;

    public static final QPackage package$ = new QPackage("package$");

    public final QItem _super = new QItem(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Long> price = _super.price;

    //inherited
    public final NumberPath<Long> stock = _super.stock;

    public QPackage(String variable) {
        super(Package.class, forVariable(variable));
    }

    public QPackage(Path<? extends Package> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPackage(PathMetadata metadata) {
        super(Package.class, metadata);
    }

}

