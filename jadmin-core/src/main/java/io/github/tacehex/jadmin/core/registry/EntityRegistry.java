package io.github.tacehex.jadmin.core.registry;

import io.github.tacehex.jadmin.core.model.EntityModel;
import io.github.tacehex.jadmin.core.model.FieldModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Реестр всех сущностей, зарегистрированных в админ-панели.
 * Пока это просто заглушка. Позже он будет наполняться автоматически.
 */
public class EntityRegistry {

    private static final Logger log = LoggerFactory.getLogger(EntityRegistry.class);
    private final Map<Class<?>, EntityModel> entityModelMap = new HashMap<>();

    public EntityRegistry() {
        log.info("JAdmin EntityRegistry initialized");
    }

    /**
     * Регистрирует класс сущности в админ-панели.
     * Пока это ручной метод. Позже мы автоматизируем этот процесс.
     */
    public void registerEntity(Class<?> entityClass) {
        if (entityModelMap.containsKey(entityClass)) {
            log.warn("Entity {} is already registered", entityClass.getName());
            return;
        }

        log.debug("Registering entity: {}", entityClass.getName());
        EntityModel entityModel = new EntityModel(entityClass);

        // Проходим по всем полям класса и создаем для них модели
        for (Field field : entityClass.getDeclaredFields()) {
            FieldModel fieldModel = new FieldModel(field);
            entityModel.addField(fieldModel);
        }

        entityModelMap.put(entityClass, entityModel);
        log.info("Successfully registered entity '{}' with {} fields",
                entityModel.getDisplayName(), entityModel.getFields().size());
    }

    public Map<Class<?>, EntityModel> getEntityModelMap() {
        return entityModelMap;
    }
}
