package io.github.tacehex.jadmin.core.registry;

import io.github.tacehex.jadmin.core.annotation.JAdminEntity;
import io.github.tacehex.jadmin.core.annotation.JAdminField;
import io.github.tacehex.jadmin.core.model.EntityModel;
import io.github.tacehex.jadmin.core.model.FieldModel;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

@JAdminEntity(displayName = "Пользователь", order = 1)
class TestUserEntity {
    @JAdminField(displayName = "ID", order = 1)
    private Long id;

    @JAdminField(displayName = "Имя пользователя", order = 2)
    private String username;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}

class EntityRegistryTest {
    @Test
    void shouldRegisterEntityAndExtractMetadata() {
        EntityRegistry registry = new EntityRegistry();

        registry.registerEntity(TestUserEntity.class);

        Map<Class<?>, EntityModel> modelMap = registry.getEntityModelMap();
        assertThat(modelMap).hasSize(1);

        EntityModel userModel = modelMap.get(TestUserEntity.class);
        assertThat(userModel).isNotNull();
        assertThat(userModel.getDisplayName()).isEqualTo("Пользователь");
        assertThat(userModel.getFields()).hasSize(2);

        FieldModel idField = userModel.getFields().getFirst();
        assertThat(idField.getDisplayName()).isEqualTo("ID");
    }
}
