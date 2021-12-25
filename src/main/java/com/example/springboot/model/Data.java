package com.example.springboot.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность пользователя")
public class Data {
<<<<<<< Updated upstream
    @Schema(description = "Идентификатор", example = "Можно оставить пустым")
=======
    @Schema(description = "Идентификатор", example = "Можно оставить пустым",accessMode = Schema.AccessMode.READ_ONLY)
>>>>>>> Stashed changes
    public int id;
    @Schema(description = "Имя", example = "Кирилл")
    public String first_name;
    @Schema(description = "Фамилия", example = "Комлев")
    public String last_name;
    @Schema(description = "email", example = "test@test.com")
    public String email;
    @Schema(description = "Уровень Привилегии", example = "1")
    public String privilageid;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    public String privilagename;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    public int    discount;
}