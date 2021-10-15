package com.alexande.realestateexam.configure;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyWebFilter extends OncePerRequestFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(MyWebFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        // parse header
        String authenticationHeader = request.getHeader("Authorization");

        // checks if token is there
        if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")) {
            chain.doFilter(request,response);
            return;
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing token!");
        }


        FirebaseToken decodedToken = null;
        try {
            //Extracts token from header
            String token = authenticationHeader.substring(7);
            //verifies token to firebase server
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        }
        catch (FirebaseAuthException e) {
            LOGGER.info("Invalid token! Token has expired!");
            return;
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Error! "+e.toString());
        }

        // if token is invalid
        if (decodedToken == null){
            LOGGER.info("Invalid token!");
            return;
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid token!");
        }

        // if token is valid
        CustomPrincipal customPrincipal = new CustomPrincipal();
        customPrincipal.setUid(decodedToken.getUid());
        customPrincipal.setEmail((String) decodedToken.getClaims().get("email"));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                customPrincipal, decodedToken, null
        );
        LOGGER.info("Successfully verified token");
        LOGGER.info("Token: " + authenticationHeader);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request,response);
    }
}


