package com.feanix.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name="system_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SystemUser {
    @Id
    @Column(name="user_id", length = 80)
    private String userId;
    @Column(name="username", length = 100, unique = true)
    private String username;// email
    private String password;
    private String address;

    @Column(name="is_account_non_expired", columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;
    @Column(name="is_account_non_locked", columnDefinition = "TINYINT")
    private boolean isAccountNonLocked;
    @Column(name="is_credentials_non_expired", columnDefinition = "TINYINT")
    private boolean isCredentialsNonExpired;
    @Column(name="is_enable", columnDefinition = "TINYINT")
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name="user_role_detail",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<UserRole> roles;

    @OneToMany(mappedBy = "user")
    private Set<CustomerOrder> orders = new HashSet<>();

}
