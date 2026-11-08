## SPRING SECURITY
=================================================
- Spring security is the authentication framework that adds security layer to webapps and APIs by handling authentication, authorization 
and session security context management.

The important terminology of the spring security:
=================================================
- Authentication - it is the process of identifying the user
- Authorization - is the process of determining the-what the user can access within application
- SecurityContext - is the object that holds the Authentication object
- SecurityContextHolder - is the container that holds the security context
- GrantedAuthority - are the permissions for the user who are accessing the application
- Role - is a special authority [ROLE_USER, ROLE_ADMIN etc.]
- Principal - is the object that holds the user information like username etc.
- Credentials - the sensitive segments of the user information is called credentials.
- Filter - a servlet component that intercepts before the request reaches the controller
- FilterChain - the sequence/chain of filters, each filter has it own job to do

Different Types of Filters in FilterChain:
=================================================
As we know that filter chain contains the chain of filters, the purpose of each filters as follows

SecurityContextHolderFilter:
=================================================
The main purpose of the filter is to load the security context to the current application-session.

UsernamePasswordAuthenticationFilter:
=================================================
the purpose of this filter is to authenticate the currently logged in user, it actually creates a 
authentication process to check the user really exists in the application resources (likely DB).

    AuthenticationManager:
    =================================================
    This object is boss of the authentication which manages the authentication/verification, it request the authentication 
    provider to verify the current user who is trying to login is actually exists in application resources (DB).

    AuthenticationProvider:
    =================================================
    This object actually does the verification, it invokes the UserDetailsService to check the user exists in the DB.

    UserDetailsService:
    =================================================
    This will fetch the user from the database, and returns the UserDetails info, if user exists in DB the SecurityContext
    gets updated, else username not found exception will be thrown.


AuthorizationFilter:
=================================================
THis filter will actually verifies that the logged in user has the proper permissions to actually access the resources which he is 
requesting.

.authorizeHttpRequest()
.hasRole()

ExceptionTranslationFilter:
=================================================
THis filter is responsible to handle the exceptions and tramismit the proper HTTP response based code (which is user-friendly translation
of error).

Important Components in Spring Security:
=================================================

SecurityContext:
=================================================
This is the object that actually stores the authentication object inside it.
Authentication Object
    -> Principal
    -> Credentials
    -> Roles
    -> Authorities
    -> isAuthenticated (status)

PasswordEncoder:
=================================================
This bean uses the BCryptPasswordEncoder object that can be injected into spring context
so that we cna encode the sensitive information like password or tokens or etc.

Important Annotations:
=================================================
@EnableSpringSecurity (this loads the WebSecurityConfiguration.class, HttpSecurityConfiguration.class)
@Bean
