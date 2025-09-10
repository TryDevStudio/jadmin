package io.github.tacehex.jadmin.core.model;

import io.github.tacehex.jadmin.core.annotation.JAdminField;
import jakarta.annotation.Nonnull;

import java.lang.reflect.Field;

/**
 * Мета-модель поля сущности.
 */
public class FieldModel {

    private final Field field;
    private final String displayName;
    private final int order;
    private final boolean showInList;
    private final boolean showInView;
    private final boolean showInCreate;

    public FieldModel(@Nonnull Field field) {
        this.field = field;
        field.setAccessible(true); // Важно для доступа к private полям
        JAdminField annotation = field.getAnnotation(JAdminField.class);

        if (annotation != null) {
            this.displayName = annotation.displayName().isBlank()
                    ? generateDisplayName(field.getName())
                    : annotation.displayName();
            this.order = annotation.order();
            this.showInList = annotation.showInList();
            this.showInView = annotation.showInView();
            this.showInCreate = annotation.showInCreate();
        } else {
            // Значения по умолчанию
            this.displayName = generateDisplayName(field.getName());
            this.order = Integer.MAX_VALUE;
            this.showInList = true;
            this.showInView = true;
            this.showInCreate = true;
        }
    }

    public Field getField() {
        return field;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getOrder() {
        return order;
    }

    public boolean isShowInList() {
        return showInList;
    }

    public boolean isShowInView() {
        return showInView;
    }

    public boolean isShowInCreate() {
        return showInCreate;
    }

    private String generateDisplayName(String fieldName) {
        return fieldName.replaceAll("([a-z])([A-Z])", "$1 $2");
    }

}
