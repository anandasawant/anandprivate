package com.ani.billing.dto;

import com.ani.billing.domain.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppResponseTests {


    @DisplayName("AppResponseDto : Cheacking Object Creation")
    @Test
    void testObjectCreation(){
        var app = new AppResponse<>();
        Assertions.assertNotNull(app);
    }
}
