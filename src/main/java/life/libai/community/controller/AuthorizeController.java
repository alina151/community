package life.libai.community.controller;

import life.libai.community.dto.AccessTokenDto;
import life.libai.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client_id}")
    private String clientId;
    @Value("${github.client_secret}")
    private String clientSecret;
    @Value("${github.redirect_uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setClient_id("46a146c14e545a78a12d");
        accessTokenDto.setState(state);
        accessTokenDto.setClient_secret("bd64cf2cacad308e353138ed5866536c2a0ee5af");
        accessTokenDto.setRedirect_uri("http://localhost:8889/callback");
        githubProvider.getAccessToken(accessTokenDto);
        return "index";
    }
}
