package com.eob.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {
	
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
    @JsonProperty("email")
    private String email;

    @Setter
    @Getter
    private Set<RoleDTO> roles ;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
