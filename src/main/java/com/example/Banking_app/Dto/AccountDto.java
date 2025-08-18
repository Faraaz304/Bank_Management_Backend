package com.example.Banking_app.Dto;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;



// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class AccountDto  {
//     private long id;
//     private String AccountHolderName;
//     private double balance;
// }

public record AccountDto(
    long id,
    String accountHolderName,
    double balance
) {
    // You can add any additional methods or validation logic here if needed
}
