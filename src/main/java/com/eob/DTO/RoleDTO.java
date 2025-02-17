package com.eob.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private int roleId;

    @JsonProperty("rolename")
    private String rolename;

    @JsonProperty("permissions")
    private String[] permissions;
    
}