package com.projet.FileManagement.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Role {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName roleName;

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role(Long id, String roLeAdmin) {
    }
}






/*



package com.projet.FileManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRole;
    private String nomRole;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnore
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List<Utilisateur> utilisateurs =new ArrayList<>();

}
*/
