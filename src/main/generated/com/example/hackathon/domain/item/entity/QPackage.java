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
    public final StringPath itemImg = _super.itemImg;

    //inherited
    public final StringPath itemName = _super.itemName;

    //inherited
    public final NumberPath<Integer> itemPrice = _super.itemPrice;

    //inherited
    public final NumberPath<Integer> itemReviewCount = _super.itemReviewCount;

    //inherited
    public final NumberPath<Float> itemStar = _super.itemStar;

    //inherited
    public final NumberPath<Integer> itemStock = _super.itemStock;

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

