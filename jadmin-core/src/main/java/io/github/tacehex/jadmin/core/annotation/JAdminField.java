package io.github.tacehex.jadmin.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки полей внутри классов, отмеченных @JAdminEntity.
 * Позволяет кастомизировать отображение поля в UI.
 */
@Target(ElementType.FIELD) // Можно применять только к полям
@Retention(RetentionPolicy.RUNTIME)
public @interface JAdminField {

    /**
     * Человекочитаемое имя поля для отображения в UI.
     * Если не указано, будет сгенерировано на основе имени поля.
     */
    String displayName() default "";

    /**
     * Порядок отображения поля в форме/таблице.
     * Поля с меньшим значением будут отображаться выше.
     */
    int order() default Integer.MAX_VALUE;

    /**
     * Поле должно отображаться в таблице списка сущностей.
     */
    boolean showInList() default true;

    /**
     * Поле должно отображаться в форме просмотра/редактирования.
     */
    boolean showInView() default true;

    /**
     * Поле должно отображаться в форме создания.
     */
    boolean showInCreate() default true;
}
