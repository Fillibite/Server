package com.example.hackathon.global.auth.oauth2;

import com.example.hackathon.domain.user.entity.User;
import com.example.hackathon.domain.user.repository.UserRepository;
import com.example.hackathon.global.auth.PrincipalDetails;
import com.example.hackathon.global.auth.oauth2.provider.GoogleUserInfo;
import com.example.hackathon.global.auth.oauth2.provider.KakaoUserInfo;
import com.example.hackathon.global.auth.oauth2.provider.Oauth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("[loadUser] 입장");
        OAuth2User oAuth2User = super.loadUser(userRequest);

        return processOAuth2User(userRequest, oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        log.info("[processOAuth2User] 입장");
        Oauth2UserInfo oAuth2UserInfo = null;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            log.info("[PrincipalOauth2UserService] 구글 소셜 로그인 시도");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
            log.info("[PrincipalOauth2UserService] 카카오 소셜 로그인 시도");
            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        }
        else {
            log.info("[PrincipalOauth2UserService] 제공하지 않는 소셜 로그인 입니다.");
        }

        String userInfoEmail = oAuth2UserInfo.getEmail();
        String userInfoName = oAuth2UserInfo.getName();
        String userInfoImg = oAuth2UserInfo.getImg();

        log.info("userInfoEmail: {}", userInfoEmail);
        log.info("userInfoName: {}", userInfoName);
        log.info("userInfoImg: {}", userInfoImg);

        User user = userRepository.findByUserEmail(userInfoEmail)
                .orElse(null);

        if (user != null) {
            log.info("로그인을 이미 했음, 자동 회원가입이 되어있다.");
        }  else {
            user = User.builder()
                    .userEmail(userInfoEmail)
                    .userName(userInfoName)
                    .role("ROLE_USER")
//                    .userPassword(null)
//                    .provider(oAuth2UserInfo.getProvider())
//                    .providerId(oAuth2UserInfo.getProviderId())
                    .build();
            userRepository.save(user);
        }

        return new PrincipalDetails(user, oAuth2User.getAttributes());
    }
}
