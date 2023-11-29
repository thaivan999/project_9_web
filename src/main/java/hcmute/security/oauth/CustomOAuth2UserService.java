//Lớp này mở rộng DefaultOAuth2UserService để tạo ra một phiên bản custom của OAuth2User, giúp bạn có thể thực hiện bất kỳ xử lý tùy chỉnh nào sau khi thông tin người dùng được lấy từ OAuth2 providei
package hcmute.security.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService  {

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User user =  super.loadUser(userRequest);
		System.out.println("CustomOAuth2UserService invoked");
		return new CustomOAuth2User(user);
	}

}
