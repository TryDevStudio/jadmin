package io.github.tacehex.jadmin.core.model;

import io.github.tacehex.jadmin.core.annotation.JAdminEntity;
import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

/**
 * Мета-модель сущности, которая предназначена для управления через админ-панель.
 */
public class EntityModel {

    private final Class<?> entityClass;
    private final String displayName;
    private final int order;
    private final List<FieldModel> fields = new ArrayList<>();

    public EntityModel(@Nonnull Class<?> entityClass) {
        this.entityClass = entityClass;
        JAdminEntity annotation = entityClass.getAnnotation(JAdminEntity.class);

        if (annotation != null) {
            this.displayName = annotation.displayName().isBlank()
                    ? generateDisplayName(entityClass.getSimpleName())
                    : annotation.displayName();
            this.order = annotation.order();
        } else {
            // Значения по умолчанию
            this.displayName = generateDisplayName(entityClass.getSimpleName());
            this.order = Integer.MAX_VALUE;
        }
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getOrder() {
        return order;
    }

    public List<FieldModel> getFields() {
        return fields;
    }

    public void addField(FieldModel fieldModel) {
        this.fields.add(fieldModel);
    }

    // "MySuperClass" -> "My Super Class"
    private String generateDisplayName(String className) {
        return className.replaceAll("([a-z])([A-Z])", "$1 $2");
    }
}
