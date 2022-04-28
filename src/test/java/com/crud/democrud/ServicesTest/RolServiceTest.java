package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.RolModel;
import com.crud.democrud.repositories.RolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RolServiceTest {
    @Autowired
    RolRepository rolRepository;

    @Test
    public void testBuscarRolPorId() {
        Long idBuscado = 1L;
        Optional<RolModel> rolModelBuscado = rolRepository.findById(idBuscado);
        assertThat(rolModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarRoles() {
        List<RolModel> rolModelList = (List<RolModel>) rolRepository.findAll();
        assertThat(rolModelList).size().isGreaterThan(0);
    }
}
