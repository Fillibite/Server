package com.example.hackathon.domain.item.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSample is a Querydsl query type for Sample
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSample extends EntityPathBase<Sample> {

    private static final long serialVersionUID = 541255448L;

    public static final QSample sample = new QSample("sample");

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

    public QSample(String variable) {
        super(Sample.class, forVariable(variable));
    }

    public QSample(Path<? extends Sample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSample(PathMetadata metadata) {
        super(Sample.class, metadata);
    }

}

