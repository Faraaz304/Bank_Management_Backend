
package com.example.Banking_app.dto;

public record CustomerDto(
    Long id,
    String firstName,
    String lastName,
    String email,
    String phone
) {
    // optional: add validation logic or helper methods
}
