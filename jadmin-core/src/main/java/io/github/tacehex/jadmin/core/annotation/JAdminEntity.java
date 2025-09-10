package io.github.tacehex.jadmin.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки классов, которые должны быть доступны
 * в административной панели.
 */
@Target(ElementType.TYPE) // Можно применять только к классам
@Retention(RetentionPolicy.RUNTIME) // Доступна в runtime через рефлексию
public @interface JAdminEntity {

    /**
     * Человекочитаемое имя сущности для отображения в UI.
     * Если не указано, будет сгенерировано на основе имени класса.
     */
    String displayName() default "";

    /**
     * Порядок отображения сущности в списке админ-панели.
     * Сущности с меньшим значением будут отображаться выше.
     */
    int order() default Integer.MAX_VALUE;
}
