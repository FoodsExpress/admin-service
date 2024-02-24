package com.foodexpress.adminservice.common.security;

public record JwtAuthentication(Long id, String accountId, String email, String nickname) {

}