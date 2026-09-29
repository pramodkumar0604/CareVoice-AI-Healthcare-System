package com.healthcare.repository; // Ee file repository folder lo undi ani

import com.healthcare.model.User; // User table tho pani ani
import org.springframework.data.jpa.repository.JpaRepository; // DB tho matladaniki ready-made tools
import java.util.Optional; // User dorakkapothe error raakunda

public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository ante - save, delete, find anni free ga vastai. <User, Long> ante User table ki, ID Long type

    Optional<User> findByEmail(String email); // Email tho user ni velakadaniki - Login appudu kavali. Enduku ante email unique kada

    Boolean existsByEmail(String email); // Ee email tho user already unnada leda check cheyadaniki - Register appudu duplicate rakunda
}
