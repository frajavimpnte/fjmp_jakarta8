package fjmp.jkee8ch05programmsecurity2;
/*
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApplicationScoped
public class AuthenticationMechanism implements HttpAuthenticationMechanism {

    @Inject
    private UserIdentityStore identityStore;
    
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {

        if (httpMessageContext.isAuthenticationRequest()) {

            Credential credential = httpMessageContext.getAuthParameters().getCredential();
            if (!(credential instanceof UsernamePasswordCredential)) {
                throw new IllegalStateException("Invalid mechanism");
            }

            return httpMessageContext.notifyContainerAboutLogin(identityStore.validate(credential));
        }

        return httpMessageContext.doNothing();
    }

}
*/

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FJMP <frajavimopu@gmail.com>
 */

@ApplicationScoped
public class AuthenticationMechanism implements HttpAuthenticationMechanism{
    @Inject
    private UserIdentityStore identityStore;
    
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request,
            HttpServletResponse response, HttpMessageContext httpMessageContext)
                throws AuthenticationException {
        
        
        System.out.println("in AuthMechanism: --------------------------------");
        System.out.println("httpMessageContext.isAuthenticationRequest():-------------------" + httpMessageContext.isAuthenticationRequest());
        if (httpMessageContext.isAuthenticationRequest()) {
            
            System.out.println("AuthMechanism:httpMessageContext.isAuthenticationRequest() --------------------------------");
            
            Credential credential = httpMessageContext.getAuthParameters().getCredential();
            
            System.out.println("AuthMechanism:httpMessageContext.isAuthenticationRequest()2 --------------------------------");
            
            if (!(credential instanceof UsernamePasswordCredential)) {
                throw new IllegalStateException("Invalid mechanism");
            }
            
            System.out.println("AuthMechanism:httpMessageContext.isAuthenticationRequest() 3--------------------------------");
            return httpMessageContext.notifyContainerAboutLogin(
                    (identityStore.validate(credential)));
        }
        
        System.out.println("out AuthMechanism: --------------------------------");
        return httpMessageContext.doNothing();
    }
}
