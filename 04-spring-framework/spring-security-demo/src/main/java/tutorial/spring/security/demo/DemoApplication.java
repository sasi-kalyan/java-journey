package tutorial.spring.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
    Spring security provides the default security to spring applications, that can be customizable based
    on business requirements to secure the enterprise applications.

    Authentication - it is the process of identifying the user identity
    it asks who you are ?

    Authorization - it is the process of determining the user who logged-in have
    enough permissions to perfrom actions on the application endpoints.

    principal - the logged in user information is called prinicpal
    granted authorities - the permissions to do perform actions like READ, WRITE, DELETE etc..
    role - is a special authority USER. ADMIN ETC..
    credentials - the user info like username and password.

    Authentication Object - that contains the principal, rolse, authorities, authentication status information
    SecurityContext - it stores the user's information/authenticated information of specific user.
    SecurityContextHolder - it is the container to store the SecurityContext

    Filter - is an interceptor that handles the http request before it reaches the contoller.

    FilterChain - there a lot of chain of filters in spring security each one of them performs some kind
    of verification activity.


    Some of most important filters in spring security;

    UsernamePasswordAuthenticationFilter - one of the popular filteres that validates the user infomation exists in
    application DB.
    |
    Authentication Manager - this auth manager asks the auth provider to check the user exists in db.
    |
    AuthenticationProvider - this is the actual class that checks the user existance
    |
    UserDetailsService - an interface that pulls the user infomration from DB
    |
    DB
    |
    UserDetails - the class that holds hte user info like username, password, role etc...
    |
    return


    If AUTHENTICATION = success

    SecurityContextHolderFilter - loads the security context
    |
    SecurityContextHolder - its is a container that holds the security context information
    |
    SecurityContext - it holds the authentication object
    |
    Authenitcation - object that holds all user information

    AUTHORIZATION PHASE:

    AuthorizationFilter - that peforms the logged in user have right permissions to hit that sepcific
    end point

    ExceptionTranslationFilter - that handles the security exections

    Controller -> request allowed
 */

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/*
Request
   |
   V

[Authentication Phase]

UsernamePasswordAuthenticationFilter
            |
            V
AuthenticationManager
            |
            V
AuthenticationProvider
            |
            V
UserDetailsService
            |
            V
Database

Authentication Success
            |
            V
SecurityContextHolder
            |
            V
SecurityContext
            |
            V
Authentication

[Authorization Phase]

AuthorizationFilter
            |
      Allow/Deny

Controller

 */