package com.example.hackathon.domain.basket.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasket is a Querydsl query type for Basket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasket extends EntityPathBase<Basket> {

    private static final long serialVersionUID = -306049753L;

    public static final QBasket basket = new QBasket("basket");

    public final StringPath basketName = createString("basketName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QBasket(String variable) {
        super(Basket.class, forVariable(variable));
    }

    public QBasket(Path<? extends Basket> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasket(PathMetadata metadata) {
        super(Basket.class, metadata);
    }

}

