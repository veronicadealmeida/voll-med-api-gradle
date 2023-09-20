package eduvdavollmedapi.controller;

import eduvdavollmedapi.DTO.DadosAutenticacao;
import eduvdavollmedapi.DTO.DadosTokenJWT;
import eduvdavollmedapi.model.Usuario;
import eduvdavollmedapi.service.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", maxAge = 3600)
@SecurityRequirement(name = "bearer-key")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(dados.login().trim(), dados.senha().trim());

        var authentication = manager.authenticate(authenticationTokentoken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
