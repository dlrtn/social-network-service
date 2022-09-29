package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userMapper.existsByUsername(username)) {
            throw new UsernameNotFoundException("Can't find user");
        }
        return userMapper.findByUsername(username);
    }

}
