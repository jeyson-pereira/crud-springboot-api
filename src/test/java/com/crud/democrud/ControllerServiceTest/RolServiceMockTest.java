package com.crud.democrud.ControllerServiceTest;

import com.crud.democrud.models.RolModel;
import com.crud.democrud.repositories.RolRepository;
import com.crud.democrud.services.RolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RolServiceMockTest {
    @MockBean
    RolRepository rolRepository;

    @Autowired
    RolService rolService;

    @Test
    public void testRolMock(){
        when(rolRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(rolService.obtenerRoles()).isEmpty();
        verify(rolRepository).findAll();
    }

    @Test
    public void testRolById(){
        RolModel rolTested = new RolModel (1L, "estudiante");
        when(rolRepository.findById(1L)).thenReturn(Optional.of(rolTested));
    }
}
