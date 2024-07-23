package com.projet.FileManagement.Security;



import com.projet.FileManagement.models.Utilisateur;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityHelper {

    private SecurityHelper() {
    }

   /* public static String getEntrepriseId() {
        final User currentUser = getCurrentUser();
        String entrepriseId = "";
        if (Objects.nonNull(currentUser) && Objects.nonNull(currentUser.getEntreprise())) {
            entrepriseId = currentUser.getEntreprise()
                    .getId();

        }
        return entrepriseId;
    }

    */

    public static Utilisateur getCurrentUser() {
        try {
            final Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            return (auth != null) ? (Utilisateur) auth.getPrincipal() : null;
        } catch (final Exception e) {
            return null;
        }

    }

/*    public static String getCodeClient() {
        final Users currentUser = getCurrentUser();
        String codeClient = "";
        if (Objects.nonNull(currentUser) && StringUtils.isNotBlank(currentUser.getCodeClient())) {
            codeClient = currentUser.getCodeClient();

        }
        return codeClient;
    }




    public static boolean isManager() {
        final Users currentUser = getCurrentUser();

        if (currentUser != null && currentUser.getAuthorities().parallelStream().anyMatch(p -> p.getName().equals(EnumPermission.MANAGER))) {
            return true;
        }
        return false;
    }

    public static boolean isSeller() {
        final UserDao currentUser = getCurrentUser();

        if (currentUser != null && currentUser.getAuthorities().parallelStream().anyMatch(p -> p.getName().equals(EnumPermission.SELLER))) {
            return true;
        }
        return false;
    }

    public static boolean isUser() {
        final UserDao currentUser = getCurrentUser();

        if (currentUser != null && currentUser.getAuthorities().parallelStream().anyMatch(p -> p.getName().equals(EnumPermission.USER))) {
            return true;
        }
        return false;
    }

    public static boolean isUser(final UserDao currentUser) {
        if (currentUser != null && currentUser.getAuthorities().parallelStream().anyMatch(p -> p.getName().equals(EnumPermission.USER))) {
            return true;
        }
        return false;
    }

 */
}
