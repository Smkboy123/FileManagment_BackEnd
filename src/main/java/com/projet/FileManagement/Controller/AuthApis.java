package com.projet.FileManagement.Controller;

import com.projet.FileManagement.Controller.abst.ApiResponse200;
import com.projet.FileManagement.Exception.ApiConstants;
import com.projet.FileManagement.Exception.JwtResponse;
import com.projet.FileManagement.Security.JwtProvider;
import com.projet.FileManagement.models.LoginForm;
import com.projet.FileManagement.models.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_VERSION_ONE + "basicAuth")
//@Tag(name = "AuthApis", description = "Authentication - Apis")
@RequiredArgsConstructor
public class AuthApis {


    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @GetMapping("/currentUserRole")
    @ApiResponse200(content = {@Content(schema = @Schema(implementation = Role.class))})
    public static ResponseEntity<Role> getCurrentUsersRole() {
        final List<Role> roles = new ArrayList<>();
        final Role roleDto = (roles.size() == 1) ? Role.builder()
                .roleName(roles.get(0).getRoleName())
                .build() : null;
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @PostMapping("/JwtResponse")
    @Operation(summary = "basic authentication with username and password", operationId = "userIsValid")
    @ApiResponse200(content = {@Content(schema = @Schema(implementation = JwtResponse.class))})
    public ResponseEntity<JwtResponse> userIsValid(@RequestBody LoginForm loginForm, final HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));

    }

    private static void setCookie(final HttpServletResponse response, final String token) {
        final Cookie cookie = new Cookie("token", token);
        cookie.setPath("/api");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(1800);
        response.addCookie(cookie);
    }
}
