package com.jwt.jwtauthentication.controller;


import com.jwt.jwtauthentication.helper.JwtUtil;
import com.jwt.jwtauthentication.model.JwtResponse;
import com.jwt.jwtauthentication.model.JwtRquest;
import com.jwt.jwtauthentication.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRquest jwtRquest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRquest.getUsername(),jwtRquest.getPassword()));

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");


        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }


        UserDetails userDetails= this.customUserDetailsService.loadUserByUsername(jwtRquest.getUsername());
         String token = this.jwtUtil.generateToken(userDetails);
           System.out.println("JWT"+token);

           return ResponseEntity.ok(new JwtResponse(token));


    }

}
